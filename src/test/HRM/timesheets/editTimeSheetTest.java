package test.HRM.timesheets;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.HRM.setupHRM.setupHRMPage;
import page.HRM.timesheets.timeSheetPage;
import page.login.loginPage;

public class editTimeSheetTest {
    // int testcase;
    // String title;

    // public editTimeSheetTest(int testcase, String title) {
    // this.testcase = testcase;
    // this.title = title;
    // }

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
            lg.waitForElementVisible(driver, tmSheet.icon_Edit, 3);
            tmSheet.icon_Edit.click();
            // TH1: Để trống lý do chỉnh sửa
            tmSheet.table("Nguyễn Hải");
            tmSheet.select_TimeSheet(1);
            tmSheet.btn_DoneDetail.click();
            if (lg.selecTagline().equals("Bạn chưa nhập lý do chỉnh sửa!")) {
                System.out.println("TC01: ");
                lg.passed();
                lg.deleTagline();
                // TH2: Chỉnh sửa bảng công thành công
                tmSheet.txa_EditReason
                        .sendKeys("Dữ liệu bảng công hiện tại không đúng với lịch sử chấm công đã thực hiện");
                tmSheet.btn_DoneDetail.click();
                Thread.sleep(500);
                tmSheet.btn_DoneEdit.click();
                if (lg.selecTagline().equals("Đã chỉnh sửa bảng công.")) {
                    System.out.println("TC02: ");
                    lg.passed();
                } else {
                    System.out.println("TC02: ");
                    lg.failed();
                }
            } else {
                System.out.println("TC01: ");
                lg.failed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
// "C:\Users\admin\OneDrive\Máy tính"