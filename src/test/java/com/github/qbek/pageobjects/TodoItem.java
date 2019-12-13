package com.github.qbek.pageobjects;

import com.github.qbek.aux.IsElementDisplayed;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.yecht.Data;

import java.util.List;

public class TodoItem extends PageObject implements IsElementDisplayed  {

    By todoCompleteToggleSelector = By.cssSelector(".todo-list input.toggle");
    By todoItemSelector = By.cssSelector(".todo-list li");

    public void completeATodo() {
        WebDriver browser = getDriver();
        WebElement toggleCheckbox = browser.findElement(todoCompleteToggleSelector);
        WebElementFacade toggle2 = element(todoItemSelector);
        toggle2
        toggleCheckbox.click();
    }

    public String getTodoClasses() {
        WebDriver browser = getDriver();
        WebElement todo = browser.findElement(todoItemSelector);
        String todoClasses = todo.getAttribute("class");
        return todoClasses;
    }

    @Override
    public List<WebElement> getWebElements() {
        return getDriver().findElements(todoItemSelector);
    }
}
