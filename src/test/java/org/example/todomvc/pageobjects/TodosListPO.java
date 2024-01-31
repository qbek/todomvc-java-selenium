package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.awaitility.Awaitility;
import org.awaitility.core.ConditionTimeoutException;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class TodosListPO extends PageObject {
    By todoListEl = By.cssSelector(".todo-list");
    By completeButtonEl = By.cssSelector(".toggle");
    By todoItemEl = By.cssSelector(".todo-list li");

    @Step
    public void checkIfTaskExists(String name) {
        find(todoListEl).shouldContainText(name);
    }

    public void completeTask() {
        find(completeButtonEl).click();
    }

    public void checkIfTaskCompleted() {
        String taskClasses = find(todoItemEl).getAttribute("class");
        MatcherAssert.assertThat("Task should be marked as completed", taskClasses, Matchers.equalTo("completed"));
    }

    public void checkIfTaskNotExists() {
        MatcherAssert.assertThat("Task should not be on the Active list", findAll(todoListEl), Matchers.hasSize(0));
    }

    public void waitForTheOne() {
        try {
            Awaitility.await().pollInSameThread().atMost(15, TimeUnit.SECONDS).pollInterval(1, TimeUnit.SECONDS)
                    .until(new WaitForTheTask("THE ONE"));
            System.out.println("Doczekałem sie!!!!!");
        } catch (ConditionTimeoutException e) {
            throw new AssertionError("THE ONE was not pressent after 15 seconds");
        }
    }

    private class WaitForTheTask implements Callable<Boolean> {

        private String name;

        public WaitForTheTask(String name) {
            this.name = name;
        }

        @Override
        public Boolean call() throws Exception {
            System.out.println("Sprawdzam....");
            return find(todoListEl).containsText(name);
        }
    }
}
