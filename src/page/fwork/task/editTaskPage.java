package page.fwork.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import page.login.loginPage;

public class editTaskPage {
    WebDriver driver;

    public editTaskPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // #region Khởi tạo biến
    // Icon user
    @FindBy(xpath = "//div[@class='scrolly py-1']/ul[2]//a[.='add']")
    public WebElement iconUser;
    // Textbox nhập tên user
    @FindBy(id = "search_member")
    public WebElement txtFillUser;
    // Icon add user
    @FindBy(xpath = "//li[.='add_circle_outline']")
    public WebElement iconAddUser;
    // Icon add/remove user
    @FindBy(xpath = "//i[.='remove_circle_outline']")
    public WebElement iconRemoveUser;
    // Button hoàn tất user
    @FindBy(xpath = "//span[@class='is-size-7'][contains(.,'Hoàn tất')]")
    public WebElement btnDoneAddandRemoveUser;

    @FindBy(css = "[title='Xây dựng lịch trình và thành viên tham dự']")
    public WebElement t1;

    // #endregion
    public void choseTask() {
        try {
            creatTaskPage creat = new creatTaskPage(driver);
            creat.iconArowRight.click();
            Thread.sleep(1000);
            for (WebElement title : creat.listTask) {
                String nameTitleTask = title.getText().strip();
                Thread.sleep(500);
                if (nameTitleTask.equals("Xây dựng lịch trình và thành viên tham dự")) {
                    Thread.sleep(500);
                    System.out.println(nameTitleTask);
                    title.click();
                    System.out.println("Hoàn thành");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void choseDateLeft(String condition) {
        try {
            creatTaskPage creat = new creatTaskPage(driver);
            for (WebElement date : creat.listDateLeftTask) {
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
            creatTaskPage creat = new creatTaskPage(driver);
            for (WebElement date : creat.listDateRighttTask) {
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

    public void addUser() {
        try {
            Thread.sleep(1000);
            iconUser.click();
            // txtFillUser.sendKeys("Thuý Diễm");
            Thread.sleep(500);
            iconAddUser.click();
            Thread.sleep(500);
            btnDoneAddandRemoveUser.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeUser() {
        try {
            loginPage lg = new loginPage(driver);
            Thread.sleep(1000);
            iconUser.click();
            // txtFillUser.sendKeys("Thuý Diễm");
            Thread.sleep(500);
            iconRemoveUser.click();
            Thread.sleep(500);
            btnDoneAddandRemoveUser.click();
            lg.deleTagline();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editTask() {
        try {
            loginPage lg = new loginPage(driver);
            creatTaskPage creat = new creatTaskPage(driver);
            choseTask();
            creat.btnOptionsEdit.click();
            creat.btnEditTask.click();
            // TH1: Chỉnh sửa title công việc phụ
            creat.txtTitleTask.clear();
            creat.btnDoneTask.click();
            if (lg.selecTagline().equals("Nhập tiêu đề của công việc")) {
                System.out.println("TC01: ");
                lg.passed();
                // TH2: chỉnh sửa thời gian công việc phụ
                creat.txtTitleTask.sendKeys("Xây dựng lịch trình và thành viên tham dự");
                creat.txtDescriptionTask.sendKeys("Mô tả kèm theo nếu có");
                creat.iconDateTask.click();
                choseDateLeft("24");
                choseDateRight("30");
                creat.btnConfirmDateTask.click();
                Thread.sleep(1000);
                removeUser();
                creat.btnDoneTask.click();
                Thread.sleep(1000);
                if (lg.selecTagline().equals("Chọn người tham gia của công việc.")) {
                    Thread.sleep(500);
                    System.out.println("TC02: ");
                    lg.passed();
                    // TH3: Chỉnh sửa thành công
                    Thread.sleep(1000);
                    addUser();
                    creat.btnDoneTask.click();
                    System.out.println("TC03");
                    lg.passed();
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

    public void editTasksuccess(String title) {
        try {
            creatTaskPage creat = new creatTaskPage(driver);
            creat.txtTitleTask.sendKeys(title);
            creat.btnDoneTask.click();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
