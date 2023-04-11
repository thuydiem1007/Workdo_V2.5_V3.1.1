package test.fwork.todolist;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import commons.setup;
import navigate.navigate;
import page.fwork.plan.editPlanPage;
import page.fwork.todolist.creatTodolistPage;
import page.fwork.todolist.deleTodolistPage;
import page.fwork.work.creatWorkPage;
import page.login.loginPage;

public class deleTodolistTest {
    public static void main(String[] args) {
        try {
            setup setup = new setup();
            WebDriver driver = setup.initChorme();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            loginPage lg = new loginPage(driver);
            navigate nav = new navigate(driver);
            editPlanPage plan = new editPlanPage(driver);
            creatWorkPage work = new creatWorkPage(driver);
            creatTodolistPage crTodolist = new creatTodolistPage(driver);
            deleTodolistPage dlTodolist = new deleTodolistPage(driver);
            lg.loginSuccess();
            nav.waitForPageLoaded();
            nav.navigatefWork();
            plan.chosePlan();
            Thread.sleep(500);
            work.btnWork.click();
            crTodolist.choseTask_creatTodolist();
            dlTodolist.deleTodolist();
            driver.close();
            lg.passed();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
