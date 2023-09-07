import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import models.UserModel;
import org.testng.annotations.Test;
import pages.docEditor.DocEditorPage;
import pages.login.LoginPage;
import pages.main.MainPage;

@Epic("Тестовый раздел")
@Feature("Тесты")
@Test
public class Tests extends BaseTest {

    @Story("Тест 1")
    @Link("test link")
    @Test
    public void test() {
            String textAboutSakura = " Sakura is the Japanese term for cherry blossom trees. Cherry blossom trees are different from other cherry trees. The main difference is that cherry blossom trees don’t produce fruit. Instead, they bloom with beautiful pink or white flowers each spring. Unfortunately, the trees only flower for a week or two." +
                            "Cherry blossom trees are an icon of Japan. Some people even call the cherry blossom Japan’s informal national flower. The Japanese school year starts in April, during cherry blossom season. The flowers symbolize good luck, love, and springtime. Since they bloom for such a short time, cherry blossom trees also represent human mortality. They remind us how short and precious life is.";
            LoginPage loginPage = new LoginPage(driver);
            UserModel user = new UserModel("**", "**", "student");
            loginPage.open();
            loginPage.loginWithMail();
            loginPage.loginEnterLogin(user);
            loginPage.loginEnterPassword(user);

            MainPage mainPage = new MainPage(driver);
            mainPage.clickCreateDoc();
            mainPage.createDoc("doc1");

            DocEditorPage docEditor = new DocEditorPage(driver);
            docEditor.checkMainPage();

            docEditor.selectFontTypeBold();                             //
            docEditor.selectFontStyle("Asana");
            docEditor.selectFontSize(12);
            docEditor.moveCursor(800, 400);
            docEditor.sendSomeText("Asana 12 Жирный");

            docEditor.selectFontStyle("Asana");
            docEditor.selectFontSize(13);
            docEditor.unselectFontTypeBold();
            docEditor.selectFontTypeItalic();
            docEditor.sendSomeText("Asana 13 Наклонный");

            docEditor.selectFontStyle("Asana");
            docEditor.selectFontSize(14);
            docEditor.unselectFontTypeItalic();
            docEditor.selectFontTypeStrikeout();
            docEditor.sendSomeText("Asana 14 Перечеркнутый");

            docEditor.unselectFontTypeStrikeout();
            docEditor.sendSomeText(textAboutSakura);
            docEditor.selectTextAll();
            docEditor.moveToLayoutMenu();
            docEditor.layoutColumnsMenu();
            docEditor.layoutColumnsMenuSetThree();

            docEditor.moveToHomeMenu();
            docEditor.alignTextRight();
            docEditor.alignTextLeft();
            docEditor.alignTextJust();

            docEditor.moveToInsertMenu();
            docEditor.insertTableCustom(5, 5);

    }
}
