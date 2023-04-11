package test.fwork.work;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import commons.setup;
import navigate.navigate;
import page.fwork.plan.editPlanPage;
import page.fwork.work.creatWorkPage;
import page.login.loginPage;

public class deleWorkTest {
    static WebDriver driver;

    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            editPlanPage plan = new editPlanPage(driver);
            creatWorkPage work = new creatWorkPage(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Thread.sleep(500);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigatefWork();
            plan.chosePlan();
            work.choseWork("Họp và trình bày các nội dung các công việc cần triển khai của dự án fWork");
            work.deleWork();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
