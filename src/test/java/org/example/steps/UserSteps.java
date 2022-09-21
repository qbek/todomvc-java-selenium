package org.example.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.pageobjects.NewTodoInput;
import org.example.pageobjects.TodoMVCApp;
import org.example.pageobjects.TodosList;
import org.openqa.selenium.By;

public class UserSteps {



    private static final By TODO_COMPLETE_BUTTON = By.cssSelector(".todo-list .toggle");
    private static final By COMPLETED_TODO = By.cssSelector(".todo-list .completed");


    @Steps
    NewTodoInput todoInput;

    @Steps
    TodosList todosList;

    @Steps
    TodoMVCApp app;


//    @Step
//    public void userChecksIfCompletedTaskIsOnCompletedTab(String todoName) {
//        var completedFilter = browser.findElement(By.cssSelector(".filters [href='#/completed']"));
//        completedFilter.click();
//
//        var allTodos = browser.findElement(TODOS_LIST);
//        var todos = allTodos.getText();
//        MatcherAssert.assertThat("Todo has correct name", todos, Matchers.containsString(todoName));
//    }
//
//    @Step
//    public void userChecksIfCompletedTaskIsNotOnActiveTab(String todoName) {
//        var activeFilter = browser.findElement(By.cssSelector(".filters [href='#/active']"));
//        activeFilter.click();
//        var allTodos = browser.findElement(TODOS_LIST);
//        var todos = allTodos.getText();
//        MatcherAssert.assertThat("Todo has correct name", todos, Matchers.not(Matchers.containsString(todoName)));
//
//    }
//
//    @Step
//    public void userChecksIfTodoIsMarkedAsCompleted() {
//        //pierwszy sposób poprzez sprawdzanie czy została dodana klasa "comnpleted"
////        var todo = browser.findElement(By.cssSelector(".todo-list li"));
////        var classes = todo.getAttribute("class");
////        MatcherAssert.assertThat("Todo is marked as completed", classes, Matchers.equalTo("completed"));
//
//        //drugi sposób -> sprawdzamy czy istnieje zakonzone todo
//        var completedTodos = browser.findElements(COMPLETED_TODO);
//        MatcherAssert.assertThat("There is a todo marked as completed", completedTodos, Matchers.hasSize(1));
//    }
//
//    @Step
//    public void userCompletesTodo() {
//        var completeToggle = browser.findElement(TODO_COMPLETE_BUTTON);
//        completeToggle.click();
//    }
//
    @Step
    public void userChecksIfTodoIsCreated(String todoName) {
        todosList.checkIfTodoIsDisplayed(todoName);
    }

    @Step
    public void userAddsANewTodo(String todoName) {
        todoInput.createNewTodo(todoName);
    }

    @Step
    public void userOpensTodoMVCApp() {
        app.openTodoMVC();
    }


    @Step
    public void userClosesTodoMVCApp() {
        app.closeTodoMVC();
    }
}
