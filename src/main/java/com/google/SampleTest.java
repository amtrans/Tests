package com.google;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import com.google.SearchPage;

public class SampleTest {

    private WebDriver driver = new ChromeDriver();
    private SearchPage searchPage = new SearchPage(driver);

    @BeforeMethod
    public void loadPage() {
        driver.get("https://www.google.com.ua/");
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }

    @Test
    public void sampleTest() {
        searchPage.search("Google");
        Assert.assertTrue((driver.findElement(By.cssSelector("#rcnt")).isDisplayed()));
    }

}
