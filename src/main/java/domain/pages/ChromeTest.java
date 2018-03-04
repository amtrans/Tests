package domain.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.TimeUnit;

public class ChromeTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private SoftAssert softAssert;

    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        Reporter.log("Before Suit executed", 1, true);
    }

    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
        //driver.manage().window().fullscreen();
        driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 3);
        softAssert = new SoftAssert();
        driver.get("http://automationpractice.com");
        Reporter.log("Before Method executed", 1, true);
    }

    @AfterMethod
    public void teardown() {
        Reporter.log("After Method executed", 1, true);
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testCreateNewAccount() throws InterruptedException {
        CreateAccountForm form = new HomePage(driver).signIn().createNewAccount(Math.random() + "@mfsa.ru");
        Thread.sleep(2000);
        form.clickMr();
        form.enterFN("Ksusha");
        form.enterLN("Sierikova");
        form.enterPassw("Ks1987");
        form.enterAddress("my address");
        form.enterCity("my city");
        form.setState("1");
        form.enterPostcode("12346");
        form.enterMobilePhone("1234567");
        form.enterAlias("alias");
        form.setBirthDate(LocalDate.of(1987, Month.AUGUST, 7));
        form.clickSubmit();
        softAssert.assertEquals(new HomePage(driver).isRegistered(), "Welcome to your account. Here you can manage all of your personal information and orders.");
        softAssert.assertAll();
    }
}