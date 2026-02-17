package org.example.steps;

import org.openqa.selenium.WebDriver;

public class PreconditionSteps {

    WebDriver browser;
    UserSteps steps;

    public PreconditionSteps(WebDriver browser) {
        this.browser = browser;
        steps = new UserSteps(browser);
    }


    public void userHasTodoCreated(String todoName) {
      steps.userCreatesANewTodo(todoName);
    }

    public void userHasCompletedTodo(String todoName) {
        steps.userCreatesANewTodo(todoName);
        steps.userCompletesTodo();
    }
}
