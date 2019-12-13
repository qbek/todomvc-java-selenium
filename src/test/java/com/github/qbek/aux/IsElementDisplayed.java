package com.github.qbek.aux;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface IsElementDisplayed {

    public List<WebElement> getWebElements();

    public default Boolean isDisplayed() {
        List<WebElement> allTodos = getWebElements();
        if(allTodos.size() == 0) return false;
        else return true;
    };
}
