package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.Properties;

public class TodoMVCapp extends PageObject {

    private final By TODO_INPUT = By.cssSelector(".new-todo");

    public void openApp() {

        var filename = System.getProperty("env") + ".env.properties";
        try {
            var configurationFile = this.getClass().getResourceAsStream("/" + filename);
            var cfg = new Properties();
            cfg.load(configurationFile);
            getDriver().get(cfg.getProperty("todomvcurl"));
            find(TODO_INPUT).waitUntilVisible();
        } catch (IOException e) {
            throw new RuntimeException("There is no configuration file with name: " + filename);
        }
    }
}
