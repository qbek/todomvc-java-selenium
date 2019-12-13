package com.github.qbek.pageobjects;

import com.github.qbek.aux.IsElementDisplayed;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TodosList extends PageObject implements IsElementDisplayed {

    By todoList = By.cssSelector(".todo-list");
    By singleTodo = By.cssSelector(".todo-list li");
    By todoCompleteToggleSelector = By.cssSelector("input.toggle");

    public String getAllTodos() {
        WebDriver browser = getDriver();
        WebElement todos = browser.findElement(todoList);
        String allTodos = todos.getText();
        return allTodos;
    }

    @Override
    public List<WebElement> getWebElements() {
        return null;
    }

    @Override
    public Boolean isDisplayed() {
        return true;
    }

    public void completeTodo(String todoToComplete) {
        WebDriver browser = getDriver();
        List<WebElement> todoElements = browser.findElements(singleTodo);
        System.out.println("Start traversing");
        for (WebElement todoToCheck : todoElements) {
            String todoName = todoToCheck.getText();
            System.out.println("Check todo with name: " + todoName);
            if (todoName.equals(todoToComplete)) {
                System.out.println("WE HAVE FOUND IT!!! LETS COMPLETE IT!!");
                todoToCheck.findElement(todoCompleteToggleSelector).click();
                break;
            }
        }
        System.out.println("Stop traversiong");
    }
}
