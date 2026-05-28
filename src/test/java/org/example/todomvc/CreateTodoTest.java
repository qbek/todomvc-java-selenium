package org.example.todomvc;

import org.junit.jupiter.api.Test;

public class CreateTodoTest extends BaseTestSetup {

    @Test
    public void userCanCreateATodo() {
        var todoName = "Moje pierwsze Todo ze szkolenia";
        app.openTodoMVCPage();
        newTodoInput.enterTodoName(todoName);
        newTodoInput.submitTodo();
        todosList.checkTodoIsOnTheList(todoName);
    }
}
