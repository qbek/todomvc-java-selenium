package com.github.qbek;

import com.github.qbek.aux.DataGenerator;
import com.github.qbek.steps.NavigationSteps;
import com.github.qbek.steps.SetupAndTeardownSteps;
import com.github.qbek.steps.TodoSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CompletingTodoTest {

    @Managed(driver="firefox")
    WebDriver browser;

    @Steps
    SetupAndTeardownSteps setup;

    @Steps
    TodoSteps actions;

    @Steps
    NavigationSteps navigation;

    DataGenerator data = new DataGenerator();

    @Before
    public void setup() {
        setup.userOpensTodoMvcApp();
    }

    @Test
    @WithTags({@WithTag("smoke"), @WithTag("test")})
    public void userCanCompleteATodo(){
        String todoName = data.generateTodoName();
        actions.userCreatesANewTodo(todoName);
        actions.userCompletesATodo();
        actions.userChecksIfTodoIsCompleted();
    }

    @Test
    public void completedTodoIsNotOnActiveTab() {
        String todoName = data.generateTodoName();
        actions.userCreatesANewTodo(todoName);
        actions.userCompletesATodo();
        navigation.userSwitchesToActiveTab();
        actions.userChecksIfTodoNotExist();
    }

    @Test
    public void completedTodoIsOnCompletedTab() {
        String todoName = data.generateTodoName();
        actions.userCreatesANewTodo(todoName);
        actions.userCompletesATodo();
        navigation.userSwitchesToCompletedTab();
        actions.userChecksIfTodoIsListed(todoName);
    }

    @After
    public void clean() {
        setup.userClosesAplication();
    }


}
