package page.fwork.task;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import page.login.loginPage;

public class creatTaskPage {
    WebDriver driver;

    public creatTaskPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // #region Khởi tạo biến
    // List danh sách các công việc cần tạo công việc phụ
    @FindBys(@FindBy(xpath = "//section[1]/section[3]/div[2]/div[2]/div[2]/div"))
    private List<WebElement> listWork;
    // Button tuỳ chọn nâng cao
    @FindBy(xpath = "//div[@class='scrolly']/div[1]//li[@class='column is-narrow has-text-centered']//div[@class='dropdown-trigger']")
    public WebElement btnOptional;
    // Button tạo công việc phụ
    @FindBy(xpath = "//div[@class='scrolly']/div[1]//a[.='Tạo công việc phụ']")
    private WebElement btnAddTask;
    // Icon thêm công việc phụ
    @FindBy(xpath = "//div[@class='py-2']//span[@class='icon']")
    public WebElement iconCreatTask;
    // Textbox nhập tiêu đề công việc phụ
    @FindBy(xpath = "//input[@class='input is-small is_bg']")
    public WebElement txtTitleTask;
    // Textbox nhập mô tả công việc phụ
    @FindBy(xpath = "//textarea[@placeholder='Nhập mô tả công việc phụ']")
    public WebElement txtDescriptionTask;
    // Thời gian công việc phụ
    @FindBy(xpath = "//section[2]/ul[1]/li[2]/div[1]/ul[2]/li[2]/a[1]/span[1]")
    public WebElement iconDateTask;
    // Bảng chọn chi tiết thêm thời gian công việc
    @FindBy(xpath = "//ul[2]/li[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[3]/td[3]")
    public WebElement btnSelecDateTask;
    // List ngày của datepicker left
    @FindBys(@FindBy(xpath = "//ul[2]/li[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr/td"))
    public List<WebElement> listDateLeftTask;
    // List ngày của datepicker right
    @FindBys(@FindBy(xpath = "//ul[2]/li[2]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr/td"))
    public List<WebElement> listDateRighttTask;
    // Button xác nhận Datepicker
    @FindBy(xpath = "//section[2]//ul[2]/li[2]/div[1]/div[1]/div[4]/button[2]")
    public WebElement btnConfirmDateTask;
    // Thành viên công việc phụ
    @FindBy(xpath = "//section[2]//ul[2]/li[3]/div[1]/div[1]/div[1]/a[1]/i[1]")
    public WebElement iconMember;
    // Thêm chi tiết thành viên phụ
    @FindBy(xpath = "//section[2]//ul[2]/li[3]/div[1]/div[2]/div[1]/div[3]/ul[1]/li[1]")
    public WebElement iconAddMember;
    // Button Hoàn tất Thêm thành viên công việc phụ
    @FindBy(css = "a[class='button is-link is-small'] span[class='is-size-7']")
    public WebElement btnDoneAddMember;
    // Button Cập nhật công việc phụ.
    @FindBy(xpath = "//section[2]/ul[1]/li[2]/div[1]/ul[2]/li[6]/div[1]/div[1]/a[1]/span[2]")
    public WebElement btnDoneTask;
    // Icon arrow-right
    @FindBy(xpath = "//section[3]/div[2]/div[2]/div[2]/div[1]/div[2]/ul[1]/li[1]/div[1]/a[1]")
    public WebElement iconArowRight;
    @FindBys(@FindBy(css = ".div.icon-text.item_title.pl-0"))
    public List<WebElement> listTask;
    // List danh sách công việc phụ
    @FindBys(@FindBy(xpath = "//section[1]/section[3]/div[2]/div[2]/div[2]/div[1]/div[2]/ul/li[1]/div[1]/a[1]"))
    public List<WebElement> listmenutTask;
    // Công việc phụ 1
    @FindBy(css = "[title='Xây dựng lịch trình và thành viên tham dự']")
    public WebElement t1;
    // Button Tuỳ chọn nâng cao
    @FindBy(xpath = "//ul[@class='task_list is_sub columns is-gapless is-size-7']/li[@class='column is-narrow has-text-centered']//i[@class='material-icons-outlined is-size-6']")
    public WebElement btnOptionTask;
    // Button Xoá công việc phụ này
    @FindBy(xpath = "//a[@class='dropdown-item has-text-danger'][contains(.,'Xóa việc phụ này')]")
    public WebElement btnDeleTask;
    // ** Chỉnh sửa công việc phụ**
    // Tuỳ chọn nâng cao
    @FindBy(xpath = "//div[@class='scrolly py-1']/ul[2]//span[@class='icon']")
    public WebElement btnOptionsEdit;
    // Button chỉnh sửa
    @FindBy(xpath = "//div[@class='scrolly py-1']/ul[2]//a[.='Chỉnh sửa']")
    public WebElement btnEditTask;
    // #endregion

    public void Work() {
        try {
            for (WebElement work : listWork) {
                String nameTask = work.getText().strip();
                if (nameTask.equals("Họp và trình bày các nội dung các công việc cần triển khai của dự án fWork")) {
                    work.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void choseOptions() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            if (btnOptional.isDisplayed()) {
                btnOptional.click();
                btnAddTask.click();
            } else {
                System.out.println("Không có công việc nào để xử lý");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String titleTask() {
        try {
            String nameTitleTask = "";
            for (WebElement title : listTask) {
                nameTitleTask = title.getText().strip();
                System.out.println(nameTitleTask);
                break;
            }
            return nameTitleTask;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void choseDateLeft() {
        try {
            for (WebElement date : listDateLeftTask) {
                String numberDateLeft = date.getText().strip();
                if (numberDateLeft.equals("15")) {
                    date.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void choseDateRight() {
        try {
            for (WebElement date : listDateRighttTask) {
                String numberDateRight = date.getText().strip();
                if (numberDateRight.equals("20")) {
                    date.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void taskSuccess(String title) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            txtTitleTask.sendKeys(title);
            Thread.sleep(500);
            btnDoneTask.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleTask() {
        try {
            loginPage lg = new loginPage(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            if (t1.isDisplayed()) {
                btnOptionTask.click();
                btnDeleTask.click();
                Thread.sleep(500);
                driver.switchTo().alert().accept();
                System.out.println("---------------");
                System.out.println("Đã xoá thành công công việc phụ");
                lg.passed();
            } else {
                System.out.println("--------------");
                lg.failed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
