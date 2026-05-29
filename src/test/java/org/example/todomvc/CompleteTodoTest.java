package org.example.todomvc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompleteTodoTest extends BaseTestSetup {

    @BeforeEach
    public void prepareApp() { given.userHasTodoMvcAppOpened(); }

    @Test
    public void userCanCompleteATodo() {
        var todoName = "Zadanie do zakończenia";
        given.userHasTodoCreated(todoName);
        when.userCompletesTodo();
        then.userChecksTodoIsCompleted();
    }

    @Test
    public void userCanFilterActiveTodos() {
        var todoName = "Zadanie nie Aktywne";
        given.userHasCompletedTodo(todoName);
        when.userGoesToActiveTodos();
        then.userChecksTodosListIsEmpty();
    }

    @Test
    public void userCanFilterCompletedTodos() {
        var todoName = "Zadanie completed";
        given.userHasCompletedTodo(todoName);
        when.userGoesToCompletedTodos();
        then.userCheckTodoIsOnTodosList(todoName);
    }
}
