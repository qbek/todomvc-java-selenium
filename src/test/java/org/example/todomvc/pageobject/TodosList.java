package org.example.todomvc.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TodosList extends PageObject {

    private final By TODO_ELEMENT = By.cssSelector(".todo-list li");
    private final By TODO_COMPLETION_TOGGLE = By.cssSelector(".toggle");


    @Step
    public void completeTodo () {
        find(TODO_COMPLETION_TOGGLE).click();
    }

    @Step("Check if todo name is in element: #TODO_ELEMENT")
    public void checkIfTodoDisplayed(String expectedName) {
        find(TODO_ELEMENT).shouldContainOnlyText(expectedName);
    }

    @Step
    public void checkIfTodoCompleted() {
        String classes = find(TODO_ELEMENT).getAttribute("class");
        Assertions.assertThat(classes).as("Completed todo should have class completed").isEqualTo("completed");
    }
}
