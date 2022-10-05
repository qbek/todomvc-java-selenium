package org.example.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.pageobjects.TodoInput;
import org.example.pageobjects.TodoMVCapp;
import org.example.pageobjects.TodosList;

public class UserSteps {

    @Steps
    TodoInput todoInput;

    @Steps
    TodosList todosList;

    @Steps
    TodoMVCapp todoMvc;


//    @Step
//    public void userChecksIfCompletedTodoIsOnCompletedFilter(String name) {
//        var completedFilter = browser.findElement(By.cssSelector("[href=\"#/completed\""));
//        completedFilter.click();
//
//        var todosList = browser.findElement(By.cssSelector(".todo-list"));
//        var todos = todosList.getText();
//        MatcherAssert.assertThat("Todo is not on the list", todos, Matchers.equalTo(name));
//    }
//
//    @Step
//    public void userChecksIfCompletedTodoIsNotOnActiveFilter(String name) {
//        var activeFilter = browser.findElement(By.cssSelector("[href=\"#/active\""));
//        activeFilter.click();
//
//        var todosList = browser.findElement(By.cssSelector(".todo-list"));
//        var todos = todosList.getText();
//        MatcherAssert.assertThat("Todo is not on the list", todos, Matchers.emptyOrNullString());
//    }
//
    @Step
    public void userChecksItTodoIsMarkedAsCompleted() {

        todosList.checkIfTodoMarkedAsCompleted();

    }

    @Step
    public void userCompletesTodo() {
        todosList.completeTodo();
    }

    @Step
    public void userChecksIfTodoWasCreated(String todoName) {
        todosList.checkIfTodoIsDisplayed(todoName);
    }

    @Step
    public void userOpenTodoMVC() {
        todoMvc.openApp();
    }

    @Step
    public void userCreatesANewTodo(String name) {
        todoInput.addTodo(name);
    }
}
