package pages.docEditor;
import common.Server;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.base.BasePage;

public class DocEditorPage extends BasePage {
    private final String workIFrame = "//iframe[contains(@src,'frameEditorId')]";
    private final String mainWorkspace = "//canvas[@id='id_viewer_overlay']";
    private final String homeMenuBtn = "//a[@data-tab='home']";
    private final String fontTypeBoldBtn = "//button[@id='id-toolbar-btn-bold']";
    private final String fontTypeItalicBtn = "//button[@id='id-toolbar-btn-italic']"; //наклонный
    private final String fontTypeStrikeoutBtn = "//button[@id='id-toolbar-btn-strikeout']"; //перечеркнутый
    private final String fontSizeField = "//span[@id='asc-gen436']//input[@class='form-control']";
    private final String fontStyleField = "//div[@id='asc-gen472']//input";
    private final String alignLeftBtn = "//button[@id='id-toolbar-btn-align-left']";
    private final String alignRightBtn = "//button[@id='id-toolbar-btn-align-right']";
    private final String alignJustBtn = "//button[@id='id-toolbar-btn-align-just']";
    private final String insertMenuBtn = "//a[@data-tab='ins']";
    private final String tableInsertBtn = "//div[@id='tlbtn-inserttable']";
    private final String tableCustomBtn = "//a[@id='asc-gen223']";
    private final String tableRowCounterField = "//label[contains(text(),'Количество столбцов')]/../div[contains(@class,'columns-val')]//input[@class='form-control']";
    private final String tableColumnCounterField = "//label[contains(text(),'Количество строк')]/../div[contains(@class,'rows-val spinner')]//input[@type='text']";
    private final String layoutMenuBtn = "//a[@data-tab='layout']";
    private final String layoutColumnsBtn = "//div[@id='tlbtn-columns']";
    private final String layoutColumnsSetThreeBtn = "//a[@id='asc-gen317']";
    private final String btnIsActive = "/../*[contains(@class,'active')]";
    private final String btnIsActiveMenu = "/../../*[contains(@class,'active')]";
    private final String btnIsChecked = "/../*[contains(@class,'checked')]";


    public DocEditorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public DocEditorPage open() {
        driver.get(Server.getServerURL());
        return this;
    }
    @Step (value = "Проверка загрузки страницы ред-ия док-а")
    public DocEditorPage checkMainPage()
    {
        switchToLastTab();
        waitElementVisible(workIFrame);
        WebElement iframeAppPanel = driver.findElement(By.xpath(workIFrame));
        driver.switchTo().frame(iframeAppPanel);
        waitElementVisible(mainWorkspace);
        return this;
    }
    @Step(value = "Ввод текста в текстовое поле редактора")
    public DocEditorPage sendSomeText(String text) { //
        new Actions(driver).sendKeys(text).build().perform();
        return this;
    }
    @Step(value = "Выбор типа шрифта - жирный")
    public DocEditorPage selectFontTypeBold(){
        waitElementVisible(fontTypeBoldBtn);                                                      //проверка наличия кнопки
        if (!booleanWaitElementVisible(fontTypeBoldBtn + btnIsActive, 0)) {     //проверка нажата кнопка или нет
            click(fontTypeBoldBtn);                                                              //если кнопка не нажата - нажимаем, если уже нажата - ничего не делаем
        }
        waitElementVisible(fontTypeBoldBtn + btnIsActive);                            //проверяем, нажалась ли по итогу кнопка
           return this;
    }

    @Step(value = "Выбор типа шрифта - наклонный")
    public DocEditorPage selectFontTypeItalic(){
        waitElementVisible(fontTypeItalicBtn);
        if (!booleanWaitElementVisible(fontTypeItalicBtn + btnIsActive, 0)) {
            click(fontTypeItalicBtn);
        }
        waitElementVisible(fontTypeItalicBtn + btnIsActive);
        return this;
    }
    @Step(value = "Выбор типа шрифта - перечеркнутый")
    public DocEditorPage selectFontTypeStrikeout(){
        waitElementVisible(fontTypeStrikeoutBtn);
        if (!booleanWaitElementVisible(fontTypeStrikeoutBtn + btnIsActive, 0)) {
            click(fontTypeStrikeoutBtn);
        }
        waitElementVisible(fontTypeStrikeoutBtn + btnIsActive);
        return this;
    }
    @Step(value = "Выбор типа шрифта - нежирный")
    public DocEditorPage unselectFontTypeBold(){
        waitElementVisible(fontTypeBoldBtn);                                                             //проверка наличия кнопки
        if (booleanWaitElementVisible(fontTypeBoldBtn + btnIsActive, 0)) {              //проверка нажата кнопка или нет
            click(fontTypeBoldBtn);                                                                         // если кнопка нажата - отжимаем, если не нажата - ничего не делаем
            if (booleanWaitElementVisible(fontTypeBoldBtn + btnIsActive, 0))                 //проверяем, отжалась ли по итогу кнопка
                Assert.fail("Элемент " + fontTypeBoldBtn + " не был нажат");
        }
        return this;
    }
    @Step(value = "Выбор типа шрифта - ненаклонный")
    public DocEditorPage unselectFontTypeItalic(){
        waitElementVisible(fontTypeItalicBtn);
        if (booleanWaitElementVisible(fontTypeItalicBtn + btnIsActive, 0)) {
            click(fontTypeItalicBtn);
            if (booleanWaitElementVisible(fontTypeItalicBtn + btnIsActive, 0))
                Assert.fail("Элемент " + fontTypeItalicBtn + " не был нажат");
        }
        return this;
    }
    @Step(value = "Выбор типа шрифта - неперечеркнутый")
    public DocEditorPage unselectFontTypeStrikeout(){
            waitElementVisible(fontTypeItalicBtn);
        if (booleanWaitElementVisible(fontTypeStrikeoutBtn + btnIsActive, 0)) {
            click(fontTypeStrikeoutBtn);
            if (booleanWaitElementVisible(fontTypeStrikeoutBtn + btnIsActive, 0))
                Assert.fail("Элемент " + fontTypeStrikeoutBtn + " не был нажат");
        }
        return this;
    }

