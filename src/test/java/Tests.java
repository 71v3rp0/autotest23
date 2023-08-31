import base.BaseTest;
import com.google.j2objc.annotations.Weak;
import constant.Users;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import models.UserModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v101.page.Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.CreateDocPage.CreateDocPage;
import pages.login.LoginPage;
import pages.main.MainPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Epic("Тестовый раздел")
@Feature("Тесты")
@Test
public class Tests extends BaseTest {

    @Story("Тест 1")
    @Link("test link")
    @Test
    public void test() {

            LoginPage loginPage = new LoginPage(driver);
            UserModel user = new UserModel("a.dorofeev01", "alexI_28112001leha", "student");
            loginPage.open();
            loginPage.mail();
            loginPage.checkLoginLogin();
            loginPage.loginFirst(user);
            loginPage.checkLoginPass();
            loginPage.loginSecond(user);

            CreateDocPage createDocPage = new CreateDocPage(driver);
            createDocPage.createDoc("doc1");

            MainPage mainPage = new MainPage(driver);
            mainPage.checkElements();
            mainPage.mainTask();

             //  driver.get("https://docs.yandex.ru/docs");
            /*
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

            WebElement element = driver.findElement(By.xpath("//button[@data-type='login']")); //нажатие почта
            element.click();

            element = driver.findElement(By.xpath("//input[@id='passp-field-login']")); //ввод логин энтер
            element.sendKeys("**", Keys.ENTER);

            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500)); //ждем 1 сек неявное ожидание
            //element = driver.findElement((By) new WebDriverWait(driver, Duration.ofSeconds(1)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='passp-field-passwd'")))); //ждем появления элемента и ввод пароль энтер
            element = driver.findElement(By.xpath("//input[@id='passp-field-passwd']")); //ввод пароль энтер

            element.sendKeys("**", Keys.ENTER);

            element = driver.findElement(By.xpath("//button[@class ='Docs-Stub__Option']//span[@class ='Docs-Stub__Option-Icon Docs-Stub__Option-Icon_docx']")); //нажатие документы нч
            element.click();

            element = driver.findElement(By.xpath("//input[@class ='Textinput-Control']")); //name new doc
            element.sendKeys("new doc 1", Keys.ENTER);

             */
    }
}
