package domain.pages;

import domain.components.DatePicker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.time.LocalDate;

@Name("Sign In Page")
@Block(@FindBy(css = "#account-creation_form"))
public class CreateAccountForm {
    private WebDriver driver;
    private WebDriverWait wait;

    public CreateAccountForm(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver = driver;
    }

    public DatePicker setBirthDate(LocalDate date) throws InterruptedException {
        DatePicker datePicker = new DatePicker(driver);
        datePicker.setDate(date);
        return new DatePicker(driver);
    }

    @Name("titleMr")
    @FindBy(css = "#id_gender1")
    private WebElement titleMr;

    public void clickMr() {
        titleMr.click();
    }

    @Name("titleMrs")
    @FindBy(css = "#id_gender2")
    private WebElement titleMrs;

    public CreateAccountForm clickMrs() {
        titleMrs.click();
        return this;
    }

    @Name("firstName")
    @FindBy(css = "#customer_firstname")
    private TextInput firstName;

    public void enterFN(String fn) {
        firstName.sendKeys(fn);
    }

    @Name("lastName")
    @FindBy(css = "#customer_lastname")
    private TextInput lastName;

    public void enterLN(String ln) {
        lastName.sendKeys(ln);
    }

    @Name("passw")
    @FindBy(css = "#passwd")
    private TextInput passw;

    public void enterPassw(String pass) {
        passw.sendKeys(pass);
    }

    @Name("address")
    @FindBy(css = "#address1")
    private TextInput address;

    public void enterAddress(String add) {
        address.sendKeys(add);
    }

    @Name("city")
    @FindBy(css = "#city")
    private TextInput city;

    public void enterCity(String cityF) {
        city.sendKeys(cityF);
    }

    public DatePicker setState(String stateF) {
        DatePicker datePicker = new DatePicker(driver);
        datePicker.setState(stateF);
        return new DatePicker(driver);
    }

    @Name("postcode")
    @FindBy(css = "#postcode")
    private TextInput postcode;

    public void enterPostcode(String code) {
        postcode.sendKeys(code);
    }

    @Name("MobilePhone")
    @FindBy(css = "#phone_mobile")
    private TextInput mobilePhone;

    public void enterMobilePhone(String mf) {
        mobilePhone.sendKeys(mf);
    }

    @Name("Alias")
    @FindBy(css = "#alias")
    private TextInput alias;

    public void enterAlias(String aliasAddress) {
        alias.sendKeys(aliasAddress);
    }

    @Name("Submit")
    @FindBy(css = "#submitAccount")
    private Button submit;

    public void clickSubmit() throws InterruptedException {
        submit.click();
        Thread.sleep(2000);
    }

}