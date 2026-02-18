package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.awaitility.Awaitility;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class TodosList extends PageObject {

    private By todoListSelector = By.cssSelector("#todo-list");
    private By todoItemSelector = By.cssSelector("#todo-list li");
    private By todoCompleteChkboxSelector = By.cssSelector(".toggle");


    public void completeTodo() {
        find(todoCompleteChkboxSelector).click();
    }

    public void checkIsTodoMarkedAsCompleted() {
        MatcherAssert.assertThat("Todo is marked as completed",
                find(todoItemSelector).getAttribute("class"),
                Matchers.containsString("completed"));
    }

    public void checkListContainsAnyTodo() {
        find(todoListSelector).isDisabled();
    }

    public void checkTodoListIsEmpty() {
        MatcherAssert.assertThat("Empty todo list",
                findAll(todoItemSelector),
                Matchers.hasSize(3));
    }

    public void userCheckAllTodos(List<String> expected) {
        var allTodos = findAll(todoItemSelector);
        var todosOnThePage = new ArrayList<String>();
        for (var todo : allTodos) {
            todosOnThePage.add(todo.getText());
        }
        MatcherAssert.assertThat("All todos are on the list in exact order",
                todosOnThePage,
                Matchers.equalTo(expected));
//
//        MatcherAssert.assertThat("All todos are on the list in any order",
//                todosOnThePage,
//                Matchers.containsInAnyOrder(expected.toArray()));

//        MatcherAssert.assertThat("At least todos are on the list",
//                todosOnThePage,
//                Matchers.hasItems(expected.toArray(new String[expected.size()])));
    }

    public void waitForTheONE() {
        var taskName = "THE ONE 2";
        var waiter = new WaitForTheTask(taskName);
        Awaitility
                .await()
                .atMost(15, TimeUnit.SECONDS)
                .pollInterval(1, TimeUnit.SECONDS)
                .until(waiter);
    }

    private class WaitForTheTask implements Callable<Boolean> {

        private String name;

        public WaitForTheTask(String name) {
            this.name = name;
        }

        @Override
        public Boolean call() throws Exception {
            System.out.println("Czekam....");
            return find(todoListSelector).containsText(name);
        }
    }
}

