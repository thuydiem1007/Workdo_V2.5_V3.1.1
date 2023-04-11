package test.fwork.plan;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.fwork.plan.editPlanPage;
import page.login.loginPage;

public class editPlanTest {

    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            editPlanPage editPlan = new editPlanPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigatefWork();
            editPlan.chosePlan();
            editPlan.editPlan();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
