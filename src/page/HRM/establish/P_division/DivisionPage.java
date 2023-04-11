package page.HRM.establish.P_division;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import page.login.loginPage;

public class DivisionPage {
    WebDriver driver;

    public DivisionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[@class='columns is-vcentered is-multiline is-variable is-2 mb-3']/li[2]//select[1]")
    public WebElement select_Company;
    @FindBy(xpath = "//ul[@class='columns is-vcentered is-multiline is-variable is-2 mb-3']/li[3]//select[1]")
    public WebElement select_Department;
    @FindBy(xpath = "//input[contains(@class,'input')]")
    public WebElement txt_nameDivision;
    @FindBy(css = ".table is-fullwidth.is-vcentered.is-responsive.mt-5")
    public WebElement table_NameDivision;
    @FindBys(@FindBy(xpath = "//table[@class='table is-fullwidth is-vcentered is-responsive mt-5']/tbody/tr"))
    public List<WebElement> rows_Table;
    @FindBys(@FindBy(xpath = "//table[@class='table is-fullwidth is-vcentered is-responsive mt-5']/tbody/tr/td"))
    public List<WebElement> columns_row;
    @FindBy(xpath = "//table[1]/tbody[1]/tr[1]/td[1]/a[1]")
    public WebElement t1;
    @FindBy(xpath = "//ul[@class='columns is-multiline is-variable is-2']/li[2]//select")
    public WebElement select_Shift;
    @FindBys(@FindBy(css = "section.modal.is-active .column.is-full.has-text-weight-semibold.pb-0"))
    public List<WebElement> list_day;
    @FindBys(@FindBy(css = "column.is-half"))
    public List<WebElement> list_menu;
    @FindBys(@FindBy(css = "div.field label"))
    public List<WebElement> field_Day;
    @FindBys(@FindBy(css = "div.field"))
    public List<WebElement> field_Label;
    @FindBy(xpath = "//span[contains(text(),'Cập nhật')]")
    public WebElement btn_DoneDivision;

    public void select_Company() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Select select = new Select(select_Company);
            select.selectByIndex(1);
            WebElement selectedOption = select.getFirstSelectedOption();
            String selectedText = selectedOption.getText();
            System.out.println(selectedText);
            System.out.println("Đã hoàn thành chọn Công ty");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select_Department() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Select select = new Select(select_Department);
            select.selectByIndex(1);
            WebElement selectedOption = select.getFirstSelectedOption();
            String selectedText = selectedOption.getText();
            System.out.println(selectedText);
            System.out.println("Đã hoàn thành chọn Phòng ban");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void change_selectDivision(int number) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Select select = new Select(select_Shift);
            select.selectByIndex(number);
            WebElement selectedOption = select.getFirstSelectedOption();
            String selectedText = selectedOption.getText();
            System.out.println(selectedText);
            System.out.println("Đã hoàn thành chọn giờ kết thúc");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hàm chọn để chọn user muốn phân ca
    public void table(String condition) {
        try {
            for (int i = 0; i < rows_Table.size(); i++) {
                List<WebElement> td_list = rows_Table.get(i).findElements(By.tagName("td"));
                String a = td_list.get(1).getText().strip();
                if (a.equals(condition)) {
                    td_list.get(0).click();
                    break;

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select_Shift(int s, int c) {
        try {
            loginPage lg = new loginPage(driver);
            for (int i = 0; i < 22; i++) {
                int a = i + 1;
                String sum_select = "//ul[@class='columns is-multiline is-variable is-2']/li[" + a + "]//select[1]";
                switch (a) {
                    case 2, 5, 8, 11, 14, 17:
                        WebElement name = driver.findElement(By.xpath(sum_select));
                        Select select = new Select(name);
                        select.selectByIndex(s);
                        lg.passed();
                        System.out.println("Phân ca sáng thành công");
                        break;
                    case 3, 6, 9, 12, 15:
                        name = driver.findElement(By.xpath(sum_select));
                        select = new Select(name);
                        select.selectByIndex(c);
                        lg.passed();
                        System.out.println("Phân ca chiều thành công");
                        break;

                    case 1, 4, 7, 10, 13, 16, 19:
                        break;

                }
            }
            btn_DoneDivision.click();
            if (lg.selecTagline().equals("Đã phân ca thành công cho 1 tài khoản.")) {
                lg.passed();
            } else {
                lg.failed();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
