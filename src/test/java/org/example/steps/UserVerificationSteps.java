package org.example.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.pageobjects.TodosList;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static org.example.data.TestDataEntities.TASK_NAME;

public class UserVerificationSteps {

    @Steps
    TodosList todosList;


    @Step
    public void userChecksIfTodoIsOnTheList() {
        todosList.checkIfTodoDisplayed(sessionVariableCalled(TASK_NAME));
    }

    @Step
    public void userChecksIfTaskIsNOTDisplayed() {
        todosList.checkIfTodoNOTDisplayed(sessionVariableCalled(TASK_NAME));
    }

    @Step
    public void userChecksIfTaskIsMarkedAsCompleted() {
        todosList.checkIfTodoMarkedAsCompleted();
    }

    @Step
    public void userChecksIfTodoIsNotOnTheList() {
        todosList.checkIfTodoNOTDisplayed(sessionVariableCalled(TASK_NAME));
    }

    @Step
    public void userChecksIfTodoIsOnTheList(String the_one) {
        todosList.checkIfTodoDisplayed("THE ONE");
    }


}
