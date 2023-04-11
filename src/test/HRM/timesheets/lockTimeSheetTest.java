package test.HRM.timesheets;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.HRM.setupHRM.setupHRMPage;
import page.HRM.timesheets.timeSheetPage;
import page.login.loginPage;

public class lockTimeSheetTest {
    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            setupHRMPage HRM = new setupHRMPage(driver);
            timeSheetPage tmSheet = new timeSheetPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigateHRM();
            nav.waitForPageLoaded();
            HRM.HRM_TimeSheets();
            tmSheet.icon_Lock.click();
            Thread.sleep(500);
            tmSheet.btn_CancelLock.click();
            System.out.println("Đã huỷ khoá bảng công");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
