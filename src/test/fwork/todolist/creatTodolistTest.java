package test.fwork.todolist;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.fwork.plan.editPlanPage;
import page.fwork.todolist.creatTodolistPage;
import page.fwork.work.creatWorkPage;
import page.login.loginPage;

public class creatTodolistTest {
    int testcase;
    String title;

    public creatTodolistTest(int testcase, String title) {
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
            editPlanPage plan = new editPlanPage(driver);
            creatWorkPage work = new creatWorkPage(driver);
            creatTodolistPage crTodolist = new creatTodolistPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigatefWork();
            plan.chosePlan();
            Thread.sleep(300);
            work.btnWork.click();
            crTodolist.choseTask_creatTodolist();
            crTodolist.btnTodolist.click();
            Thread.sleep(500);
            // crTodolist.creatTodolist();
            creatTodolistTest[] data = {
                    new creatTodolistTest(1, ""),
                    new creatTodolistTest(2, "Listout các công việc cần làm trong dự án"),
                    new creatTodolistTest(3, "")
            };
            crTodolist.iconTodolist.click();
            Thread.sleep(500);
            for (int i = 0; i < data.length; i++) {
                // System.out.println("Testcase: " + data[i].testcase);
                crTodolist.creatTodolistSuccess(data[i].title);
                Thread.sleep(500);
                String tagline = lg.selecTagline();
                switch (tagline) {
                    case "Nhập tiêu đề của Todolist":
                        lg.passed();
                        Thread.sleep(500);
                        lg.deleTagline();
                        break;
                    case "Chọn ngày tạo Todolist":
                        lg.passed();
                        Thread.sleep(300);
                        crTodolist.dpkTodolist.click();
                        crTodolist.choseDateLeft("20");
                        crTodolist.choseDateLeft("22");
                        Thread.sleep(500);
                        crTodolist.btnDoneDatepickerTask.click();
                        crTodolist.btnDoneTodolist.click();
                        break;

                    default:
                        // crTodolist.btnDoneTodolist.click();
                        Thread.sleep(300);
                        if (tagline.contains("Đã tạo Todolist liên kết với công việc")) {
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
