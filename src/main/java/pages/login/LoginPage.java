package pages.login;

import common.Server;
import io.qameta.allure.Step;
import models.UserModel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.base.BasePage;
public class LoginPage extends BasePage {
    public static final String URL = "docs";
    private final String mail = "//button[@data-type='login']"; //
    private final String loginField = "//input[@id='passp-field-login']";
    private final String pwdField = "//input[@id='passp-field-passwd']";
    private final String loginBtn = "//button[@id='passp:sign-in']";
    private final String btnIsChecked = "/../*[contains(@class,'checked')]";
    private final String createBtn = "//button[contains(@class,'Docs-Create-Dropdown__Button')]";
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public LoginPage open() {
        driver.get(Server.getServerURL() + URL);
        return this;
    }
    @Step(value = "Переход на метод ввода - почта")
    public LoginPage loginWithMail() {
        waitElementVisible(mail);
        click(mail);
        waitElementVisible(mail + btnIsChecked);
        return this;
    }
    @Step(value = "Заполнение авторизационной формы - логин")
    public LoginPage loginEnterLogin(UserModel user) {
        waitElementVisible(loginBtn);
        waitElementVisible(loginField);
        fillField(loginField, user.username);
        click(loginBtn);
        waitElementVisible(pwdField);
        return this;
    }

    @Step(value = "Заполнение авторизационной формы - пароль")
    public LoginPage loginEnterPassword(UserModel user) {
        waitElementVisible(loginBtn);
        waitElementVisible(pwdField);
        fillField(pwdField, user.password);
        click(loginBtn);
        waitElementVisible(createBtn);
        return this;
    }

}
