package org.example.todomvc;

import org.example.pageobjects.TodoFilters;
import org.junit.jupiter.api.Test;

public class CompleteTodoTests extends BaseTestSetup {

    TodoFilters todoFilters = new TodoFilters(browser);

    @Test
    public void userCanCompleteTheTodo() {
        var todoName = "Zadanie do zakończenia";
        todoInput.enterTodoName(todoName);
        todoInput.submitTodo();

        todoList.completeTodo();
        todoList.checkIsTodoMarkedAsCompleted();
    }

    @Test
    public void userCanFilterActiveTodos() {
        var todoName = "Zadanie do zakończenia kolejne";
        todoInput.enterTodoName(todoName);
        todoInput.submitTodo();
        todoList.completeTodo();
        todoFilters.gotoActive();
        todoList.checkTodoListIsEmpty();
    }


    @Test
    public void userCanFilterCompltedTodos() {
        var todoName = "Zadanie do zakończenia żółć";
        todoInput.enterTodoName(todoName);
        todoInput.submitTodo();
        todoList.completeTodo();
        todoFilters.gotoCompleted();
        todoList.checkTodoHasCorrectName(todoName);
    }
}
