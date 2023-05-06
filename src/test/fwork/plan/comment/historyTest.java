package test.fwork.plan.comment;

import org.openqa.selenium.WebDriver;
import commons.setup;
import navigate.navigate;
import page.fwork.comment.historyPage;
import page.fwork.plan.editPlanPage;
import page.fwork.task.editTaskPage;
import page.fwork.work.creatWorkPage;
import page.login.loginPage;

public class historyTest {
    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            editPlanPage plan = new editPlanPage(driver);
            creatWorkPage work = new creatWorkPage(driver);
            editTaskPage editTask = new editTaskPage(driver);
            historyPage history = new historyPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigatefWork();
            plan.chosePlan();
            Thread.sleep(500);
            work.btnWork.click();
            lg.waitForElementToBeClickable(driver, work.btnWork, 2);
            editTask.choseTask();
            history.history();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
