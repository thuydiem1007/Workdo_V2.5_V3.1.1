package test.HRM.establish.shifts;

import java.time.Duration;
import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.HRM.establish.P_category.CompanyPage;
import page.HRM.shifts.ShiftPage;
import page.login.loginPage;

public class editShiftTest {
    int Testcase;
    String title;

    public editShiftTest(int Testcase, String title) {
        this.Testcase = Testcase;
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
            crShift.btn_EditShift.click();
            editShiftTest[] data = {
                    new editShiftTest(1, ""),
                    new editShiftTest(2, "Ca hành chính"),
                    new editShiftTest(3, ""),
                    new editShiftTest(4, ""),
                    new editShiftTest(5, "")
            };
            crShift.txt_TitleShift.clear();
            for (int i = 0; i < data.length; i++) {
                System.out.println("Testcase " + data[i].Testcase);
                crShift.edit_Shiftsuccess(data[i].title);
                String tagline = lg.selecTagline();
                switch (tagline) {
                    case "Bạn chưa nhập tên ca làm việc!":
                        lg.passed();
                        lg.deleTagline();
                        crShift.change_selectStTime(0);
                        break;
                    case "Bạn chưa chọn giờ bắt đầu!":
                        lg.passed();
                        lg.deleTagline();
                        crShift.change_selectStTime(4);
                        crShift.change_selectEndTime(0);
                        break;
                    case "Bạn chưa nhập giờ kết thúc!":
                        lg.passed();
                        lg.deleTagline();
                        crShift.change_selectEndTime(6);
                        crShift.txt_Number.clear();
                        break;
                    case "Bạn chưa nhập số công!":
                        lg.passed();
                        lg.deleTagline();
                        crShift.txt_Number.sendKeys("0.5");
                        break;
                    case "Chỉnh sửa ca làm thành công":
                        System.out.println("Đã hoàn thành chỉnh sửa ca làm ");
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
