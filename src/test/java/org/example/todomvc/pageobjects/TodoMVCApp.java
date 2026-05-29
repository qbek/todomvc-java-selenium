package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;

import java.io.IOException;
import java.util.Properties;

public class TodoMVCApp extends PageObject {
    private final static String TODO_URL_KEY = "todomcv_url";

    @Step
    public void openTodoMVCPage() {

        var cfgName = System.getProperty("env");
        var cfgFile = this.getClass().getResourceAsStream("/" + cfgName + ".env.properties");
        var cfg = new Properties();
        try {
            cfg.load(cfgFile);
        } catch (IOException e) {
            throw new RuntimeException("Please provide configuration file");
        }
        getDriver().get(cfg.getProperty(TODO_URL_KEY));
    }
}
