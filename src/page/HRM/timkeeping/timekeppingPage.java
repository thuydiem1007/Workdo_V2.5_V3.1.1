package page.HRM.timkeeping;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class timekeppingPage {
    WebDriver driver;

    public timekeppingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBys(@FindBy(xpath = "//table[@class='table is-fullwidth is-vcentered is-responsive mt-5']/tbody/tr"))
    public List<WebElement> rows_tableHistory;

    public void table_HistoryTimekepping(String condition, int j) {
        try {
            for (int i = 0; i < rows_tableHistory.size(); i++) {
                List<WebElement> td_list = rows_tableHistory.get(i).findElements(By.tagName("td"));
                if (td_list.size() == 6) {
                    String a = td_list.get(0).getText().strip();
                    if (a.equals(condition)) {
                        List<WebElement> b = td_list.get(0).findElements(By.tagName("a"));
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
