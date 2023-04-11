package test.fwork.task;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import commons.setup;
import navigate.navigate;
import page.fwork.plan.editPlanPage;
import page.fwork.task.creatTaskPage;
import page.fwork.work.creatWorkPage;
import page.login.loginPage;

public class deleTaskTest {
    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            // WebDriverWait wait = new WebDriverWait(driver, 10);
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
            Thread.sleep(1000);
            creatWork.btnWork.click();
            creatTask.iconArowRight.click();
            creatTask.deleTask();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
