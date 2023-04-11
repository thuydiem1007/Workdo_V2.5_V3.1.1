package test.HRM.establish.location;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.HRM.establish.P_category.CompanyPage;
import page.HRM.establish.P_location.LocationPage;
import page.login.loginPage;

public class editLocationTest {
    int testcase;
    String title;

    public editLocationTest(int testcase, String title) {
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
            CompanyPage ctgory = new CompanyPage(driver);
            LocationPage ctlocation = new LocationPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigateHRM();
            Thread.sleep(500);
            ctgory.choseListEstablish("Địa điểm");
            ctlocation.icon_EditLocation.click();
            editLocationTest[] data = {
                    new editLocationTest(1, ""),
                    new editLocationTest(2, "Công ty Seodo"),
                    new editLocationTest(3, ""),
                    new editLocationTest(4, ""),
                    new editLocationTest(5, ""),
                    new editLocationTest(6, "")
            };
            ctlocation.txt_TitleLocation.clear();
            for (int i = 0; i < data.length; i++) {
                System.out.println("Testcase: " + data[i].testcase);
                ctlocation.edit_Locationsuccess(data[i].title);
                String tagline = lg.selecTagline();
                switch (tagline) {
                    case "Bạn chưa nhập tiêu đề địa điểm!":
                        lg.passed();
                        lg.deleTagline();
                        ctlocation.txt_Latitude.clear();
                        break;
                    case "Bạn chưa nhập vĩ độ!":
                        lg.passed();
                        lg.deleTagline();
                        Thread.sleep(500);
                        ctlocation.txt_Latitude.sendKeys("21.001499857197263");
                        ctlocation.txt_Longitude.clear();
                        break;
                    case "Bạn chưa nhập kinh độ!":
                        lg.passed();
                        lg.deleTagline();
                        ctlocation.txt_Longitude.sendKeys("105.82257868429822");
                        ctlocation.txt_Radius.clear();
                        break;
                    case "Bạn chưa nhập bán kính chấm công!":
                        lg.passed();
                        lg.deleTagline();
                        ctlocation.txt_Radius.sendKeys("100");
                        ctlocation.icon_DeleCompany.click();
                        break;
                    case "Bạn chưa chọn công ty áp dụng!":
                        lg.passed();
                        lg.deleTagline();
                        ctlocation.select_Company();
                        break;
                    case "Chỉnh sửa địa điểm chấm công thành công!":
                        lg.passed();
                        break;

                    default:
                        lg.failed();
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
