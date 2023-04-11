package test.HRM.establish.category.company;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.HRM.establish.P_category.CompanyPage;
import page.login.loginPage;

public class editCompanyTest {
    int testcase;
    String title;

    public editCompanyTest(int testcase, String title) {
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
            cpany.choseListEstablish("Hạng mục");
            cpany.btn_Company.click();
            cpany.btn_EditCompany.click();
            cpany.select_Company("Docommerc");
            editCompanyTest[] data = {
                    new editCompanyTest(1, ""),
                    new editCompanyTest(2, "Docommerc"),
                    new editCompanyTest(3, ""),
                    new editCompanyTest(4, "")
            };
            cpany.txt_TitleCompany.clear();
            for (int i = 0; i < data.length; i++) {
                System.out.println("Testcase: " + data[i].testcase);
                cpany.edit_Company(data[i].title);
                String tagline = lg.selecTagline();
                switch (tagline) {
                    case "Bạn chưa nhập tên hạng mục!":
                        lg.passed();
                        Thread.sleep(500);
                        lg.deleTagline();
                        cpany.select_Department(0);
                        break;
                    case "Bạn chưa chọn phòng ban!":
                        lg.passed();
                        Thread.sleep(500);
                        lg.deleTagline();
                        cpany.select_Department(4);
                        cpany.icon_AddMember.click();
                        cpany.icon_AddRemoveMember.click();
                        cpany.btn_DoneMember.click();
                        break;
                    case "Bạn chưa thêm quyền truy cập!":
                        lg.passed();
                        Thread.sleep(500);
                        lg.deleTagline();
                        cpany.chose_MemberCategory("dang diem");
                        break;

                    default:
                        cpany.btn_DoneCompany.click();
                        System.out.println("Chỉnh sửa hạng mục công ty Docommerc thành công");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
