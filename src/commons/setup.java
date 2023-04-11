package commons;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import navigate.navigate;

public class setup {
    private WebDriver driver;

    // public WebDriver getDriver() {
    // return driver;
    // }

    public WebDriver initChorme() {
        // Cách 1:
        // WebDriver driver = new ChromeDriver();
        // driver.navigate().to("https://work.conando.vn");
        // driver.manage().window().maximize();
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        // return driver;
        // Cách 2:
        navigate index = new navigate(driver);
        ChromeOptions useragent = new ChromeOptions();
        useragent.addArguments("disable-notifications");
        useragent.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(useragent);
        driver.manage().window().maximize();
        driver.navigate().to("https://work.conando.vn/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        index.waitForPageLoaded();
        return driver;
    }
}
