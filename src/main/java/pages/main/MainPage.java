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

    private final String contentBody = "//div[@class='content-holder']";
    private final String sideBar = "//div[@class='layout__sider']";
    private final String lbWorkspace = "//*[@label='Рабочий стол']";
    private final String workIFrame = "//iframe[contains(@src,'frameEditorId')]";
    private final String mainWorkspace = "//canvas[@id='id_viewer_overlay']";
    private final String fontTypeBtn = "//div[@id='asc-gen472']//button[@class='btn btn-default dropdown-toggle']";
    private final String fontTypeAsana = "//li[@id='asc-gen705']";
    private final String fontSizeBtn = "//span[@id='asc-gen436']//button[@class='btn btn-default dropdown-toggle']";
    private final String fontTypeBold = "//button[@id='id-toolbar-btn-bold']";
    private final String fontTypeItalic = "//span[@id='slot-btn-italic']//button[@class='btn btn-toolbar']"; //наклонный
    private final String fontTypeStrikeout = "//span[@id='slot-btn-strikeout']//i[@class='icon toolbar__icon btn-strikeout']"; //перечеркнутый
    private final String mainField = "//canvas[@id='id_viewer']";

    private final String fontSizeField = "//span[@id='asc-gen436']//input[@class='form-control']";

    //sideBar
    private final String btnSideBarReports = "//div[text()='Отчеты']";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public MainPage open() {
        driver.get(Server.getServerURL() + URL);
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
        return this;
    }

    @Step(value = "Действия")
    public MainPage mainTask(){
        click(fontTypeBtn);
        waitElementVisible(fontTypeAsana);
        click(fontTypeAsana);
        click(fontSizeBtn);
        fillField(fontSizeField, "12");



        click(fontSizeBtn);
        fillField(fontSizeField, "13");
        click(fontTypeItalic);
        return this;
    }


}
