package test.HRM.timekeeping;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.HRM.setupHRM.setupHRMPage;
import page.HRM.timkeeping.timekeppingPage;
import page.login.loginPage;

public class timeKeepingTest {
    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            setupHRMPage HRM = new setupHRMPage(driver);
            timekeppingPage kping = new timekeppingPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigateHRM();
            nav.waitForPageLoaded();
            HRM.HRM_Timekeeping();
            kping.table_HistoryTimekepping("T2 - 27/03/2023", 0);
            System.out.println("Xem lịch sử chấm công thành công");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
