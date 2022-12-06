package org.example.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.pageobjects.TodoInput;
import org.example.pageobjects.TodoMVCApp;
import org.example.pageobjects.TodosList;

public class UserActions {

    @Steps
    TodoInput todoInput;
    @Steps
    TodosList todosList;


    @Step
    public void userCompletesTodo() {
        todosList.completeTodo();
    }

    @Step
    public void userCreatesNewTodo(String todoName) {
        todoInput.createNewTodo(todoName);
    }


}
