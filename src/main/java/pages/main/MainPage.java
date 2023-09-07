package pages.main;

import common.Server;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class MainPage extends BasePage {
    private static final String URL = "/";
    private final String createBtn = "//button[contains(@class,'Docs-Create-Dropdown__Button')]";
    private final String createDocBtn = "//div[contains(@class,'Docs-Create-Dropdown__Type_docx')]";
    private final String createDocMenuBtn = "//button[contains(@class,'confirmation-dialog__button_submit')]";
    private final String docNameField = "//input[@text='Новый документ']";
    private final String docNameTextFocused = "//span[contains(@class,'Textinput_focused')]";
    private final String docNameFieldEmpty = "//input[@text='']";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainPage open() {
        driver.get(Server.getServerURL() + URL);
        return this;
    }

    @Step (value = "Открытие подменю создания документа")
    public MainPage clickCreateDoc(){
        waitElementVisible(createBtn);
        click(createBtn);
        waitElementVisible(createDocBtn);
        click(createDocBtn);
        waitElementVisible(docNameField);
        return this;
    }
    @Step(value = "Задание имени документа и его окончательное создание")
    public MainPage createDoc(String docName) {
        waitElementVisible(docNameField);
        WebElement element = driver.findElement(By.xpath(docNameField)); //очищения поля ввода названия док-а
        waitElementVisible(docNameTextFocused); //ожидание момента, когда текст названия (изначальный) документа станет выделенным
        element.sendKeys(Keys.DELETE);
        waitElementVisible(docNameFieldEmpty); //ожидание пустого поля ввода назв. док.
        element.sendKeys(docName);
        waitElementVisible(createDocMenuBtn);
        click(createDocMenuBtn);
        return this;
    }
}
