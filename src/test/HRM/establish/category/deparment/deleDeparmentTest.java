package test.HRM.establish.category.deparment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.HRM.establish.P_category.CompanyPage;
import page.HRM.establish.P_category.DeparmentPage;
import page.login.loginPage;

public class deleDeparmentTest {
    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            CompanyPage ctgory = new CompanyPage(driver);
            DeparmentPage dpment = new DeparmentPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigateHRM();
            Thread.sleep(500);
            ctgory.choseListEstablish("Hạng mục");
            lg.waitForElementToBeClickable(driver, dpment.btn_Deparment, 5);
            dpment.btn_Deparment.click();
            dpment.btn_EditDeparment.click();
            dpment.table_ListDeparment();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
