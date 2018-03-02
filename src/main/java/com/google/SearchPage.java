package com.google;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import com.google.SearchArrow;

public class SearchPage extends HtmlElement {
    private SearchArrow searchArrow;
    private WebDriver driver;

    public SearchPage (WebDriver driver){
        HtmlElementLoader.populatePageObject(this, driver);
    }

    public void search (String request){
        searchArrow.search(request);
    }

    public void lucky (String request){
        searchArrow.search(request);
    }
}
