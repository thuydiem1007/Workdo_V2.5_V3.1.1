package page.fwork.todolist;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class deleTodolistPage {
    WebDriver driver;

    public deleTodolistPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // List các todolist liên kết
    @FindBys(@FindBy(xpath = "//div[@class='scrolly py-1']/ul/li"))
    public List<WebElement> listTodolist;
    // List icon xoá todolist liên kết
    @FindBys(@FindBy(xpath = "//div[@class='scrolly py-1']/ul/li[.='delete']"))
    public List<WebElement> listIconDeleTodolist;
    // Icon xoá
    @FindBy(xpath = "(//i[contains(text(),'delete')])[2]")
    public WebElement iconDele;

    public void deleTodolist() {
        try {
            creatTodolistPage crTodolist = new creatTodolistPage(driver);
            crTodolist.btnTodolist.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            iconDele.click();
            Thread.sleep(500);
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
