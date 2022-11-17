package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TodoMvcApp extends PageObject {

    public void openTodoMVC() throws IOException {
        String filename = System.getProperty("env") + ".properties";

        InputStream file = this.getClass().getResourceAsStream("/" + filename);
        Properties cfg = new Properties();
        cfg.load(file);
        getDriver().get(cfg.getProperty("todoMVCapp"));
    }
}
