package test.fwork.work;

import org.openqa.selenium.WebDriver;
import java.time.Duration;
import commons.setup;
import navigate.navigate;
import page.fwork.plan.editPlanPage;
import page.fwork.work.creatWorkPage;
import page.login.loginPage;

public class creatWorkTest {
    int testcase;
    String title;

    public creatWorkTest(int testcase, String title) {
        this.testcase = testcase;
        this.title = title;
    }

    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            // WebDriver wait = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            editPlanPage plan = new editPlanPage(driver);
            creatWorkPage task = new creatWorkPage(driver);
            Thread.sleep(500);
            lg.loginSuccess();
            Thread.sleep(500);
            nav.waitForPageLoaded();
            nav.navigatefWork();
            Thread.sleep(500);
            plan.chosePlan();
            creatWorkTest[] data = {
                    new creatWorkTest(1, ""),
                    new creatWorkTest(2, "Họp và trình bày các nội dung các công việc cần triển khai của dự án fWork"),
                    new creatWorkTest(3, "Họp và trình bày các nội dung các công việc cần triển khai của dự án fWork"),
                    new creatWorkTest(4, "")
            };
            Thread.sleep(2000);
            task.btnWork.click();
            Thread.sleep(500);
            task.btnCreatWorkNew.click();
            Thread.sleep(500);
            for (int i = 0; i < data.length; i++) {
                // System.out.println("========================");
                System.out.println("Testcase: " + data[i].testcase);
                task.creat_WorkSuccess(data[i].title);
                Thread.sleep(500);
                switch (lg.selecTagline()) {
                    case "Nhập tiêu đề của công việc!":
                        lg.passed();
                        break;
                    case "Nhập thời gian thực hiện của công việc!":
                        lg.passed();
                        task.txtTitleWork.clear();
                        task.btnStartDay.click();
                        task.datePicker("8");
                        Thread.sleep(500);
                        task.doneDatePicker();
                        break;
                    case "Chưa chọn nhóm của công việc!":
                        lg.passed();
                        Thread.sleep(500);
                        task.btnSelectGroupWork.click();
                        Thread.sleep(500);
                        task.txtSelectGroupWork.sendKeys("Giai đoạn 1");
                        Thread.sleep(500);
                        task.btnDoneAddGroupWork.click();
                        break;
                    case "Đã tạo công việc thành công!":
                        lg.passed();
                        break;
                    default:
                        lg.failed();
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
