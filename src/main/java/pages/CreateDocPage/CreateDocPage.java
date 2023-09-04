package pages.CreateDocPage;

import common.Server;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;

public class CreateDocPage extends BasePage {
    private static final String URL = "/";
    private final String createDocBtn = "//button[@class='Button2 Button2_theme_raised Button2_view_action Button2_size_m Button2_width_max Docs-Create-Dropdown__Button']";
    private final String createDocBtn2 = "//div[@class='Menu-Item Menu-Item_type_menuitem Docs-Create-Dropdown__Type Docs-Create-Dropdown__Type_docx']";
    private final String createDocBtn3 = "//button[@class='Button2 Button2_view_action Button2_size_m confirmation-dialog__button confirmation-dialog__button_submit ']";
    private final String docNameField = "//input[@text='Новый документ']";
    private final String docNameTextFocused = "//span[contains(@class,'Textinput_focused')]";
    private final String docNameFieldEmpty = "//input[@text='']";

    public CreateDocPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CreateDocPage open() {
        driver.get(Server.getServerURL() + URL);
        return this;
    }

    @Step (value = "1) - Создание док-а - нажатие на кнопку 'Создать документ' на главной странице")
    public CreateDocPage clickCreateDoc(){
        waitElementVisible(createDocBtn);
        click(createDocBtn);
        waitElementVisible(createDocBtn2);
        click(createDocBtn2);
        return this;
    }
    @Step(value = "1) - Создание дока - задание имени и нажатие на кнопку создать")
    public CreateDocPage createDoc(String docName) {
        waitElementVisible(docNameField);
        WebElement element = driver.findElement(By.xpath(docNameField)); //очищения поля ввода названия док-а
        waitElementVisible(docNameTextFocused); //ожидание момента, когда текст названия (изначальный) документа станет выделенным
        element.sendKeys(Keys.DELETE);
        waitElementVisible(docNameFieldEmpty); //ожидание пустого поля ввода назв. док.
        element.sendKeys(docName);
        waitElementVisible(createDocBtn3);
        click(createDocBtn3);
        return this;
    }
}
