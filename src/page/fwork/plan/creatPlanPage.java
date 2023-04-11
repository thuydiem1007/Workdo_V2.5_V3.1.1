package page.fwork.plan;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class creatPlanPage {
    WebDriver driver;

    public creatPlanPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Khởi tạo các element trang tạo kế hoạch
    @FindBy(xpath = "//span[contains(text(),'Tạo kế hoạch')]")
    public WebElement addplan;

    @FindBy(id = "plan_name")
    public WebElement txtTitle;

    @FindBy(xpath = "//textarea[@placeholder='Nhập mô tả kế hoạch...']")
    private WebElement txtDescription;

    @FindBy(xpath = "//a[contains(@class,'button is-link is-small')]")
    public WebElement btnDonePlan;

    @FindBy(xpath = "//div[@class='buttons is-right']//a[@class='button is-link is-small']")
    private WebElement btnDoneuser;

    @FindBy(xpath = "//div[@class='dropdown  ']//a[.='add']")
    private WebElement btnAdduser;

    @FindBy(xpath = "//a[@class='dropdown-item py-1'][contains(.,'Quản lý')]")
    private WebElement btnAddprmanage;

    @FindBy(xpath = "//a[@class='dropdown-item py-1'][contains(.,'Thành viên')]")
    private WebElement btnAddprmember;

    @FindBy(xpath = "//a[@class='icon is-small has-text-danger']")
    private WebElement btnDeluser;

    @FindBy(id = "search_member")
    private WebElement txtSearchUser;

    @FindBy(xpath = "(//a[contains(@class,'icon is-small has-text-info')])[1]")
    private WebElement btnAddmember;

    @FindBy(id = "notify")
    private WebElement tagline;

    @FindBy(xpath = "//div[@class='dropdown  is-active']//div[@class='dropdown-trigger']/a[1]")
    private WebElement btnAddpermission;

    @FindBys(@FindBy(css = ".dropdown-item.py-1"))
    private List<WebElement> listPermisson;

    // Xoá user mặc định của hệ thống.
    public void delUser() {
        try {
            btnAdduser.click();
            Thread.sleep(1000);
            btnDeluser.click();
            Thread.sleep(500);
            btnDoneuser.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Thêm quyền hạn cho user
    public void permisson() {
        try {
            btnAddpermission.click();
            Thread.sleep(500);
            for (WebElement row : listPermisson) {
                String namePermisson = row.getText().strip();

                if (namePermisson.equals("Quản lý")) {
                    row.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Thêm user với trường hợp không có mặc định user là quản lý.
    public void addUser() {
        try {
            btnAdduser.click();
            Thread.sleep(500);
            txtSearchUser.sendKeys("thuý diễm");
            Thread.sleep(1000);
            btnAddmember.click();
            Thread.sleep(1000);
            permisson();
            Thread.sleep(500);
            btnDoneuser.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
