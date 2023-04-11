package page.fwork.comment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class historyPage {
    WebDriver driver;

    public historyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Element Lịch sử cập nhật
    @FindBy(xpath = "//a[@class='has-text-info'][contains(.,'Lịch sử cập nhật')]")
    public WebElement btnHistory;
    @FindBys(@FindBy(css = ".item.pb-4"))
    public List<WebElement> listHistory;
    @FindBys(@FindBy(css = ".image.is-24x24.is-rounded"))
    public List<WebElement> titleHistory;

    public void history() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            btnHistory.click();
            Thread.sleep(500);
            for (int i = 0; i < listHistory.size(); i++) {
                String name = listHistory.get(i).getText();
                System.out.println(name);
                String a = listHistory.get(i).findElement(By.cssSelector(".image.is-24x24.is-rounded"))
                        .getAttribute("title");
                System.out.println(a);
                String b = listHistory.get(i).findElement(By.cssSelector(".has-text-weight-semibold.has-text-info"))
                        .getText();
                System.out.println(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
