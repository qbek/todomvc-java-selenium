package org.example.todomvc.steps;


import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.todomvc.pageobject.TodoInput;
import org.example.todomvc.pageobject.TodoMVCApp;
import org.example.todomvc.pageobject.TodosList;
import org.openqa.selenium.WebDriver;

public class UserActions {

    @Steps
    TodoInput todoInput;

    @Steps
    TodosList todosList;

    @Steps
    TodoMVCApp app;


    @Step
    public void userOpensTodoMVCApp() {
        app.openMainPage();
    }

    @Step
    public void userCreatesANewTodo(String name) {
        todoInput.createTodo(name);
    }

    @Step
    public void userCompleteTodo() {
        todosList.completeTodo();
    }


}
