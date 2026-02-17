package org.example.todomvc;


import org.junit.jupiter.api.Test;

public class CreateTodoTests extends BaseTestSetup {


    @Test
    public void userCanCreateANewTodo() {
        var todoName = "Moje zadanie żółć";

        todoInput.enterTodoName(todoName);
        todoInput.submitTodo();

        todoList.checkListContainsAnyTodo();
        todoList.checkTodoHasCorrectName(todoName);
    }
}
