package test.login;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import commons.setup;
import page.login.loginPage;

public class loginTest {
    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            loginPage lg = new loginPage(driver);
            lg.login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
