package page.HRM.setupHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page.login.loginPage;

public class setupHRMPage {
    WebDriver driver;

    public setupHRMPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='HRM']")
    private WebElement btn_HRM;
    @FindBy(xpath = "//li[@class='is-active']//span[contains(text(),'Thiết lập')]")
    private WebElement btn_HRM_Establish;
    @FindBy(xpath = "//span[contains(text(),'Hạng mục')]")
    private WebElement btn_HRM_Establish_Category;
    @FindBy(xpath = "//span[contains(text(),'Địa điểm')]")
    private WebElement btn_HRM_Establish_Location;
    @FindBy(xpath = "//span[normalize-space()='Ca làm']")
    private WebElement btn_HRM_Establish_Shift;
    @FindBy(xpath = "//span[normalize-space()='Phân ca']")
    private WebElement btn_HRM_Establish_Division;
    @FindBy(xpath = "//span[contains(text(),'Chấm công')]")
    private WebElement btn_HRM_Timekepping;
    @FindBy(xpath = "//span[contains(text(),'Bảng công')]")
    private WebElement btn_HRM_TimeSheets;

    public void HRM_Establish() {
        loginPage lg = new loginPage(driver);
        lg.waitForElementVisible(driver, btn_HRM, 2);
        btn_HRM.click();
        lg.waitForElementVisible(driver, btn_HRM_Establish, 2);
        btn_HRM_Establish.click();

    }

    public void Establish_Category() {
        loginPage lg = new loginPage(driver);
        HRM_Establish();
        btn_HRM_Establish_Category.click();
        lg.waitForElementToBeClickable(driver, btn_HRM_Establish_Category, 2);
    }

    public void Establish_Location() {
        HRM_Establish();
        btn_HRM_Establish_Location.click();
    }

    public void Establish_Shift() {
        HRM_Establish();
        btn_HRM_Establish_Shift.click();
    }

    public void Establish_Division() {
        loginPage lg = new loginPage(driver);
        HRM_Establish();
        btn_HRM_Establish_Division.click();
        lg.waitForElementToBeClickable(driver, btn_HRM_Establish_Division, 2);
    }

    public void HRM_Timekeeping() {
        try {
            loginPage lg = new loginPage(driver);
            btn_HRM_Timekepping.click();
            lg.waitForElementToBeClickable(driver, btn_HRM_Timekepping, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void HRM_TimeSheets() {
        try {
            loginPage lg = new loginPage(driver);
            btn_HRM_TimeSheets.click();
            lg.waitForElementToBeClickable(driver, btn_HRM_TimeSheets, 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
