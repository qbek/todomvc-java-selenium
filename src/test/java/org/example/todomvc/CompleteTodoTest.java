package org.example.todomvc;

import org.junit.jupiter.api.Test;

public class CompleteTodoTest extends BaseTestSetup{

    @Test
    public void userCanCompleteATodo() {
        var todoName = "Zadanie do zakończenia";
        app.openTodoMVCPage();

        newTodoInput.enterTodoName(todoName);
        newTodoInput.submitTodo();

        todosList.completeTodo();
        todosList.checkTodoMarkedAsCompleted();

        todoFilters.gotoActiveTodos();
        todosList.checkTodoListIsEmpty();

        todoFilters.gotoCompletedTodos();
        todosList.checkTodoIsOnTheList(todoName);
    }
}
