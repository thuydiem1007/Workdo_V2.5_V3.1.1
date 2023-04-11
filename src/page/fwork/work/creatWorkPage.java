package page.fwork.work;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class creatWorkPage {
    WebDriver driver;

    public creatWorkPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // #region Khỏi tạo biến
    // Button công việc
    @FindBy(xpath = "//ul[@class='columns is-vcentered is-variable is-2']/li[contains(.,'Công việc')]")
    public WebElement btnWork;
    // Icon Thêm
    @FindBy(css = "#task_name")
    public WebElement btnIconWork;
    // Button tạo công việc mới
    @FindBy(xpath = "//a[@class='button is-small is-rounded is-success']")
    public WebElement btnCreatWorkNew;
    // Textbox nhập tiêu đề công việc
    @FindBy(xpath = "//input[@id='task_name']")
    public WebElement txtTitleWork;
    // Icon thêm user
    @FindBy(xpath = "//section[1]/section[2]/ul[1]/li[2]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]/i[1]")
    public WebElement iconAdduser;
    // Textbox nhập tên user
    @FindBy(id = "search_member")
    public WebElement txtFillUser;
    // Icon add/remove user
    @FindBy(xpath = "//section[2]/ul[1]/li[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[1]/a[1]/i[1]")
    public WebElement iconUser;
    // Button hoàn tất add/remove user
    @FindBy(xpath = "//section[1]/section[2]/ul[1]/li[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[4]/a[1]/span[2]")
    public WebElement btnDoneUser;
    // Button trạng thái công việc
    @FindBy(xpath = "//li[@class='column is-10 is-size-7 p-4']/div[2]//span[@class='icon']")
    public WebElement btnStatusWork;
    // Button hoàn tất công việc
    @FindBy(xpath = "//span[contains(text(),'Hoàn tất')]")
    public WebElement btnDoneWork;
    // Ngày bắt đầu
    @FindBy(xpath = "//div[3]//span[@class='icon is-small mr-1']")
    public WebElement btnStartDay;
    // Ngày kết thúc
    @FindBy(xpath = "//div[4]//span[@class='icon is-small mr-1']")
    public WebElement btnEndDay;
    // Lấy tất cả các element đại diện cho các ngày trong lịch và lưu vào một danh
    // sách.
    @FindBys(@FindBy(xpath = "//li[@class='column is-10 is-size-7 p-4']/div[3]//tr/td"))
    public List<WebElement> datePicker;
    // Button Xác nhận
    @FindBy(xpath = "//li[@class='column is-10 is-size-7 p-4']/div[3]//button[@class='applyBtn button is-small is-link']")
    public WebElement btnConfirmDatepicker;
    // Button chọn nhóm công việc
    @FindBy(xpath = "//div[6]//div[@class='dropdown is-hoverable']")
    public WebElement btnSelectGroupWork;
    // Textbox nhập tên nhóm công việc
    @FindBy(xpath = "//input[@placeholder='Thêm nhóm công việc']")
    public WebElement txtSelectGroupWork;
    // Icon hoàn thành thêm nhóm công việc
    @FindBy(xpath = "//div[@class='p-2']//span[@class='icon']")
    public WebElement btnDoneAddGroupWork;
    // Icon xoá tagline
    @FindBy(xpath = "//div[@class='notification is-danger']")
    private WebElement iconDelTagline;
    @FindBy(xpath = "//li[@class='column is-10 is-size-7 p-4']/div[2]//span[@class='icon']")
    private WebElement arrow_drp_Status;
    // List trạng thái công việc
    @FindBys(@FindBy(xpath = "//li//div[@class='dropdown is-active']//div[@class='dropdown-content']//a"))
    public List<WebElement> listStatus;
    // List công việc đã tạo thành công
    @FindBys(@FindBy(xpath = "//div[@class='scrolly']//div//li[@class='column']//a"))
    public List<WebElement> listWork;
    // Button 'Xoá và rời khỏi công việc'
    @FindBy(xpath = "//section[1]/section[2]/ul[1]/li[1]/ul[1]/li[6]/a[1]")
    public WebElement btnDeleAndLeaveWork;
    // Button Xoá công việc
    @FindBy(xpath = "//a[@class='button is-danger']")
    public WebElement btnDeleWork;
    //
    // @FindBy(xpath =
    // "//section[3]/div[2]/div[2]/div[2]/div[1]/div[4]/ul[1]/li[1]/div[1]/a[1]")
    // public WebElement a1;

    // #endregion
    public void choseStatus() {
        try {
            Thread.sleep(500);
            arrow_drp_Status.click();
            for (WebElement status : listStatus) {
                String nameStatus = status.getText().strip();
                if (nameStatus.equals("Doing")) {
                    status.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void datePicker(String condition) {
        try {
            for (WebElement date : datePicker) {
                String numberDate = date.getText();
                if (numberDate.equals(condition)) {
                    date.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doneDatePicker() {
        try {
            if (btnConfirmDatepicker.isEnabled()) {
                btnConfirmDatepicker.click();
            } else {
                datePicker("8");
                Thread.sleep(500);
                btnConfirmDatepicker.click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void creat_WorkSuccess(String title) {
        try {
            txtTitleWork.sendKeys(title);
            Thread.sleep(500);
            btnDoneWork.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void choseWork(String condition) {
        try {
            Thread.sleep(500);
            for (WebElement work : listWork) {
                String nameWork = work.getText().strip();
                System.out.println(nameWork);
                if (nameWork.contains(condition)) {
                    work.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleWork() {
        try {
            // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Thread.sleep(1000);
            btnDeleAndLeaveWork.click();
            Thread.sleep(500);
            btnDeleWork.click();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
