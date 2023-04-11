package test.HRM.timesheets;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import commons.setup;

import navigate.navigate;
import page.HRM.setupHRM.setupHRMPage;
import page.HRM.timesheets.timeSheetPage;
import page.login.loginPage;

public class exportTest {
    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            ChromeOptions options = new ChromeOptions();
            String downloadDir = "C:\\Users\\admin\\Downloads\\";
            options.addArguments("download.default_directory=" + downloadDir);
            // WebDriver driver = new ChromeDriver(options);
            timeSheetPage tmsheet = new timeSheetPage(driver);
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            setupHRMPage HRM = new setupHRMPage(driver);
            driver.navigate().to("https://work.conando.vn/");
            nav.waitForPageLoaded();
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigateHRM();
            nav.waitForPageLoaded();
            HRM.HRM_TimeSheets();
            tmsheet.icon_FileDowload.click();
            Thread.sleep(5000);
            File downloadFolder = new File(downloadDir);
            File[] files = downloadFolder.listFiles();
            File latestFile = new File(downloadDir);
            long lastMod = Long.MIN_VALUE;
            for (File file : files) {
                if (file.lastModified() > lastMod) {
                    latestFile = file;
                    lastMod = file.lastModified();
                }
            }
            String expectedFileName = ".xlsx";
            String actualFileName = latestFile.getName();
            System.out.println(actualFileName);
            if (actualFileName.contains(expectedFileName)) {
                System.out.println("Download and file name check successful.");
            } else {
                System.out.println("Error: Download and file name check failed.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
