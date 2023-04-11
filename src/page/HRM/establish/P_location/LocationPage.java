package page.HRM.establish.P_location;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LocationPage {
    WebDriver driver;

    public LocationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='columns is-vcentered is-multiline is-variable is-2 mb-3']//a[1]")
    public WebElement btn_AddNew;
    @FindBy(xpath = "//ul[@class='columns is-multiline is-variable is-2']/li[1]//input[@class='input']")
    public WebElement txt_TitleLocation;
    @FindBy(xpath = "//ul[@class='columns is-multiline is-variable is-2']/li[2]//input[@class='input']")
    public WebElement txt_Latitude; // 21.001499857197263
    @FindBy(xpath = "//ul[@class='columns is-multiline is-variable is-2']/li[3]//input[@class='input']")
    public WebElement txt_Longitude; // 105.82257868429822
    @FindBy(xpath = "//input[contains(@type,'number')]")
    public WebElement txt_Radius;
    @FindBy(tagName = "select")
    public WebElement select_Company;
    @FindBy(xpath = "//section[@class='modal-card-foot is-right']/a[@class='button is-link']/span[.='Cập nhật']")
    public WebElement btn_DoneLocation;
    @FindBy(xpath = "//tbody[1]/tr[1]//a[1]/i[@class='material-icons-outlined is-size-5']")
    public WebElement icon_EditLocation;
    @FindBy(css = ".material-icons.is-size-6")
    public WebElement icon_DeleCompany;
    @FindBy(css = ".table is-fullwidth.is-vcentered.is-responsive.mt-5")
    public WebElement table_NameLocation;
    @FindBys(@FindBy(xpath = "//table[@class='table is-fullwidth is-vcentered is-responsive mt-5']/tbody/tr"))
    public List<WebElement> rows_tableLocation;
    @FindBys(@FindBy(xpath = "//table[@class='table is-fullwidth is-vcentered is-responsive mt-5']/tbody/tr/td"))
    public List<WebElement> columns_row;
    @FindBy(xpath = "//table[1]/tbody[1]/tr[1]/td[5]/a[2]")
    public WebElement icon_Delete;

    public void select_Company() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Select select = new Select(select_Company);
            select.selectByValue("233A195234");
            WebElement selectedOption = select.getFirstSelectedOption();
            String selectedText = selectedOption.getText();
            System.out.println(selectedText);
            System.out.println("Đã hoàn thành chọn Công ty");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void creat_Locationsuccess(String condition) {
        try {
            txt_TitleLocation.sendKeys(condition);
            btn_DoneLocation.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void edit_Locationsuccess(String condition) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            txt_TitleLocation.sendKeys(condition);
            btn_DoneLocation.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void table_Location(String condition, int j) {
        try {
            for (int i = 0; i < rows_tableLocation.size(); i++) {
                List<WebElement> td_list = rows_tableLocation.get(i).findElements(By.tagName("td"));
                if (td_list.size() == 5) {
                    String a = td_list.get(0).getText().strip();
                    if (a.equals(condition)) {
                        List<WebElement> b = td_list.get(4).findElements(By.tagName("a"));
                        b.get(j).click();
                        break;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
