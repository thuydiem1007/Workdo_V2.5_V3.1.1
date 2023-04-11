package test.HRM.establish.division;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import commons.setup;
import navigate.navigate;
import page.HRM.establish.P_category.CompanyPage;
import page.HRM.establish.P_division.DivisionPage;
import page.login.loginPage;

public class creatDivisionTest {
    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            CompanyPage ctgory = new CompanyPage(driver);
            DivisionPage dvsion = new DivisionPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigateHRM();
            ctgory.choseListEstablish("Phân ca");
            dvsion.select_Company();
            dvsion.select_Department();
            dvsion.table("Nguyễn Hải");
            dvsion.select_Shift(1, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
