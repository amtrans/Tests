import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.concurrent.TimeUnit;

/*Данный тест проверяет процедуру регистрации нового пользователя с рандомным email
с заполнением полей, отмеченных как обязательные к заполнению валидными данными*/

public class SignUpTest {

    private WebDriver driver;
    private Select select;

    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setupTest() {
         driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public Select getSelect(WebElement element) {
        select = new Select(element);
        return select;
    }

    @Test
    public void signUp() {
        driver.get("http://automationpractice.com");
        driver.findElement(By.cssSelector(".login")).click();
        String email = "mail"+RandomStringUtils.randomNumeric(5) + "@gmail.com"; //генерируем случайный email
        driver.findElement(By.cssSelector("#email_create")).sendKeys(email);
        driver.findElement(By.cssSelector("#SubmitCreate")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("input[id='id_gender1']")).click();
        driver.findElement(By.cssSelector("#customer_firstname")).sendKeys("Taras");
        driver.findElement(By.cssSelector("#customer_lastname")).sendKeys("Shevchenko");
        driver.findElement(By.cssSelector("#passwd")).sendKeys("qwerty123");
        driver.findElement(By.cssSelector("#address1")).sendKeys("Freedom Square");
        driver.findElement(By.cssSelector("#city")).sendKeys("Washington");
        WebElement listValue = driver.findElement(By.cssSelector("#id_state"));
        getSelect(listValue);
        select.selectByValue("53");
        driver.findElement(By.cssSelector("#postcode")).sendKeys("01001");
        driver.findElement(By.cssSelector("#phone_mobile")).sendKeys("1234567890");
        driver.findElement(By.cssSelector("#submitAccount")).click();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".logout")); //Проверяем наличие пункта меню Logout, потверждающего успешную регистрацию и вход на сайт
    }
}
