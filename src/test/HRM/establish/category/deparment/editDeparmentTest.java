package test.HRM.establish.category.deparment;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.HRM.establish.P_category.CompanyPage;
import page.HRM.establish.P_category.DeparmentPage;
import page.login.loginPage;

public class editDeparmentTest {
    int testcase;
    String title;

    public editDeparmentTest(int testcase, String title) {
        this.testcase = testcase;
        this.title = title;
    }

    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            CompanyPage ctgory = new CompanyPage(driver);
            DeparmentPage dpment = new DeparmentPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigateHRM();
            Thread.sleep(500);
            ctgory.choseListEstablish("Hạng mục");
            dpment.btn_Deparment.click();
            dpment.btn_EditDeparment.click();
            System.out.println("Đã hoàn thành chọn Phòng ban");
            Thread.sleep(500);
            dpment.select_Deparmernt("DEV");
            editDeparmentTest[] data = {
                    new editDeparmentTest(1, "DEV"),
                    new editDeparmentTest(2, ""),
                    new editDeparmentTest(3, "DES")
            };
            dpment.txt_TitleDeparment.clear();
            for (int i = 0; i < data.length; i++) {
                System.out.println("Testcase " + data[i].testcase);
                dpment.edit_Department(data[i].title);
                String tagline = lg.selecTagline();
                switch (tagline) {
                    case "Lựu chọn đã tồn tại!":
                        lg.passed();
                        Thread.sleep(500);
                        lg.deleTagline();
                        dpment.txt_TitleDeparment.clear();
                        break;
                    case "Bạn chưa nhập tên hạng mục!":
                        lg.passed();
                        Thread.sleep(500);
                        lg.deleTagline();
                        break;

                    default:
                        dpment.btn_DoneDeparment.click();
                        System.out.println("Chỉnh sửa hạng mục phòng ban thành công");
                        lg.passed();
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
