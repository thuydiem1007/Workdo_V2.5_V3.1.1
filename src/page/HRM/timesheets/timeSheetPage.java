package page.HRM.timesheets;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class timeSheetPage {
    WebDriver driver;

    public timeSheetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBys(@FindBy(xpath = "//table[@class='table is-vcentered sticky']/tbody/tr"))
    public List<WebElement> rows_table;
    @FindBy(xpath = "//i[normalize-space()='file_download']")
    public WebElement icon_FileDowload;
    @FindBy(xpath = "//a[@class='button is-outlined is-link'][contains(.,'edit')]")
    public WebElement icon_Edit;
    @FindBy(xpath = "//li[@class='column is-full']//select")
    public WebElement select_Edit;
    @FindBy(xpath = "//textarea[@placeholder='Nhập lý do chỉnh sửa...']")
    public WebElement txa_EditReason;
    @FindBy(xpath = "//section[@class='modal-card-foot is-right']/a[@class='button is-link']")
    public WebElement btn_DoneDetail;
    @FindBy(css = "a[class='button is-link'] span:nth-child(2)")
    public WebElement btn_DoneEdit;
    @FindBy(xpath = "//a[@class='button is-danger']/span[contains(text(),'Hủy')]")
    public WebElement btn_CancelEdit;
    @FindBy(xpath = "//a[@class='button is-outlined is-dark'][contains(.,'settings')]")
    public WebElement icon_Setting;
    @FindBy(xpath = "//div[@class='control']//input[@type='number']")
    public WebElement txt_Setting;
    @FindBy(xpath = "//a[@class='button is-outlined is-danger'][contains(.,'lock')]")
    public WebElement icon_Lock;
    @FindBy(xpath = "//section[@class='modal-card-foot is-right']//a[@class='button']/span[.='Hủy']")
    public WebElement btn_CancelLock;
    @FindBy(xpath = "//p[contains(text(),'Bạn đã export file bảng công thành công!')]")
    public WebElement title_Success;

    public void table(String condition) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            for (int i = 0; i < rows_table.size(); i++) {
                List<WebElement> td_list = rows_table.get(i).findElements(By.tagName("td"));
                String a = td_list.get(1).getText().strip();
                if (a.equals(condition)) {
                    td_list.get(4).click();
                    break;

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select_TimeSheet(int condition) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            Select select = new Select(select_Edit);
            select.selectByIndex(condition);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void edit_TimeSheetSuccess(String condition) {
        try {
            txa_EditReason.sendKeys(condition);
            Thread.sleep(500);
            btn_DoneDetail.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
