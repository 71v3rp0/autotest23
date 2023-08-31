package pages.main;

import common.Server;
import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.base.BasePage;

import javax.swing.*;

public class MainPage extends BasePage {

    private final String workIFrame = "//iframe[contains(@src,'frameEditorId')]";
    private final String mainWorkspace = "//canvas[@id='id_viewer_overlay']";
    private final String fontTypeBtn = "//div[@id='asc-gen472']//button[@class='btn btn-default dropdown-toggle']";
    private final String fontTypeAsana = "//li[@id='asc-gen705']";
    private final String fontSizeBtn = "//span[@id='asc-gen436']//button[@class='btn btn-default dropdown-toggle']";
    private final String fontTypeBold = "//button[@id='id-toolbar-btn-bold']";
    private final String fontTypeItalic = "//span[@id='slot-btn-italic']//button[contains(@class, 'btn')]"; //наклонный
    private final String fontTypeStrikeout = "//button[@id='id-toolbar-btn-strikeout']//i[contains(@class,'icon')]"; //перечеркнутый
    private final String mainField = "//canvas[@id='id_viewer_overlay']";
    private final String fontSizeField = "//span[@id='asc-gen436']//input[@class='form-control']";
    private final String leftAlign = "//button[@id='id-toolbar-btn-align-left']";
    private final String rightAlign = "//button[@id='id-toolbar-btn-align-right']";
    private final String justAlign = "//button[@id='id-toolbar-btn-align-just']";
    private final String insert = "//a[@data-tab='ins']";
    private final String tableInsert = "//div[@id='tlbtn-inserttable']";
    private final String tableCustom = "//a[@id='asc-gen223']";
    private final String tableRowCount = "//label[contains(text(),'Количество столбцов')]/../div[contains(@class,'columns-val')]//input[@class='form-control']";
    private final String tableColumnCount = "//label[contains(text(),'Количество строк')]/../div[contains(@class,'rows-val spinner')]//input[@type='text']";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainPage open() {
        driver.get(Server.getServerURL());
        return this;
    }

    @Step(value = "Проверка главной страницы")
    public MainPage checkElements() {
        switchToLastTab();
        waitElementVisible(workIFrame);
        WebElement iframeAppPanel = driver.findElement(By.xpath(workIFrame));
        driver.switchTo().frame(iframeAppPanel);
        waitElementVisible(mainWorkspace);                            //не находит(   //iframe[contains(@src,'frameEditorId')]
        waitElementVisible(fontTypeBtn);
        waitElementVisible(fontSizeBtn);
        waitElementVisible(fontTypeBold);
        waitElementVisible(fontTypeItalic);
        waitElementVisible(fontTypeStrikeout);
        waitElementVisible(fontSizeField);
        waitElementVisible(mainField);
        waitElementVisible(leftAlign);
        waitElementVisible(rightAlign);
        waitElementVisible(justAlign);
        waitElementVisible(insert);
        return this;
    }

    @Step(value = "Действия")
    public MainPage mainTask(){
        click(fontTypeBtn);
        waitElementVisible(fontTypeAsana);
        click(fontTypeAsana);
        click(fontSizeBtn);
        fillField(fontSizeField, "12");
        new Actions(driver).moveByOffset(800, 400).click().sendKeys("Asana12").build().perform();

        click(fontSizeBtn);
        fillField(fontSizeField, "13");
        click(fontTypeItalic);
        new Actions(driver).sendKeys("Асана13 bold").build().perform();

        click(fontSizeBtn);
        fillField(fontSizeField, "14");
        click(fontTypeItalic);
        click(fontTypeStrikeout);
        new Actions(driver).sendKeys("Asana14 strikeout").build().perform();
        click(fontTypeStrikeout);
        new Actions(driver).sendKeys(" Sakura is the Japanese term for cherry blossom trees. Cherry blossom trees are different from other cherry trees. The main difference is that cherry blossom trees don’t produce fruit. Instead, they bloom with beautiful pink or white flowers each spring. Unfortunately, the trees only flower for a week or two." + "\n" +
                "Cherry blossom trees are an icon of Japan. Some people even call the cherry blossom Japan’s informal national flower. The Japanese school year starts in April, during cherry blossom season. The flowers symbolize good luck, love, and springtime. Since they bloom for such a short time, cherry blossom trees also represent human mortality. They remind us how short and precious life is.").build().perform();
        new Actions(driver).keyDown(Keys.SHIFT).sendKeys(Keys.HOME, Keys.PAGE_UP).build().perform();

        click(rightAlign);
        click(leftAlign);
        click(justAlign);

        click(insert);
        click(tableInsert);
        waitElementVisible(tableCustom);
        click(tableCustom);
        waitElementVisible(tableRowCount);
        waitElementVisible(tableColumnCount);

        WebElement element = driver.findElement(By.xpath(tableRowCount)); //очищения поля ввода хз так или не так над(
        element.sendKeys(Keys.BACK_SPACE);
        element.sendKeys("5");
        element = driver.findElement(By.xpath(tableColumnCount));
        element.sendKeys(Keys.BACK_SPACE);
        element.sendKeys("5");
        new Actions(driver).sendKeys(Keys.ENTER).build().perform();
        return this;
    }


}
