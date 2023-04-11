package page.fwork.comment;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class commentPage {
    WebDriver driver;

    public commentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Các elenment của chức năng Bình luận
    @FindBy(xpath = "//a[contains(text(),'Bình luận')]")
    public WebElement btnComment;
    @FindBy(id = "task_comment")
    public WebElement txtComment;
    @FindBy(xpath = "//a[.='send']")
    public WebElement iconSendComment;
    @FindBy(xpath = "//a[@class='icon has-text-danger is_hover'][contains(.,'delete')]")
    public WebElement iconDeleComment;

    public void commentTodolist() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            btnComment.click();
            txtComment.sendKeys("Đây là đoạn văn mẫu để kiểm tra chức năng của dự án");
            iconSendComment.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleComment() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            iconDeleComment.click();
            Thread.sleep(500);
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
