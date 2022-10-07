package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.awaitility.Awaitility;
import org.openqa.selenium.By;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class TodosList extends PageObject {

    private final By TODOS_LIST = By.cssSelector(".todo-list");
    private final By COMPLETE_TOGGLE = By.cssSelector(".toggle");
    private final By TODO_ELEMENT = By.cssSelector(".todo-list > li");
    private final By TODO_COMPLETED = By.cssSelector(".todo-list > .completed");

    @Step
    public void checkIfTodoIsDisplayed(String todoName) {
        find(TODOS_LIST).shouldContainText(todoName);
    }

    @Step
    public void completeTodo(String name) {
        findTodoByName(name).find(COMPLETE_TOGGLE).click();
    }

    private WebElementFacade findTodoByName(String name) {
        //JAVA 7-
//        var allTodos = findAll(TODO_ELEMENT);
//        for (var todo : allTodos) {
//            if (todo.getText().equals(name)) {
//                return todo;
//            }
//        }
        try {
            return findEach(TODO_ELEMENT)
                    .filter(todo -> todo.containsOnlyText(name))
                    .findFirst().get();
        } catch (NoSuchElementException e) {
            throw new AssertionError("Todo element: " + name + " not found.");
        }
    }

    @Step
    public void checkIfTodoMarkedAsCompleted() {
        find(TODO_COMPLETED).shouldBePresent();
    }

    @Step
    public void checkIfTodoIsNOTDisplayed(String name) {
        find(TODOS_LIST).shouldNotContainText(name);
    }


    public void waitForTodo(String name) {
        Awaitility.await().pollInSameThread()
                .atMost(10, TimeUnit.SECONDS).pollInterval(1, TimeUnit.SECONDS)
                .until(new WaitForTodoWithName(name));
    }

    private class WaitForTodoWithName implements Callable<Boolean> {

        private String name;

        public WaitForTodoWithName(String name) {
            this.name = name;
        }

        @Override
        public Boolean call() throws Exception {
            System.out.println("Sprawdzam czy jest STOP");
            return find(TODOS_LIST).containsText(this.name);
        }
    }
}
