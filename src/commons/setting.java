package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class setting {
    private static WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            // Khởi tạo driver ở đây, ví dụ: ChromeDriver
            driver = new ChromeDriver();
            driver.navigate().to("https://work.conando.vn");
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
