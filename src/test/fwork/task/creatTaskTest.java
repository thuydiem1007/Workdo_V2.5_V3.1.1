package test.fwork.task;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.fwork.plan.editPlanPage;
import page.fwork.task.creatTaskPage;
import page.fwork.work.creatWorkPage;
import page.login.loginPage;

public class creatTaskTest {
    int testcase;
    String title;

    public creatTaskTest(int testcase, String title) {
        this.testcase = testcase;
        this.title = title;
    }

    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            editPlanPage editPlan = new editPlanPage(driver);
            creatWorkPage creatWork = new creatWorkPage(driver);
            creatTaskPage creatTask = new creatTaskPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigatefWork();
            editPlan.chosePlan();
            Thread.sleep(500);
            creatWork.btnWork.click();
            creatTask.Work();
            creatTask.choseOptions();
            creatTaskTest[] data = {
                    new creatTaskTest(1, ""),
                    new creatTaskTest(2, "Xây dựng lịch trình và thành viên tham dự"),
                    new creatTaskTest(3, ""),
                    new creatTaskTest(4, "")
            };
            creatTask.iconCreatTask.click();
            Thread.sleep(1000);
            for (int i = 0; i < data.length; i++) {
                System.out.println("Testcase: " + data[i].testcase);
                creatTask.taskSuccess(data[i].title);
                Thread.sleep(1000);
                switch (lg.selecTagline()) {
                    case "Nhập tiêu đề của công việc":
                        lg.passed();
                        Thread.sleep(500);
                        break;
                    case "Nhập thời gian thực hiện của công việc.":
                        lg.passed();
                        creatTask.iconDateTask.click();
                        creatTask.choseDateLeft();
                        creatTask.choseDateRight();
                        creatTask.btnConfirmDateTask.click();
                        Thread.sleep(1000);
                        lg.deleTagline();
                        break;
                    case "Chọn người tham gia của công việc.":
                        lg.passed();
                        creatTask.iconMember.click();
                        Thread.sleep(500);
                        creatTask.iconAddMember.click();
                        Thread.sleep(500);
                        creatTask.btnDoneAddMember.click();
                        Thread.sleep(500);
                        // creatTask.btnDoneTask.click();
                        // Thread.sleep(500);
                        lg.deleTagline();
                        break;

                    default:
                        Thread.sleep(500);
                        if (creatTask.titleTask().equals(data[2].title)) {
                            System.out.println("Hoàn Thành tạo công việc phụ");
                            lg.passed();
                        } else {
                            lg.failed();
                        }
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
