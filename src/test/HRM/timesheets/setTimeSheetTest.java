package test.HRM.timesheets;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.HRM.setupHRM.setupHRMPage;
import page.HRM.timesheets.timeSheetPage;
import page.login.loginPage;

public class setTimeSheetTest {
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
            Thread.sleep(500);
            tmSheet.icon_Setting.click();
            tmSheet.txt_Setting.clear();
            tmSheet.txt_Setting.sendKeys("21");
            tmSheet.btn_DoneDetail.click();
            System.out.println("Đã thiết lập thành công công chuẩn tháng");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
