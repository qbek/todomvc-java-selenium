package org.example.todomvc.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import org.example.todomvc.pageobjects.TodoMVCApp;

public class GivenSteps {

    @Steps
    private TodoMVCApp app;
    @Steps
    private WhenSteps when;

    @Step("To jest dodatkowy komentarz otwarcia aplikacji")
    public void userHasTodoMvcAppOpened() {
        app.openTodoMVCPage();
    }

    @Step
    public void userHasTodoCreated(String todoName) {
        when.userCreatesANewTodo(todoName);
    }

    @Step("Użytkownik stworzył zadanie z nazwą: '{0}' i je zakończył")
    public void userHasCompletedTodo(String todoName) {
        userHasTodoCreated(todoName);
        when.userCompletesTodo();
    }
}
