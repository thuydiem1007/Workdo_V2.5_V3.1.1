package page.HRM.shifts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShiftPage {
    WebDriver driver;

    public ShiftPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='columns is-vcentered is-multiline is-variable is-2 mb-3']//a[1]")
    public WebElement btn_AddNewShift;
    @FindBy(xpath = "//ul[@class='columns is-multiline is-variable is-2']/li[1]//input[@class='input']")
    public WebElement txt_TitleShift;
    @FindBy(xpath = "//ul[@class='columns is-multiline is-variable is-2']/li[2]//select[1]")
    public WebElement select_StTime;
    @FindBy(xpath = "//ul[@class='columns is-multiline is-variable is-2']/li[3]//select[1]")
    public WebElement select_EndTime;
    @FindBy(xpath = "//div[@class='control']/input[contains(@type,'number')]")
    public WebElement txt_Number;
    @FindBy(xpath = "//section[@class='modal-card-foot is-right']/a[@class='button is-link']/span[.='Cập nhật']")
    public WebElement btn_DoneShift;
    @FindBy(xpath = "//tbody[1]/tr[6]//a[1]/i[@class='material-icons-outlined is-size-5']")
    public WebElement btn_EditShift;
    @FindBys(@FindBy(xpath = "//table[@class='table is-fullwidth is-vcentered is-responsive mt-5']/tbody/tr"))
    public List<WebElement> rows_tableShift;

    public void change_selectStTime(int number) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Select select = new Select(select_StTime);
            select.selectByIndex(number);
            WebElement selectedOption = select.getFirstSelectedOption();
            String selectedText = selectedOption.getText();
            System.out.println(selectedText);
            System.out.println("Đã hoàn thành chọn giờ bắt đầu");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void change_selectEndTime(int number) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Select select = new Select(select_EndTime);
            select.selectByIndex(number);
            WebElement selectedOption = select.getFirstSelectedOption();
            String selectedText = selectedOption.getText();
            System.out.println(selectedText);
            System.out.println("Đã hoàn thành chọn giờ kết thúc");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void creat_Shiftsuccess(String condition) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            txt_TitleShift.sendKeys(condition);
            btn_DoneShift.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void edit_Shiftsuccess(String condition) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            txt_TitleShift.sendKeys(condition);
            btn_DoneShift.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void table_Shift(String condition, int j) {
        try {
            for (int i = 0; i < rows_tableShift.size(); i++) {
                List<WebElement> td_list = rows_tableShift.get(i).findElements(By.tagName("td"));
                if (td_list.size() == 6) {
                    String a = td_list.get(0).getText().strip();
                    if (a.equals(condition)) {
                        List<WebElement> b = td_list.get(5).findElements(By.tagName("a"));
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
