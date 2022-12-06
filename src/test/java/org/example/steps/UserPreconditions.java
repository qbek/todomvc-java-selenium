package org.example.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.pageobjects.TodoMVCApp;

public class UserPreconditions {

    @Steps
    TodoMVCApp mvcApp;

    @Steps
    UserActions action;

    @Step
    public void userIsOnTodoMVCapp() {
        mvcApp.openTodoMVCapp();
    }

    @Step
    public void userHasTodo(String todoName) {
        action.userCreatesNewTodo(todoName);
    }
}
