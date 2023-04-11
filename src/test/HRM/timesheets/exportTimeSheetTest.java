package test.HRM.timesheets;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.setup;
import navigate.navigate;
import page.HRM.setupHRM.setupHRMPage;
import page.HRM.timesheets.timeSheetPage;
import page.login.loginPage;

public class exportTimeSheetTest {
    public static void main(String[] args) {
        try {
            setup setup = new setup();
            // WebDriver driver = new ChromeDriver();
            WebDriver driver = setup.initChorme();
            timeSheetPage tmSheet = new timeSheetPage(driver);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            setupHRMPage HRM = new setupHRMPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigateHRM();
            nav.waitForPageLoaded();
            HRM.HRM_TimeSheets();
            String downloadPath = "C:\\Users\\admin\\Downloads\\";
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("download.default_directory", downloadPath);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            prefs.put("profile.default_content_settings.popups", 0);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);

            File[] files = new File(downloadPath).listFiles();
            File file = new File(downloadPath);

            tmSheet.icon_FileDowload.click();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until((ExpectedCondition<Boolean>) driverr -> {
                String js = "return document.readyState";
                return ((JavascriptExecutor) driver).executeScript(js).toString().equals("complete");
            });
            wait = new WebDriverWait(driver, Duration.ofSeconds(25));
            wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.xpath("//p[contains(text(),'Bạn đã export file bảng công thành công!')]")));

            for (File downloadedFile : files) {
                if (downloadedFile.isFile() && downloadedFile.getName().endsWith("xlsx")) {
                    file = downloadedFile;
                    break;
                }
            }

            String absoluteFilePath = file.getAbsolutePath();

            System.out.println(absoluteFilePath);
            System.out.println("OK");

            // Bạn đã export file bảng công thành công!
            // p[contains(text(),'Bạn đã export file bảng công thành công!')]
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
