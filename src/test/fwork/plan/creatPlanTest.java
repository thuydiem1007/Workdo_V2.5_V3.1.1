
package test.fwork.plan;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.fwork.plan.*;
import page.login.loginPage;

public class creatPlanTest {
    int testcase;
    String title;

    public creatPlanTest(int testcase, String title) {
        this.testcase = testcase;
        this.title = title;
    }

    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            creatPlanPage plan = new creatPlanPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigatefWork();
            plan.addplan.click();
            creatPlanTest[] data = {
                    new creatPlanTest(1, ""),
                    new creatPlanTest(2, "Kế hoạch tháng 3"),
                    new creatPlanTest(3, "Kế hoạch tháng 3")
            };
            plan.delUser();
            for (int i = 0; i < data.length; i++) {
                plan.txtTitle.clear();
                System.out.println("========================");
                System.out.println("Testcase: " + data[i].testcase);
                plan.txtTitle.sendKeys(data[i].title);
                Thread.sleep(500);
                plan.btnDonePlan.click();
                Thread.sleep(500);
                String tagline = lg.selecTagline();
                switch (tagline) {
                    case "Bạn chưa nhập tiêu đề kế hoạch.":
                        lg.passed();
                        break;

                    case "Kế hoạch chưa có thành viên.":
                        lg.passed();
                        plan.addUser();
                        break;
                    default:
                        if (tagline.contains("Đã tạo kế hoạch")) {
                            lg.passed();
                        } else {
                            lg.failed();
                        }
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
