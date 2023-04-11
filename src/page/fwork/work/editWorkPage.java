package page.fwork.work;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.login.loginPage;

public class editWorkPage {
    WebDriver driver;

    public editWorkPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void editWork() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            loginPage lg = new loginPage(driver);
            creatWorkPage creat = new creatWorkPage(driver);

            // TH1: Để trống title công việc
            creat.txtTitleWork.clear();
            creat.btnDoneWork.click();
            if (lg.selecTagline().equals("Nhập tiêu đề của công việc!")) {
                System.out.println("TC01: ");
                lg.passed();
                // TH2: Để trống user khi chỉnh sửa công việc
                creat.txtTitleWork
                        .sendKeys("Họp và trình bày các nội dung các công việc cần triển khai của dự án fWork");
                creat.iconAdduser.click();
                creat.txtFillUser.sendKeys("Thuý Diễm");
                creat.iconUser.click();
                Thread.sleep(1000);
                creat.btnDoneUser.click();
                Thread.sleep(1000);
                creat.btnDoneWork.click();
                Thread.sleep(1000);
                if (lg.selecTagline().equals("Chọn người tham gia của công việc!")) {
                    System.out.println("TC02: ");
                    lg.passed();
                    // TH3: Chỉnh sửa thành công công việc
                    creat.iconAdduser.click();
                    creat.txtFillUser.sendKeys("Thuý Diễm");
                    creat.iconUser.click();
                    creat.btnDoneUser.click();
                    Thread.sleep(1000);
                    creat.btnDoneWork.click();
                    Thread.sleep(1000);
                    if (lg.selecTagline().equals("Đã cập nhật thông tin công việc!")) {
                        System.out.println("TC03: ");
                        lg.passed();
                    } else {
                        System.out.println("TC03: ");
                        lg.failed();
                    }
                } else {
                    System.out.println("TC02:");
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

    public void edit_WorkSuccess(String title) {
        try {
            creatWorkPage creat = new creatWorkPage(driver);
            creat.txtTitleWork.sendKeys(title);
            Thread.sleep(500);
            creat.btnDoneWork.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
