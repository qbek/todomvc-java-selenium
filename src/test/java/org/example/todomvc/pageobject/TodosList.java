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
        WebElement toggle = getDriver().findElement(TODO_COMPLETION_TOGGLE);
        toggle.click();
    }

    @Step("Check if todo name is in element: #TODO_ELEMENT")
    public void checkIfTodoDisplayed(String expectedName) {
        WebElement todo = getDriver().findElement(TODO_ELEMENT);
        String todoText = todo.getText();
        Assertions.assertThat(todoText).isEqualTo(expectedName);
    }

    @Step
    public void checkIfTodoCompleted() {
        WebElement todo = getDriver().findElement(TODO_ELEMENT);
        String classes = todo.getAttribute("class");
        Assertions.assertThat(classes).as("Completed todo should have class completed").isEqualTo("completed");
    }
}
