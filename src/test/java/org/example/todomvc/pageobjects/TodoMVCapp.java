package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TodoMVCapp extends PageObject {

    @Step
    public void openTodoMVC () {
        try {
            String envName = System.getProperty("env");
            InputStream file = this.getClass().getResourceAsStream("/" + envName + ".env.properties");
            Properties cfg = new Properties();
            cfg.load(file);
            getDriver().get(cfg.getProperty("todoMVC_url"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
