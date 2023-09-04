package pages.login;

import common.Server;
import io.qameta.allure.Step;
import models.UserModel;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import pages.main.MainPage;


import java.awt.*;

public class LoginPage extends BasePage {

    public static final String URL = "docs";

    private final String mail = "//button[@data-type='login']"; //

    private final String lgnFld = "//input[@id='passp-field-login']";

    private final String pwdFld = "//input[@id='passp-field-passwd']";
    private final String btnLogin = "//button[@id='passp:sign-in']";


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage open() {
        driver.get(Server.getServerURL() + URL);
        return this;
    }

    @Step(value = "Проверка появления поля ввода логина и кнопки логина")
    public LoginPage checkLoginLogin() {
        waitElementVisible(btnLogin);
        waitElementVisible(lgnFld);
        return this;
    }

    @Step(value = "Проверка появления поля ввода пароля")
    public LoginPage checkLoginPass() {
        waitElementVisible(pwdFld);
        return this;
    }

    @Step(value = "Проверка появления кнопки почта и ее нажать)")
    public LoginPage mail() {
        waitElementVisible(mail);
        click(mail);
        return this;
    }

    @Step(value = "Авторизация первая страница")
    public MainPage loginFirst(UserModel user) {
        fillField(lgnFld, user.username);
        click(btnLogin);
        return new MainPage(driver);
    }

    @Step(value = "Авторизация вторая страница")
    public MainPage loginSecond(UserModel user) {
        fillField(pwdFld, user.password);
        click(btnLogin);
        return new MainPage(driver);
    }

}
