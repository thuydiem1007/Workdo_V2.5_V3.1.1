package test.HRM.establish.category.company;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.HRM.establish.P_category.CompanyPage;
import page.login.loginPage;

public class creatCompanyTest {
    int testcase;
    String title;

    public creatCompanyTest(int testcase, String title) {
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
            CompanyPage cpany = new CompanyPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigateHRM();
            Thread.sleep(500);
            cpany.navigationHRM_setup();
            // cpany.choseListEstablish("Hạng mục");
            cpany.btn_Company.click();
            cpany.btn_EditCompany.click();
            creatCompanyTest[] data = {
                    new creatCompanyTest(1, ""),
                    new creatCompanyTest(2, "TimiOffice"),
                    new creatCompanyTest(3, ""),
                    new creatCompanyTest(4, ""),
                    new creatCompanyTest(5, "Docommerc"),
            };
            for (int i = 0; i < data.length; i++) {
                System.out.println("Testcase: " + data[i].testcase);
                cpany.creat_Company(data[i].title);
                String tagline = lg.selecTagline();
                switch (tagline) {
                    case "Bạn chưa nhập tên hạng mục!":
                        lg.passed();
                        Thread.sleep(500);
                        lg.deleTagline();
                        break;
                    case "Bạn chưa chọn phòng ban!":
                        lg.passed();
                        Thread.sleep(500);
                        lg.deleTagline();
                        cpany.select_Department(4);
                        break;
                    case "Bạn chưa thêm quyền truy cập!":
                        lg.passed();
                        Thread.sleep(500);
                        lg.deleTagline();
                        cpany.chose_MemberCategory("dang diem");
                        cpany.icon_AddCompany.click();
                        break;
                    case "Lựu chọn đã tồn tại!":
                        lg.passed();
                        Thread.sleep(500);
                        lg.deleTagline();
                        cpany.txt_TitleCompany.clear();
                        break;

                    default:
                        // cpany.table("Docommerc");
                        cpany.btn_DoneCompany.click();
                        System.out.println("Tạo thành công công ty Docommerc");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
