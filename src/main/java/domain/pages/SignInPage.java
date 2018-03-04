package domain.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

@Name("Sing In Page")
@Block(@FindBy(css = "#create-account_form"))
public class SignInPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SignInPage(WebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver=driver;
    }

    @Name("Email Adress Input")
    @FindBy(css=".account_input ")
    private TextInput name;

    @Name("Create an account")
    @FindBy(css="#SubmitCreate")
    private Button createAccountButton;

    public CreateAccountForm createNewAccount(String email) throws InterruptedException {
        name.sendKeys(email);
        Thread.sleep(2000);
        createAccountButton.click();
        Thread.sleep(2000);
        return new CreateAccountForm(driver);

    }
}