    @Step(value = "Выбор размера шрифта")
    public DocEditorPage selectFontSize(int fontSize){
        waitElementVisible(fontSizeField);
        click(fontSizeField);
        click(fontSizeField);
        new Actions(driver).sendKeys(Keys.DELETE, String.valueOf(fontSize)).build().perform();
        return this;
    }
    @Step(value = "Выбор стиля шрифта")
    public DocEditorPage selectFontStyle(String fontStyle){
        waitElementVisible(fontStyleField);
        click(fontStyleField);
        click(fontStyleField);
        new Actions(driver).sendKeys(Keys.DELETE, fontStyle).build().perform();
                                                                                        //выбранный стиль и размер шрифта не отслеживается (?)
        return this;
    }
    @Step(value = "Выравнивание текста по левому краю")
    public DocEditorPage alignTextLeft(){
        waitElementVisible(alignLeftBtn);
        click(alignLeftBtn);
        waitElementVisible(alignLeftBtn + btnIsActive);
        return this;
    }
    @Step(value = "Выравнивание текста по правому краю")
    public DocEditorPage alignTextRight(){
        waitElementVisible(alignRightBtn);
        click(alignLeftBtn);
        waitElementVisible(alignJustBtn + btnIsActive);
        return this;
    }
    @Step(value = "Выравнивание текста по ширине")
    public DocEditorPage alignTextJust(){
        waitElementVisible(alignJustBtn);
        click(alignJustBtn);
        waitElementVisible(alignJustBtn + btnIsActive);
        return this;
    }
    @Step(value = "Сдвиг курсора на странице редактора")
    public DocEditorPage moveCursor(int xOffset, int yOffset){
        new Actions(driver).moveByOffset(xOffset, yOffset).click().build().perform();
        return this;
    }
    @Step(value = "Переход в меню 'Главная'")
    public DocEditorPage moveToHomeMenu(){
        waitElementVisible(homeMenuBtn);
        click(homeMenuBtn);
        waitElementVisible(homeMenuBtn + btnIsActiveMenu);
        return this;
    }
    @Step(value = "Переход в меню 'Вставка'")
    public DocEditorPage moveToInsertMenu(){
        waitElementVisible(insertMenuBtn);
        click(insertMenuBtn);
        waitElementVisible(insertMenuBtn + btnIsActiveMenu);
        return this;
    }
    @Step(value = "Переход в меню 'Макет'")
    public DocEditorPage moveToLayoutMenu(){
        waitElementVisible(layoutMenuBtn);
        click(layoutMenuBtn);
        waitElementVisible(layoutMenuBtn + btnIsActiveMenu);
        return this;
    }
    @Step(value = "Выделить весь текст на странице редактора")
    public DocEditorPage selectTextAll(){
        new Actions(driver).keyDown(Keys.SHIFT).sendKeys(Keys.HOME, Keys.PAGE_UP).build().perform(); //выделить весь текст на странице
        return this;
    }
    @Step(value = "Переход в меню редактирования колонок текста в меню 'Макет'")
    public DocEditorPage layoutColumnsMenu(){
        if (!booleanWaitElementVisible(layoutColumnsBtn + btnIsActive, 0)) {
            waitElementVisible(layoutColumnsBtn);
            click(layoutColumnsBtn);
            waitElementVisible(layoutColumnsBtn + btnIsActive);
        }
        return this;
    }
    @Step(value = "Сделать выбранный текст стилем 3 колонки 'Макет'-'Колонка'")
    public DocEditorPage layoutColumnsMenuSetThree(){
        waitElementVisible(layoutColumnsSetThreeBtn);
        click(layoutColumnsSetThreeBtn);
        layoutColumnsMenu();
        waitElementVisible(layoutColumnsSetThreeBtn + btnIsChecked);
        return this;
    }
    @Step(value = "Переход в меню вставки таблиц меню 'Вставка'")
    public DocEditorPage insertTableMenu(){
        if (!booleanWaitElementVisible(insertMenuBtn + btnIsActive, 0)) {
            waitElementVisible(tableInsertBtn);
            click(tableInsertBtn);
            waitElementVisible(tableInsertBtn + btnIsActive);
        }
        return this;
    }
    @Step(value = "Вставка пользовательской таблицы меню 'Вставка'-'Таблица'")
    public DocEditorPage insertTableCustom(int tableRowAmount, int tableColumnAmount){
        insertTableMenu();
        waitElementVisible(tableCustomBtn);
        click(tableCustomBtn);

        waitElementVisible(tableRowCounterField);
        waitElementVisible(tableColumnCounterField);
        WebElement element = driver.findElement(By.xpath(tableRowCounterField)); //заполнение полей ввода количества строк столбцов
        element.sendKeys(Keys.BACK_SPACE);
        element.sendKeys(String.valueOf(tableRowAmount));                           //содержимое этих текстовых полей не отслеживается (?)
        element = driver.findElement(By.xpath(tableColumnCounterField));
        element.sendKeys(Keys.BACK_SPACE);
        element.sendKeys(String.valueOf(tableColumnAmount));
        new Actions(driver).sendKeys(Keys.ENTER).build().perform();

        if (booleanWaitElementVisible(tableColumnCounterField, 0))
            Assert.fail("Модальное окно, содержащее элемент " + tableColumnCounterField + " не было закрыто");
        return this;
    }
}
