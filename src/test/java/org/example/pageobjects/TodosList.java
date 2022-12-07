package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.SerenityActions;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WithByLocator;
import net.thucydides.core.annotations.Step;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.openqa.selenium.By.cssSelector;

public class TodosList extends PageObject {

    private static final By TODOS_LIST = cssSelector(".todo-list");
    private static final By TODO_ELEMENT = cssSelector(".todo-list li");
    private static final By TODO_COMPLETE_TOGGLE = cssSelector(".toggle");
    private static final By TODO_DELETE = cssSelector(".destroy");

    @Step("On the list: #TODOS_LIST should be todo: {0}")
    public void checkIfTodoDisplayed (String name) {
        find(TODOS_LIST).shouldContainOnlyText(name);
    }

    @Step("On the list: #TODOS_LIST should NOT be todo: {0}")
    public void checkIfTodoNOTDisplayed (String name) {
        find(TODOS_LIST).shouldNotContainText(name);
    }

    @Step("Check if: #TODO_ELEMENT has completed class")
    public void checkIfTodoCompleted () {
        assertThat("Todo is marked as completed", find(TODO_ELEMENT).getAttribute("class"), equalTo("completed"));
    }

    @Step("Click on #TODO_COMPLETE_TOGGLE")
    public void completeTodo() {
        find(TODO_COMPLETE_TOGGLE).click();
    }

    @Step
    public void checkIfAllTodosAreDisplayed(List<String> expectedTodosNames) {
        var actualTodosNames = findEach(TODO_ELEMENT)
                .map(todo -> todo.getText()).collect(Collectors.toList());
        assertThat("All todos are on the list in any order", actualTodosNames, containsInAnyOrder(expectedTodosNames.toArray()));
//        assertThat("All todos are on the list in exact order", actualTodosNames, equalTo(expectedTodosNames));
//        assertThat("At least todos in any order", actualTodosNames, hasItems(expectedTodosNames.toArray(new String[expectedTodosNames.size()])));
    }

    @Step
    public void deleteTodo() {
        var actions = new Actions(getDriver());
        actions.moveToElement(find(TODO_ELEMENT))
                .click(find(TODO_DELETE))
                .perform();

//        find(TODO_ELEMENT).click();
//        find(TODO_DELETE).click();

//        moveTo(TODO_ELEMENT);
//        find(TODO_DELETE).click();
    }

    public void deleteTodo(String name) {
        var todo = findTodoWithName(name);
        todo.click();
        todo.find(TODO_DELETE).click();
    }

    private WebElementFacade findTodoWithName(String name) {
        var allTodos = findAll(TODO_ELEMENT);
        for (var todo : allTodos) {
            if (todo.getText().equals(name)) {
                return todo;
            }
        }
        throw new AssertionError(format("Todo with %s name dosn't exist", name));
    }
}
