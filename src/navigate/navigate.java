package navigate;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class navigate {
    WebDriver driver;

    public navigate(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Tin tức
    @FindBy(xpath = "//a[@href='blogs']")
    private WebElement navBlogs;
    // Thống kê
    @FindBy(xpath = "//a[@href='reports']")
    private WebElement navReports;
    // Đội nhóm
    @FindBy(xpath = "//a[@href='teams']")
    private WebElement navTeams;
    // Todolist
    @FindBy(xpath = "//a[@href='todolist']")
    private WebElement navTodolist;
    // Kế hoạch
    @FindBy(xpath = "//a[@href='work']")
    private WebElement navWork;
    // OKRs
    @FindBy(xpath = "(//a[@class='button is-white'])[6]")
    private WebElement navOKRs;
    // OKRs - Thiết lập
    @FindBy(xpath = "(//a[@class='button is-white'])[7]")
    private WebElement navEstablish;
    // Thiết lập - Timeline
    @FindBy(xpath = "//a[.='Timeline']")
    private WebElement navTimeline;
    // Thiết lập - Góp ý mục tiêu
    @FindBy(xpath = "//a[.='Góp ý mục tiêu']")
    private WebElement navComment;
    // Thiết lập - Công bố mục tiêu
    @FindBy(xpath = "//a[.='Công bố mục tiêu']")
    private WebElement navAnnounced;
    // Thiết lập - Tạo OKRs
    @FindBy(xpath = "//a[.='Tạo OKRs']")
    private WebElement navCreOKRs;
    // OKRs - Hành động
    @FindBy(xpath = "//a[.='Hành động']")
    private WebElement navAcOKRs;
    // OKRs -Tổng quan
    @FindBy(xpath = "//a[.='Tổng quan']")
    private WebElement navOverOKRs;
    // CFRs
    @FindBy(xpath = "(//a[@class='button is-white'])[14]")
    private WebElement navCFRs;
    // CFRs - Checkin
    @FindBy(xpath = "//a[@href='cfr/checkin']")
    private WebElement navCheckin;
    // CFRs - Ghi nhận - Tặng sao
    @FindBy(xpath = "//a[@href='cfr/star']")
    private WebElement navStareco;
    // Kaizen
    @FindBy(xpath = "//a[@href='kaizen']")
    private WebElement navKaizen;
    // Đổi quà
    @FindBy(xpath = "(//a[@class='button is-white'])[18]")
    private WebElement navgiftchange;
    // Cửa hàng
    @FindBy(xpath = "[href='gift/product']")
    private WebElement navStore;
    // Lịch sử đổi quà
    @FindBy(xpath = "//a[.='Lịch sử đổi quà']")
    private WebElement navHistory;
    // Đào tạo
    @FindBy(xpath = "(//a[@class='button is-white'])[21]")
    private WebElement navTrain;
    // Đào tạo - Khoá học
    @FindBy(xpath = "//a[.='Khóa học']")
    private WebElement navCourse;
    // Đào tạo - Quản lý khoá học
    @FindBy(xpath = "//a[.='Quản lý khóa học']")
    private WebElement navManager;
    // Đào tạo - Chấm bài thi
    @FindBy(xpath = "//a[.='Chấm bài thi']")
    private WebElement navMarking;
    // Đào tạo - Cấp chứng chỉ
    @FindBy(xpath = "//a[.='Cấp chứng chỉ']")
    private WebElement navGrant;
    // Đào tạo - Chứng chỉ đạt được
    @FindBy(xpath = "//a[.='Chứng chỉ đạt được']")
    private WebElement navCerti;
    // HRM
    @FindBy(xpath = "//span[normalize-space()='HRM']")
    private WebElement navHRM;
    // Cấu hình
    @FindBy(xpath = "//li[@class=' is_up']/a[1]")
    private WebElement navConfiguration;
    // Cấu hình - Cơ cấu
    @FindBy(xpath = "//a[.='Cơ cấu']")
    private WebElement navCStructure;
    // Cấu hình - OKRs - CFRs
    @FindBy(xpath = "//a[.='OKRs - CFRs']")
    private WebElement navCOCs;
    // Cấu hình - Todolist
    @FindBy(xpath = "//a[.='Todolist']")
    private WebElement navCTodolist;
    // Cấu hình - Kaizen
    @FindBy(xpath = "//a[.='Kaizen']")
    private WebElement navCKaizen;
    // Cấu hình - Đổi quà
    @FindBy(xpath = "//a[.='Đổi quà']")
    private WebElement navCGiftchange;
    // Cấu hình - Đào tạo
    @FindBy(xpath = "//a[.='Đào tạo']")
    private WebElement navCTrain;
    // Cấu hình - Tiện ích
    @FindBy(xpath = "//a[.='Tiện ích']")
    private WebElement navCUtiliti;
    // Tài khoản
    @FindBy(xpath = "//a[@href='user/info']")
    private WebElement navAccount;
    // Đăng xuất
    @FindBy(css = ".btn_logout")
    private WebElement navLogout;

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println("Timeout waiting for Page Load Request to complete.");
        }
    }

    public void navigateHRM() {
        navHRM.click();
        waitForPageLoaded();
    }

    public void navigatefWork() {
        navWork.click();
        waitForPageLoaded();
    }
}
