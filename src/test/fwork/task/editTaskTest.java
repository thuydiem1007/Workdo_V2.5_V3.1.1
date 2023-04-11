package test.fwork.task;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.fwork.plan.editPlanPage;
import page.fwork.task.creatTaskPage;
import page.fwork.task.editTaskPage;
import page.fwork.work.creatWorkPage;
import page.login.loginPage;

public class editTaskTest {
    int testcase;
    String title;

    public editTaskTest(int testcase, String title) {
        this.testcase = testcase;
        this.title = title;
    }

    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            editPlanPage plan = new editPlanPage(driver);
            creatWorkPage work = new creatWorkPage(driver);
            creatTaskPage crTask = new creatTaskPage(driver);
            editTaskPage editTask = new editTaskPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigatefWork();
            plan.chosePlan();
            Thread.sleep(500);
            work.btnWork.click();
            crTask.iconArowRight.click();
            // editTask.choseTask();
            Thread.sleep(500);
            editTask.t1.click();
            crTask.btnOptionsEdit.click();
            crTask.btnEditTask.click();
            crTask.txtTitleTask.clear();
            editTask.removeUser();
            editTaskTest[] data = {
                    new editTaskTest(1, ""),
                    new editTaskTest(2, "Xây dựng lịch trình và thành viên tham dự"),
                    new editTaskTest(3, "")
            };
            for (int i = 0; i < data.length; i++) {
                System.out.println("Testcase: " + data[i].testcase);
                editTask.editTasksuccess(data[i].title);
                Thread.sleep(500);
                switch (lg.selecTagline()) {
                    case "Nhập tiêu đề công của công việc":
                        lg.passed();
                        Thread.sleep(500);
                        lg.deleTagline();
                        break;
                    case "Chọn người tham gia của công việc.":
                        lg.passed();
                        Thread.sleep(500);
                        lg.deleTagline();
                        editTask.addUser();
                        Thread.sleep(500);
                        // crTask.btnDoneTask.click();
                        break;

                    default:
                        Thread.sleep(500);
                        if (crTask.titleTask().equals(data[2].title)) {
                            System.out.println("Đã chỉnh sửa công việc phụ thành công");
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
