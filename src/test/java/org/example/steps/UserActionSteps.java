package org.example.steps;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.data.TestDataManager;
import org.example.pageobjects.NewTodo;
import org.example.pageobjects.TodoFilters;
import org.example.pageobjects.TodoMvcApp;
import org.example.pageobjects.TodosList;

import java.io.IOException;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.core.Serenity.setSessionVariable;
import static org.example.data.TestDataEntities.TASK_NAME;

public class UserActionSteps {

    private String actor;

    @Steps
    NewTodo newTodoInput;

    @Steps
    TodosList todosList;

    @Steps
    TodoFilters todoFilters;

    @Steps
    TodoMvcApp app;

    TestDataManager dataManager = new TestDataManager();


    @Step("#actor create a new task")
    public void userCreatesNewTask() {
        setSessionVariable(TASK_NAME).to(dataManager.generateTaskName());
        newTodoInput.createTask(sessionVariableCalled(TASK_NAME));
    }


    @Step
    public void userCompletesTheTask() {
        todosList.completeTodo();
    }

    public void userOpensTodoMVCApp() throws IOException {
        app.openTodoMVC();
    }


    @Step
    public void userDeletesTodo() {
        todosList.deleteTask();
    }

    @Step
    public void userCreatesFewTodos() {
        var tasks = dataManager.generateFewTasksName();
        for (String task : tasks) {
            newTodoInput.createTask(task);
        }
    }

    @Step
    public void userCreateTheOne() {
        Serenity.recordReportData().withTitle("What is THE ONE?").andContents("THE ONE exists only to be deleted");
        newTodoInput.createTask("THE ONE!!!");
    }

    @Step
    public void userDeletesTheOne() {
        todosList.deleteTask("THE ONE!!!");
    }


    @Step
    public void userWaitForTheOne() {
        todosList.waitForTask("THE ONE");
    }

    @Step
    public void userSwitchesToActiveTab() {
        todoFilters.switchToActive();
    }

    @Step
    public void userSwitchesToCompletedTab() {
        todoFilters.switchToCompleted();
    }
}
