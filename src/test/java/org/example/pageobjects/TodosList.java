package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TodosList extends PageObject {

//    pierwsze podejscie do rozwiazania problmeu DRY w selectorach
//    private String listSelector = ".todo-list";
//    private String todoElementSelector = listSelector + " li";

    // moje osobiste podejscie i swiadome zlamanie zasady DRY
//    private By todoList = By.cssSelector(".todo-list");
//    private By todoElement = By.cssSelector(".todo-list li");

    private final By todoList = By.cssSelector(".todo-list");
    private final By todoElement = By.cssSelector("li");
    private final By completeToggle = By.cssSelector(".toggle");

    @Step
    public void checkIfTodoIsOnTheList(String name) {
        find(todoList).shouldContainText(name);
    }

    @Step
    public void checkIfTodoIsNOTonTheList(String name) {
        find(todoList).shouldNotContainText(name);
    }

    @Step
    public void checkIfTodoIsMarkedAsCompleted() {
        String completitionMark = "completed";
        String elementClasses = find(todoList).find(todoElement).getAttribute("class");
        assertThat("Todo should be marked as completed", elementClasses, equalTo(completitionMark));
    }

    @Step
    public void completeTodo() {
        find(todoList).find(todoElement).find(completeToggle).click();
    }
}
