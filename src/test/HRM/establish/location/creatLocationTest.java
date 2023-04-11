package test.HRM.establish.location;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.HRM.establish.P_category.CompanyPage;
import page.HRM.establish.P_location.LocationPage;
import page.login.loginPage;

public class creatLocationTest {
    int testcase;
    String title;

    public creatLocationTest(int testcase, String title) {
        this.testcase = testcase;
        this.title = title;
    }

    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            CompanyPage ctgory = new CompanyPage(driver);
            LocationPage ctlocation = new LocationPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigateHRM();
            Thread.sleep(500);
            ctgory.choseListEstablish("Địa điểm");
            ctlocation.btn_AddNew.click();
            creatLocationTest[] data = {
                    new creatLocationTest(1, ""),
                    new creatLocationTest(2, "Công ty Seodo"),
                    new creatLocationTest(3, ""),
                    new creatLocationTest(4, ""),
                    new creatLocationTest(5, ""),
                    new creatLocationTest(6, "")
            };
            for (int i = 0; i < data.length; i++) {
                System.out.println("Testcase " + data[i].testcase);
                ctlocation.creat_Locationsuccess(data[i].title);
                String tagline = lg.selecTagline();
                switch (tagline) {
                    case "Bạn chưa nhập tiêu đề địa điểm!":
                        lg.passed();
                        lg.deleTagline();
                        break;
                    case "Bạn chưa nhập vĩ độ!":
                        lg.passed();
                        lg.deleTagline();
                        ctlocation.txt_Latitude.sendKeys("21.001499857197263");
                        break;
                    case "Bạn chưa nhập kinh độ!":
                        lg.passed();
                        lg.deleTagline();
                        ctlocation.txt_Longitude.sendKeys("105.82257868429822");
                        break;
                    case "Bạn chưa nhập bán kính chấm công!":
                        lg.passed();
                        lg.deleTagline();
                        ctlocation.txt_Radius.sendKeys("100");
                        break;
                    case "Bạn chưa chọn công ty áp dụng!":
                        lg.passed();
                        lg.deleTagline();
                        ctlocation.select_Company();
                        break;
                    case "Tạo địa điểm chấm công thành công!":
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
