package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;

import java.io.IOException;

import static org.example.data.EnvConfiguration.getUrl;

public class TodoMvcApp extends PageObject {

    @Step
    public void openTodoMVC() {
        getDriver().get(getUrl());
    }
}
