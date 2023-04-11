package test.HRM.establish.shifts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.HRM.establish.P_category.CompanyPage;
import page.HRM.shifts.ShiftPage;
import page.login.loginPage;

public class creatShiftTest {
    int testcase;
    String title;

    public creatShiftTest(int testcase, String title) {
        this.testcase = testcase;
        this.title = title;
    }

    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            CompanyPage ctcompany = new CompanyPage(driver);
            ShiftPage crShift = new ShiftPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigateHRM();
            Thread.sleep(500);
            ctcompany.choseListEstablish("Ca làm");
            // crShift.creat_Shifts();
            crShift.btn_AddNewShift.click();
            creatShiftTest[] data = {
                    new creatShiftTest(1, ""),
                    new creatShiftTest(2, "Ca hành chính"),
                    new creatShiftTest(3, ""),
                    new creatShiftTest(4, ""),
                    new creatShiftTest(5, "")
            };
            for (int i = 0; i < data.length; i++) {
                System.out.println("Testcase: " + data[i].testcase);
                crShift.creat_Shiftsuccess(data[i].title);
                String tagline = lg.selecTagline();
                switch (tagline) {
                    case "Bạn chưa nhập tên ca làm việc!":
                        lg.passed();
                        lg.deleTagline();
                        break;
                    case "Bạn chưa chọn giờ bắt đầu!":
                        lg.passed();
                        lg.deleTagline();
                        crShift.change_selectStTime(3);
                        break;
                    case "Bạn chưa nhập giờ kết thúc!":
                        lg.passed();
                        lg.deleTagline();
                        crShift.change_selectEndTime(4);
                        break;
                    case "Bạn chưa nhập số công!":
                        lg.passed();
                        lg.deleTagline();
                        crShift.txt_Number.clear();
                        crShift.txt_Number.sendKeys("0.5");
                        break;
                    case "Tạo ca làm thành công":
                        lg.passed();
                        break;

                    default:
                        lg.failed();
                        break;

                }
            }
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
