package page.fwork.plan;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import page.login.loginPage;

public class editPlanPage {
    WebDriver driver;

    public editPlanPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Main
    @FindBy(id = "main")
    public WebElement main;
    // Icon xem kế hoạch đang diễn ra
    @FindBy(xpath = "//div[@class='scrolly px-3 pb-5']/a[2]/span[@class='icon is-small']")
    private WebElement ddlSeenPlan;
    // Nút chỉnh sửa kế hoạch
    @FindBy(xpath = "//a[@class='icon-text has-text-link']")
    public WebElement btnEditPlan;
    // Nút tuỳ chọn danh sách kế hoạch
    @FindBys(@FindBy(xpath = "//div/a[@class='has-text-info']"))
    private List<WebElement> listPlan;
    // Textbox mô tả tiêu đề kế hoạch
    @FindBy(id = "plan_detail")
    private WebElement txtTitleDescription;
    // Nút Cập nhật mô tả tiêu đề
    @FindBy(xpath = "//a[@class='button is-link is-small']")
    public WebElement btnDoneDescriptionTitle;
    // Nút dropdow bảo mật
    @FindBy(xpath = "//ul/li[6]/div[@class='dropdown is-hoverable']")
    private WebElement btnDrSecurity;
    // Trang Kế hoạch
    @FindBy(id = "page_fwork")
    private WebElement btnSection;
    // Nút dropdow trạng thái kế hoạch
    @FindBy(xpath = "//span[@class='icon is-small mr-2'][contains(.,'show_chart')]")
    private WebElement btnDrStatus;
    // Nút thời gian
    // @FindBy(xpath = "//span[.='dd/mm/yyyy']")
    // private WebElement btnDatepicker;
    // Icon chọn thời gian
    @FindBy(xpath = "//section[1]/section[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/ul[1]/li[9]/a[1]/span[1]")
    public WebElement iconDatepicker;
    // List danh sách datepicker
    @FindBys(@FindBy(xpath = "//section[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/ul[1]/li[9]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr/td"))
    public List<WebElement> listDatepicker;
    // Textbox nhãn công việc
    @FindBy(xpath = "//div[@class='control ']")
    private WebElement txtLabel;
    // Nút hoàn thành nhãn công việc
    @FindBy(xpath = "//div[@class='control'][contains(.,'add')]")
    private WebElement btnDoneLabel;
    // Icon arrow-drop-down Security
    @FindBy(xpath = "//ul[1]/li[1]/div[1]/div[1]/ul[1]/li[5]/div[1]/div[1]/a[1]/span[2]")
    public WebElement iconArrowDropDownSecurity;
    // List chế độ bảo mật
    @FindBys(@FindBy(xpath = "//section[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/ul[1]/li[5]/div[1]/div[2]/div[1]/a"))
    private List<WebElement> listSecurity;
    // Icon arrow-drop-down Status
    @FindBy(xpath = "//section[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/ul[1]/li[7]/div[1]/div[1]/a[1]/span[2]")
    public WebElement iconArrowDropDownStatus;
    // List trạng thái công việc
    @FindBys(@FindBy(xpath = "//section[1]/section[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/ul[1]/li[7]/div[1]/div[2]/div[1]/a/span[2]"))
    private List<WebElement> listStatus;
    // Đã hoàn thành
    @FindBys(@FindBy(xpath = "//span[.='Đã hoàn thành']"))
    public WebElement done;

    // Chọn kế hoạch
    public void chosePlan() {
        try {
            Thread.sleep(500);
            for (WebElement row : listPlan) {
                String namePlan = row.getText().strip();
                System.out.println(namePlan);
                if (namePlan.contains("Kế hoạch tháng")) {
                    row.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // C1: Chon chế độ bảo mật
    public void choseSecurity(String Condition) {
        try {
            btnDrSecurity.click();
            Thread.sleep(500);
            for (WebElement row : listSecurity) {
                String nameSecurity = row.getText().strip();
                if (nameSecurity.equals(Condition)) {
                    row.click();
                    System.out.println(nameSecurity);
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // C2: Thay đổi chế độ bảo mật của kế hoạch
    public void changeSecurity() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            iconArrowDropDownSecurity.click();
            if (iconArrowDropDownSecurity.getText().equals("Riêng tư")) {
                System.out.println(iconArrowDropDownSecurity.getText());
                for (WebElement security : listSecurity) {
                    String nameSecurity = security.getText().strip();
                    if (nameSecurity.equals("Công khai")) {
                        security.click();
                        break;
                    }
                }
            } else {
                System.out.println(iconArrowDropDownSecurity.getText());
                for (WebElement security : listSecurity) {
                    String nameSecurity = security.getText().strip();
                    if (nameSecurity.equals("Riêng tư")) {
                        security.click();
                        break;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // C1:Thay đổi trạng thái kế hoạch
    public void changeStatus() {
        try {

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            iconArrowDropDownStatus.click();
            if (iconArrowDropDownStatus.getText().equals("Đang diễn ra")) {
                System.out.println(iconArrowDropDownStatus.getText());
                for (WebElement status : listStatus) {
                    String nameStatus = status.getText().strip();
                    if (nameStatus.equals("Đã hoàn thành")) {
                        status.click();
                        break;
                    }
                }
            } else {
                System.out.println(iconArrowDropDownStatus.getText());
                for (WebElement status : listStatus) {
                    String nameStatus = status.getText().strip();
                    if (nameStatus.equals("Đang diễn ra")) {
                        status.click();
                        break;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // C2: Chọn trạng thái kế hoạch
    public void choseStatusPlans(String Condition) {
        try {
            btnDrStatus.click();
            Thread.sleep(500);
            for (WebElement row : listStatus) {
                String nameStatus = row.getText().strip();
                if (nameStatus.equals(Condition)) {
                    row.click();
                    System.out.println(nameStatus);
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void choseDatepicker() {
        try {
            iconDatepicker.click();
            for (WebElement date : listDatepicker) {
                String nameDatepicker = date.getText().strip();
                System.out.println(nameDatepicker);
                if (nameDatepicker.equals("20")) {
                    date.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Chỉnh sửa công việc
    public void editPlan() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            creatPlanPage creat = new creatPlanPage(driver);
            loginPage lg = new loginPage(driver);
            // TH1: Chỉnh sửa với Title trống
            Thread.sleep(2000);
            btnEditPlan.click();
            creat.txtTitle.clear();
            btnDoneDescriptionTitle.click();
            if (lg.selecTagline().equals("Bạn chưa nhập tiêu đề kế hoạch!")) {
                System.out.println("TC01:");
                lg.passed();
                // TH2: Chỉnh sửa chế độ bảo mật
                creat.txtTitle.sendKeys("Kế hoạch tháng 3");
                changeSecurity();
                main.click();
                changeStatus();
                main.click();
                choseDatepicker();
                btnDoneDescriptionTitle.click();
                Thread.sleep(1000);
                if (lg.selecTagline().equals("Đã cập nhật thông tin của dự án.")) {
                    System.out.println("TC02: ");
                    lg.passed();
                } else {
                    System.out.println("TCO2: ");
                    lg.failed();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
