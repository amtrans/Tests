package com.google;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@Name("Search Form")
@Block(@FindBy(css = "#searchform"))

public class SearchArrow extends HtmlElement {

    @Name("Search request input")
    @FindBy (css = "#lst-ib")
    private TextInput requestInput;

    @Name("Search button")
    @FindBy (name = "btnK")
    private Button searchButton;

    @Name("Lucky button")
    @FindBy (name = "btnI")
    private Button luckyButton;

    public void search (String request){
        requestInput.sendKeys(request);
        searchButton.click();
    }

    public void lucky (String request) {
        requestInput.sendKeys(request);
        luckyButton.click();
    }

}
