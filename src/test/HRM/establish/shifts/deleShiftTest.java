package test.HRM.establish.shifts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.HRM.establish.P_category.CompanyPage;
import page.HRM.shifts.ShiftPage;
import page.login.loginPage;

public class deleShiftTest {
    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            CompanyPage ctgory = new CompanyPage(driver);
            ShiftPage shift = new ShiftPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigateHRM();
            Thread.sleep(500);
            ctgory.choseListEstablish("Ca làm");
            shift.table_Shift("Ca hành chính", 1);
            Thread.sleep(500);
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
