package domain.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

@Name("Home Page")
@Block(@FindBy(css = "#page"))
public class HomePage{
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver=driver;
    }

    @Name("Login")
    @FindBy(css="a.login")
    private WebElement login;

    public SignInPage signIn() throws InterruptedException {
        login.click();
        Thread.sleep(2000);
        return new SignInPage(driver);
    }

    @Name("Check register account")
    @FindBy(css=".info-account")
    public WebElement isReg;

    public String isRegistered(){
        return wait.until(ExpectedConditions.visibilityOf(isReg)).getText();
    }
}