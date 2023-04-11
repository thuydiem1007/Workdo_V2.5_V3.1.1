package page.fwork.todolist;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import page.fwork.task.creatTaskPage;
import page.login.loginPage;

public class creatTodolistPage {
    WebDriver driver;

    public creatTodolistPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Button Todolist liên kết
    @FindBy(xpath = "/html[1]/body[1]/main[1]/section[1]/section[4]/section[1]/section[2]/ul[1]/li[1]/ul[1]/li[3]/a[1]")
    public WebElement btnTodolist;
    // Icon thêm Todolist liên kết
    @FindBy(xpath = "//div[.='add_box']")
    public WebElement iconTodolist;
    // Textbox tiêu đề todolist liên kết
    @FindBy(id = "task_todo")
    public WebElement txtTitileTodolist;
    // Icon datepicker Todolist
    @FindBy(xpath = "//ul[@class='columns is-multiline is-vcentered is-variable is-1 is-mobile']//span[@class='icon is-small mr-1']")
    public WebElement dpkTodolist;
    // List datepicker left
    @FindBys(@FindBy(xpath = "//section[2]/ul[1]/li[2]/div[2]/ul[1]/li[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr/td"))
    public List<WebElement> listDateLeftTask;
    // List datepicker right
    @FindBys(@FindBy(xpath = "//section[2]/ul[1]/li[2]/div[2]/ul[1]/li[2]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr/td"))
    public List<WebElement> listDateRightTask;
    // Button cập nhật datepicker
    @FindBy(xpath = "//div[@class='daterangepicker show-calendar opensleft']//button[@class='applyBtn button is-small is-link']")
    public WebElement btnDoneDatepickerTask;
    // Button cập nhật Todolist liên kết
    @FindBy(xpath = "//span[contains(text(),'Cập nhật')]")
    public WebElement btnDoneTodolist;
    // Icon xoá tagline cảnh báo

    public void choseTask_creatTodolist() {
        try {
            loginPage lg = new loginPage(driver);
            creatTaskPage creatTask = new creatTaskPage(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            creatTask.iconArowRight.click();
            if (creatTask.t1.isDisplayed()) {
                creatTask.t1.click();
                System.out.println("Đã chọn thành công công việc phụ");
                lg.passed();
            } else {
                System.out.println("--------------");
                lg.failed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void choseDateLeft(String condition) {
        try {
            for (WebElement date : listDateLeftTask) {
                String numberDateLeft = date.getText().strip();
                if (numberDateLeft.equals(condition)) {
                    date.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void choseDateRight(String condition) {
        try {
            for (WebElement date : listDateRightTask) {
                String numberDateRight = date.getText().strip();
                if (numberDateRight.equals(condition)) {
                    date.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void creatTodolist() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            loginPage lg = new loginPage(driver);
            btnTodolist.click();
            // TH1: Để trống tiêu đề todolist liên kết
            iconTodolist.click();
            Thread.sleep(500);
            btnDoneTodolist.click();
            if (lg.selecTagline().equals("Nhập tiêu đề của Todolist")) {
                System.out.println("TC01: ");
                lg.passed();
                Thread.sleep(500);
                lg.deleTagline();
                // TH2: Để trống thời gian todolist
                txtTitileTodolist.sendKeys("Listout các công việc cần làm trong ngày");
                btnDoneTodolist.click();
                if (lg.selecTagline().equals("Chọn ngày tạo Todolist")) {
                    System.out.println("TC02: ");
                    lg.passed();
                    Thread.sleep(500);
                    lg.deleTagline();
                    // TH3: Tạo todolist liên kết thành công Đã tạo Todolist liên kết với công việc
                    dpkTodolist.click();
                    choseDateLeft("20");
                    choseDateLeft("22");
                    Thread.sleep(500);
                    btnDoneDatepickerTask.click();
                    btnDoneTodolist.click();
                    if (lg.selecTagline().equals("Đã tạo Todolist liên kết với công việc")) {
                        System.out.println("TC03: ");
                        lg.passed();
                    } else {
                        System.out.println("TC03: ");
                        lg.failed();
                    }
                } else {
                    System.out.println("TC02: ");
                    lg.failed();
                }
            } else {
                System.out.println("TC01: ");
                lg.failed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void creatTodolistSuccess(String title) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            // iconTodolist.click();
            txtTitileTodolist.sendKeys(title);
            btnDoneTodolist.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
