package page.HRM.establish.P_category;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeparmentPage {
    WebDriver driver;

    public DeparmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='has-text-weight-medium'][contains(.,'Phòng ban')]")
    public WebElement btn_Deparment;
    @FindBy(xpath = "//section[@class='modal-card-foot is-right']/a[@class='button is-link']/span[.='Chỉnh sửa']")
    public WebElement btn_EditDeparment;
    @FindBy(id = "option_name")
    public WebElement txt_TitleDeparment;
    @FindBy(css = ".button.is-white.has-text-link")
    public WebElement icon_Add;
    @FindBy(xpath = "//section[@class='modal-card-foot is-right']/a[2]/span[.='Cập nhật']")
    public WebElement btn_DoneDeparment;
    @FindBy(css = "section.modal.is-active > section.modal-card > section.modal-card-body > ul li:last-child")
    public WebElement table_Deparment;

    public void creat_Department(String title) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            txt_TitleDeparment.sendKeys(title);
            icon_Add.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void edit_Department(String title) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            txt_TitleDeparment.sendKeys(title);
            icon_Add.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select_Deparmernt(String condition) {
        try {
            List<WebElement> titleDeparment = table_Deparment
                    .findElements(By.cssSelector("ul li:first-child span:last-child"));
            for (WebElement row : titleDeparment) {
                String nameDeparment = row.getText().strip();
                System.out.println(nameDeparment);
                if (nameDeparment.equals(condition)) {
                    row.click();
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void table_ListDeparment() {
        try {
            List<WebElement> deparment = table_Deparment.findElements(By.tagName("ul"));
            System.out.println(deparment.size());
            for (int i = 0; i < deparment.size(); i++) {
                List<WebElement> titleDeparment = deparment.get(i).findElements(By.tagName("li"));
                if (titleDeparment.size() == 2) {
                    String a = titleDeparment.get(0).findElement(By.cssSelector("a:nth-child(1) > span:nth-child(2)"))
                            .getText().strip();
                    System.out.println(a);
                    if (a.equals("DES")) {
                        WebElement del = titleDeparment.get(1).findElement(By.tagName("a"));
                        del.click();
                        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                        wait.until(ExpectedConditions.alertIsPresent());
                        driver.switchTo().alert().accept();
                        break;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
