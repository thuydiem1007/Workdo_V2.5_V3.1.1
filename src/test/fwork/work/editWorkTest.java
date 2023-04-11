package test.fwork.work;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.fwork.plan.editPlanPage;
import page.fwork.work.creatWorkPage;
import page.fwork.work.editWorkPage;
import page.login.loginPage;

public class editWorkTest {
    int testcase;
    String title;

    public editWorkTest(int testcase, String title) {
        this.testcase = testcase;
        this.title = title;
    }

    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            editPlanPage plan = new editPlanPage(driver);
            creatWorkPage creatWork = new creatWorkPage(driver);
            editWorkPage editWork = new editWorkPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigatefWork();
            plan.chosePlan();
            nav.waitForPageLoaded();
            creatWork.choseWork("Họp và trình bày các nội dung các công việc cần triển khai của dự án fWork");
            nav.waitForPageLoaded();
            Thread.sleep(500);
            editWorkTest[] data = {
                    new editWorkTest(1, ""),
                    new editWorkTest(2, "Họp và trình bày các nội dung các công việc cần triển khai của dự án fWork"),
            };
            creatWork.txtTitleWork.clear();
            for (int i = 0; i < data.length; i++) {
                System.out.println("Testcase: " + data[i].testcase);
                editWork.edit_WorkSuccess(data[i].title);
                switch (lg.selecTagline()) {
                    case "Nhập tiêu đề của công việc!":
                        lg.passed();
                        Thread.sleep(500);
                        lg.btnDeltagline.click();
                        creatWork.choseStatus();
                        break;

                    case "Đã cập nhật thông tin công việc!":
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
