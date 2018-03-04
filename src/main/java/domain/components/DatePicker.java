package domain.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Name("Date Picker")
public class DatePicker {
    private WebDriver driver;
    private WebDriverWait wait;

    public DatePicker(WebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
        wait = new WebDriverWait(driver, 3);
        this.driver=driver;
    }

    @Name("Day")
    @FindBy(css="#days")
    private Select day;

    @Name("Month")
    @FindBy(css="#months")
    private Select month;

    @Name("Year")
    @FindBy(css="#years")
    private Select year;

    public void setDate(LocalDate date) throws InterruptedException {
        day.selectByValue(String.valueOf(date.getDayOfMonth()));
        Thread.sleep(1000);
        month.selectByValue(String.valueOf(date.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH)));
        Thread.sleep(1000);
        year.selectByValue(String.valueOf(date.getYear()));
        Thread.sleep(1000);

    }

    @Name("State")
    @FindBy(css="#id_state.form-control")
    private Select state;

    public void setState(String stateF){
        state.selectByValue(String.valueOf(stateF));
    }
}