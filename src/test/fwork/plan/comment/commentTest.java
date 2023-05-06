package test.fwork.plan.comment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.fwork.comment.commentPage;
import page.fwork.plan.editPlanPage;
import page.fwork.task.editTaskPage;
import page.fwork.work.creatWorkPage;
import page.login.loginPage;

public class commentTest {
    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            editPlanPage plan = new editPlanPage(driver);
            creatWorkPage work = new creatWorkPage(driver);
            editTaskPage editTask = new editTaskPage(driver);
            commentPage cmTodolist = new commentPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigatefWork();
            plan.chosePlan();
            Thread.sleep(500);
            work.btnWork.click();
            editTask.choseTask();
            cmTodolist.commentTodolist();
            cmTodolist.deleComment();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
