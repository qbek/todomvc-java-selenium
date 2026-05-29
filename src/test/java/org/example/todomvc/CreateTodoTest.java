package org.example.todomvc;

import org.example.todomvc.steps.GivenSteps;
import org.example.todomvc.steps.ThenSteps;
import org.example.todomvc.steps.WhenSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateTodoTest extends BaseTestSetup {

    @Test
    public void userCanCreateATodo() {
        var todoName = "Moje pierwsze Todo ze szkolenia";
        given.userHasTodoMvcAppOpened();
        when.userCreatesANewTodo(todoName);
        then.userCheckTodoIsOnTodosList(todoName);
    }
}
