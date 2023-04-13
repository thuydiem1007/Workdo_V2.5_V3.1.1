package test.HRM.establish.category.company;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.HRM.establish.P_category.CompanyPage;
import page.login.loginPage;

public class cuttingStrings {
    WebDriver driver;

    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            CompanyPage cpany = new CompanyPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigateHRM();
            Thread.sleep(500);
            cpany.navigationHRM_setup();
            Thread.sleep(500);
            cpany.btn_Company.click();
            cpany.btn_EditCompany.click();
            cpany.select_Department(2);
            String fullText = "└─ ATech";
            String targetText = fullText.substring(3);
            targetText.trim();
            System.out.println(targetText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
