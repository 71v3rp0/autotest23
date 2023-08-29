import base.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Epic("Тестовый раздел")
@Feature("Тесты")
@Test
public class Tests extends BaseTest {

    @Story("Тест 1")
    @Link("test link")
    @Test
    public void test() {


    }
}
