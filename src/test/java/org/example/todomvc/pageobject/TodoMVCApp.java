package org.example.todomvc.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;

public class TodoMVCApp extends PageObject  {

    private final String TODOMVC_URL = "https://todomvc.com/examples/jquery/#/all";

    @Step("Open page at: '#TODOMVC_URL  '")
    public void openMainPage() {
        getDriver().get(TODOMVC_URL);
    }

}
