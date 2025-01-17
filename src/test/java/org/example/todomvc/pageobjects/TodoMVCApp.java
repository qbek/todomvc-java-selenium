package org.example.todomvc.pageobjects;

import net.serenitybdd.core.pages.PageObject;

import java.io.IOException;
import java.util.Properties;

public class TodoMVCApp extends PageObject {

    public void openMainView() {
        var cfgFileStream = this.getClass().getResourceAsStream("/" + System.getProperty("env") + ".properties");
        var cfg = new Properties();
        try {
            cfg.load(cfgFileStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        getDriver().get(cfg.getProperty("url"));
    }
}
