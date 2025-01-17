package org.example.todomvc;

import org.example.todomvc.pageobjects.NewTodoInput;
import org.example.todomvc.pageobjects.TodoFilters;
import org.example.todomvc.pageobjects.TodoMVCApp;
import org.example.todomvc.pageobjects.TodosList;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class CreateTodoTests extends BaseTestSetup {

    @Test
    public void userCanCreateATodo() {
        var name = "To jest moje zadanie";
        userActions.userOpensTodoMVCapp();
        userActions.userCreatesANewTodo(name);
        userActions.userChecksIfTodoIsCreated();
    }

}
