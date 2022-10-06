package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.util.NoSuchElementException;

public class TodosList extends PageObject {

    private final By TODOS_LIST = By.cssSelector(".todo-list");
    private final By COMPLETE_TOGGLE = By.cssSelector(".toggle");
    private final By TODO_ELEMENT = By.cssSelector(".todo-list > li");
    private final By TODO_COMPLETED = By.cssSelector(".todo-list > .completed");

    @Step
    public void checkIfTodoIsDisplayed(String todoName) {
        find(TODOS_LIST).shouldContainText(todoName);
    }

    @Step
    public void completeTodo() {
        find(COMPLETE_TOGGLE).click();
    }

    @Step
    public void completeTodo(String name) {
        findTodoByName(name).find(COMPLETE_TOGGLE).click();
    }

    private WebElementFacade findTodoByName(String name) {
        //JAVA 7-
//        var allTodos = findAll(TODO_ELEMENT);
//        for (var todo : allTodos) {
//            if (todo.getText().equals(name)) {
//                return todo;
//            }
//        }
        try {
            return findEach(TODO_ELEMENT)
                    .filter(todo -> todo.containsOnlyText(name))
                    .findFirst().get();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Todo element: " + name + " not found.");
        }
    }

    @Step
    public void checkIfTodoMarkedAsCompleted() {
        find(TODO_COMPLETED).shouldBePresent();
    }

    @Step
    public void checkIfTodoIsNOTDisplayed(String name) {
        find(TODOS_LIST).shouldNotContainText(name);
    }


}
