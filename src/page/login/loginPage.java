package page.login;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
    WebDriver driver;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Nhập email...']")
    private WebElement txtUsername;

    @FindBy(xpath = "//input[@placeholder='Nhập password...']")
    private WebElement txtPassword;

    @FindBy(tagName = "button")
    private WebElement btnSigin;

    @FindBys(@FindBy(id = "notify"))
    public List<WebElement> tagline;

    @FindBy(xpath = "//div[@id='notify']//button[@class='delete']")
    public WebElement btnDeltagline;

    @FindBy(tagName = "h1")
    private WebElement txtTitle;

    @FindBys(@FindBy(css = ".has-text-weight-bold"))
    private List<WebElement> listCompany;
    @FindBy(xpath = "//div[@class='notification is-danger']/a[1]")
    public WebElement iconDeleTagline;

    public String selecTagline() {
        String text = "";
        if (tagline.size() > 0) {
            text = tagline.get(0).getText().strip();
            System.out.println("Notify System: " + text);
            return text;
        } else {
            return "Tagline isn't display";
        }
    }

    public String title() {
        String h1 = txtTitle.getText().strip();
        if (h1.length() > 0) {
            return h1;
        } else {
            return "Không có dữ liệu trùng";
        }
    }

    public void choseCompany() {
        try {
            for (WebElement row : listCompany) {
                String nameCompany = row.getText().strip();
                System.out.println(nameCompany);
                if (nameCompany.equals("Công Ty Demo")) {
                    row.click();
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void login() {
        try {
            // login with username,password blank
            btnSigin.click();
            Thread.sleep(500);
            if (selecTagline().equals("Tên đăng nhập hoặc mật khẩu không đúng !")) {
                System.out.println(selecTagline());
                Thread.sleep(500);
                System.out.println("TC01 passed");
                btnDeltagline.click();
                // login with username blank
                Thread.sleep(500);
                txtPassword.sendKeys("0353699537");
                Thread.sleep(500);
                btnSigin.click();
                Thread.sleep(500);
                if (selecTagline().equals("Tên đăng nhập hoặc mật khẩu không đúng !")) {
                    System.out.println(selecTagline());
                    System.out.println("TC02 passed");
                    // login with password blank
                    btnDeltagline.click();
                    Thread.sleep(500);
                    txtUsername.sendKeys("dttdiem.conando@gmail.com");
                    Thread.sleep(500);
                    txtPassword.clear();
                    Thread.sleep(500);
                    btnSigin.click();
                    Thread.sleep(500);
                    if (selecTagline().equals("Tên đăng nhập hoặc mật khẩu không đúng !")) {
                        System.out.println(selecTagline());
                        System.out.println("TC03 passed");
                        // login with username invalid
                        btnDeltagline.click();
                        Thread.sleep(500);
                        txtUsername.clear();
                        txtUsername.sendKeys("dttdiem.conando");
                        Thread.sleep(500);
                        txtPassword.sendKeys("0353699537");
                        Thread.sleep(500);
                        btnSigin.click();
                        if (selecTagline().equals("Tên đăng nhập hoặc mật khẩu không đúng !")) {
                            System.out.println(selecTagline());
                            System.out.println("TC04 passed");
                            // login with password invalid
                            btnDeltagline.click();
                            Thread.sleep(500);
                            txtUsername.clear();
                            txtUsername.sendKeys("dttdiem.conando@gmail.com");
                            Thread.sleep(500);
                            txtPassword.clear();
                            txtPassword.sendKeys("@@@@@@@@@@");
                            Thread.sleep(500);
                            btnSigin.click();
                            if (selecTagline().equals("Tên đăng nhập hoặc mật khẩu không đúng !")) {
                                System.out.println(selecTagline());
                                System.out.println("TC05 passed");
                                // login with username, password valid
                                btnDeltagline.click();
                                Thread.sleep(500);
                                txtUsername.clear();
                                txtUsername.sendKeys("dttdiem.conando@gmail.com");
                                Thread.sleep(500);
                                txtPassword.clear();
                                txtPassword.sendKeys("0353699537");
                                Thread.sleep(500);
                                btnSigin.click();
                                Thread.sleep(500);
                                if (title().contains("Xin")) {
                                    System.out.println(title());
                                    System.out.println("TC06 passed");
                                    choseCompany();
                                } else {
                                    System.out.println("TC06 failed");
                                }
                            } else {
                                System.out.println("TC05 failed");
                            }
                        } else {
                            System.out.println("TC04 failed");
                        }
                    } else {
                        System.out.println("TC03 failed");
                    }

                } else {
                    System.out.println("TC02 failed");
                }
            } else {
                System.out.println("TC01 failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loginSuccess() {
        try {
            txtUsername.sendKeys("dttdiem.conando@gmail.com");
            Thread.sleep(500);
            txtPassword.sendKeys("0353699537");
            Thread.sleep(500);
            btnSigin.click();
            Thread.sleep(2000);
            choseCompany();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void passed() {
        System.out.println("Status: Passed");
        System.out.println("========================");
    }

    public void failed() {
        System.out.println("Status: Failed");
        System.out.println("========================");
    }

    public void deleTagline() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            loginPage lg = new loginPage(driver);
            if (iconDeleTagline.isDisplayed()) {
                iconDeleTagline.click();
            } else {
                lg.failed();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Chờ element được click, sau time sẽ timeout
    public void waitForElementToBeClickable(WebDriver _driver, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(_driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Chờ element được hiển thị, sau time sẽ timeout
    public void waitForElementVisible(WebDriver _driver, WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(_driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
