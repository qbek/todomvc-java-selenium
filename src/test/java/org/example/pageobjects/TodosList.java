package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.apache.commons.digester.annotations.rules.CallMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class TodosList extends PageObject {

    private static final By TODOS_LIST = By.cssSelector(".todo-list");
    private static final By TODO_ELEMENT = By.cssSelector(".todo-list li");
    private static final By TODO_COMPLETE_BUTTON = By.cssSelector(".todo-list .toggle");
    private static final By COMPLETED_TODO = By.cssSelector(".todo-list .completed");
    private static final By COMPLETE_TOGGLE = By.cssSelector(".toggle");


    @Step
    public void checkIfTodoIsListed(String todoName) {
        find(TODOS_LIST).shouldContainText(todoName);
    }

    @Step
    public void completeTodo() {
        find(TODO_COMPLETE_BUTTON).click();
    }

    @Step
    public void completeTodo(String name) {
        var todo = findTodoByName(name);
        todo.find(COMPLETE_TOGGLE).click();
    }

    private WebElementFacade findTodoByName(String name) {
        //JAVA 7-
//        var todos = findAll(TODO_ELEMENT);
//        for (WebElementFacade todo : todos) {
//            if(todo.getText().equals(name)) {
//               return todo;
//            }
//        }

        //JAVA 8+
        WebElementFacade todo = findEach(TODO_ELEMENT)
                .filter(t -> t.containsOnlyText(name))
                .findFirst().get();

        if(Objects.isNull(todo)) { throw new AssertionError("Todo was not found"); }
        return todo;
    }

    @Step
    public void checkIfTodoCompleted() {
        find(COMPLETED_TODO).shouldBePresent();
    }

    @Step
    public void checkIfTodoIsNotListed(String todoName) {
        find(TODOS_LIST).shouldNotContainText(todoName);
    }
}
