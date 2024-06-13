package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;

import java.io.IOException;
import java.util.Properties;

public class TodoMVC extends PageObject {

    @Step
    public void openApp () {
        try {
            var env = System.getProperty("env");
            var filename = String.format("/%s.env.properties", env);
            var file = this.getClass().getResourceAsStream(filename);
            var cfg = new Properties();
            cfg.load(file);
            getDriver().get(cfg.getProperty("TODO_MVC_URL"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
