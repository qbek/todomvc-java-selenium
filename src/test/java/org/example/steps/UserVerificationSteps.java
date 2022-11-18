package org.example.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.data.TestData;
import org.example.pageobjects.TodosList;

public class UserVerificationSteps {

    @Steps
    TodosList todosList;

    @Steps(shared = true)
    TestData testData;

    @Step
    public void userChecksIfTodoIsOnTheList() {
        todosList.checkIfTodoDisplayed(testData.getTaskName());
    }

    @Step
    public void userChecksIfTaskIsNOTDisplayed() {
        todosList.checkIfTodoNOTDisplayed(testData.getTaskName());
    }

    @Step
    public void userChecksIfTaskIsMarkedAsCompleted() {
        todosList.checkIfTodoMarkedAsCompleted();
    }

    @Step
    public void userChecksIfTodoIsNotOnTheList() {
        todosList.checkIfTodoNOTDisplayed(testData.getTaskName());
    }

    @Step
    public void userChecksIfTodoIsOnTheList(String the_one) {
        todosList.checkIfTodoDisplayed("THE ONE");
    }


}
