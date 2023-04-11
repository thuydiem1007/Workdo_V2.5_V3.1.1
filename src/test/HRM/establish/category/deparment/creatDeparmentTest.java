package test.HRM.establish.category.deparment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.HRM.establish.P_category.CompanyPage;
import page.HRM.establish.P_category.DeparmentPage;
import page.login.loginPage;

public class creatDeparmentTest {
    int testcase;
    String title;

    public creatDeparmentTest(int testcase, String title) {
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
            creatDeparmentTest[] data = {
                    new creatDeparmentTest(1, "BA"),
                    new creatDeparmentTest(2, ""),
                    new creatDeparmentTest(3, "DEV")
            };
            for (int i = 0; i < data.length; i++) {
                System.out.println(data[i].testcase);
                dpment.creat_Department(data[i].title);
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
                        lg.failed();
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
