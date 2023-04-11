package page.HRM.establish.P_category;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.login.loginPage;

public class CompanyPage {
    WebDriver driver;

    public CompanyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='is-active ']//span[.='Thiết lập']")
    public WebElement btn_Establish;
    @FindBys(@FindBy(xpath = "//li[@class='is-active']/ul//li"))
    public List<WebElement> list_Establish;
    @FindBy(xpath = "//div[@class='icon-text']/a[@class='has-text-weight-medium'][.='Công ty']")
    public WebElement btn_Company;
    @FindBy(xpath = "//section[@class='modal-card-foot is-right']/a[@class='button is-link']/span[.='Chỉnh sửa']")
    public WebElement btn_EditCompany;
    @FindBy(id = "option_name")
    public WebElement txt_TitleCompany;
    @FindBy(css = ".is-family-code")
    public WebElement select_Department;
    @FindBy(css = ".avatar_list")
    public WebElement avatar_List;
    @FindBy(id = "search_member")
    public WebElement txt_SearchMember;
    @FindBy(css = ".button.is-white.has-text-link")
    public WebElement icon_AddCompany;
    @FindBy(css = ".icon.has-background-white.has-text-grey.is-bordered.is-rounded.ml-3")
    public WebElement icon_AddMember;
    @FindBys(@FindBy(xpath = "//div[@class='scrolly py-1']/ul[@class='columns is-vcentered is-variable is-1 is-mobile']"))
    public List<WebElement> list_MemberCategory;
    @FindBy(xpath = "//div[@class='scrolly py-1']/ul[1]/li[@class='column is-narrow']")
    public WebElement icon_AddRemoveMember;
    @FindBy(xpath = "//span[@class='is-size-7'][contains(.,'Hoàn tất')]")
    public WebElement btn_DoneMember;
    @FindBy(xpath = "//section[@class='modal-card-foot is-right']/a[2]/span[.='Cập nhật']")
    public WebElement btn_DoneCompany;
    @FindBy(xpath = "//span[@xpath='1'][contains(.,'TimiOffice')]")
    public WebElement title_CategoryCompany;
    @FindBys(@FindBy(xpath = "//section[2]/ul[1]/li[5]/ul"))
    public List<WebElement> listCompany;
    @FindBy(css = "section.modal.is-active > section.modal-card > section.modal-card-body > ul li:last-child")
    public WebElement table_company;

    public void navigationHRM_setup() {
        try {
            btn_Establish.click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[contains(@href,'hrm/setup/options')]")).click();
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void choseListEstablish(String condition) {
        loginPage lg = new loginPage(driver);
        try {
            lg.waitForElementVisible(driver, btn_Establish, 5);
            if (btn_Establish.isDisplayed()) {
                btn_Establish.click();
                for (WebElement list : list_Establish) {
                    String nameEstablish = list.getText().strip();
                    System.out.println(nameEstablish);
                    if (nameEstablish.equals(condition)) {
                        Thread.sleep(500);
                        list.click();
                        break;
                    }
                }
            } else {
                System.out.println("Không thực hiện được thao tác");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select_Department(int condition) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Select select = new Select(select_Department);
            select.selectByIndex(condition);
            WebElement selectedOption = select.getFirstSelectedOption();
            String selectedText = selectedOption.getText();
            System.out.println(selectedText);
            // System.out.println("Đã hoàn thành chọn Phòng ban");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chose_MemberCategory(String condition) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            avatar_List.click();
            for (WebElement list : list_MemberCategory) {
                String nameMember = list.getText().strip();
                if (nameMember.contains(condition)) {
                    icon_AddRemoveMember.click();
                    btn_DoneMember.click();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void creat_Company(String condition) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            txt_TitleCompany.sendKeys(condition);
            icon_AddCompany.click();
            // btn_DoneCompany.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void edit_Company(String title) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            txt_TitleCompany.sendKeys(title);
            icon_AddCompany.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void list_Company(String condition) {
        try {
            loginPage lg = new loginPage(driver);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            for (WebElement list : listCompany) {
                String nameCompany = list.getText().strip();
                if (nameCompany.equals(condition)) {
                    System.out.println("Hạng mục công ty đã được tạo thành công");
                    lg.passed();
                } else {
                    System.out.println("Không có dữ liệu trùng khớp");
                    lg.failed();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select_Company(String condition) {
        try {
            List<WebElement> titleCompany = table_company
                    .findElements(By.cssSelector("ul li:first-child span:last-child"));
            for (WebElement row : titleCompany) {
                String nameCompany = row.getText().strip();
                System.out.println(nameCompany);
                if (nameCompany.equals(condition)) {
                    row.click();
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void table_ListCompany() {
        try {
            List<WebElement> company = table_company.findElements(By.tagName("ul"));
            System.out.println(company.size());
            for (int i = 0; i < company.size(); i++) {
                List<WebElement> titleCompany = company.get(i).findElements(By.tagName("li"));
                if (titleCompany.size() == 4) {
                    String a = titleCompany.get(0).findElement(By.cssSelector("a:nth-child(1) > span:nth-child(2)"))
                            .getText().strip();
                    System.out.println(a);
                    if (a.equals("Docommerc")) {
                        WebElement del = titleCompany.get(3).findElement(By.tagName("a"));
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
// a span:last-child
// a:nth-child(1) > span:nth-child(2)