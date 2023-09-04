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
            UserModel user = new UserModel("**", "**", "student");
            loginPage.open();
            loginPage.mail();
            loginPage.checkLoginLogin();
            loginPage.loginFirst(user);
            loginPage.checkLoginPass();
            loginPage.loginSecond(user);

            CreateDocPage createDocPage = new CreateDocPage(driver);
            createDocPage.clickCreateDoc();
            createDocPage.createDoc("doc1");

            MainPage mainPage = new MainPage(driver);
            mainPage.checkMainPage();
            mainPage.checkElementsMain();
            mainPage.secondStep();
            mainPage.thirdStep();
            mainPage.fourthStep();
            mainPage.fifthStep();
            mainPage.sixthSeventhEighthStep();
            mainPage.ninthStep();


    }
}
