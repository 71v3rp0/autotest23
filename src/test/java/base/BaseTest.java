package base;

import common.CommonActions;
import common.Config;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;
    private Boolean isClosing = false;

    @AfterTest
    public void afterTestClearCookies() {
        if (Config.CLEAR_COOKIES) {
            if (!isClosing) {
                driver.manage().deleteAllCookies();
            }
        }
    }

    @BeforeClass
    public void create() {
        driver = CommonActions.createDriver();
    }

//    @AfterSuite(alwaysRun = true)
//    public void close() {
//        if (Config.CLOSE_BROWSER) {
//            driver.quit();
//        }
//    }

    @AfterClass(alwaysRun = true)
    public void close() {
        if (Config.CLOSE_BROWSER) {
            driver.quit();
            isClosing = true;
        }
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] saveFailureScreenShot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @AfterMethod
    public void afterTest(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            saveFailureScreenShot(driver);
        }
    }
}
