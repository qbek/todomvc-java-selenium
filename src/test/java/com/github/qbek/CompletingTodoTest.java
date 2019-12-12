package com.github.qbek;

import com.github.qbek.steps.SetupAndTeardownSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class CompletingTodoTest {

    SetupAndTeardownSteps setup = new SetupAndTeardownSteps();

    @Before
    public void setup() {
        setup.userOpensTodoMvcApp();
    }

    @Test
    public void userCanCompleteATodo(){
//        String todoName = "Todo to be completed";
//        userCreatesANewTodo(todoName);
//        userCompletesATodo();
//        userChecksIfTodoIsCompleted();
//        userSwitchesToActiveTab();
//        userChecksIfTodoNotExist();
//        userSwitchesToCompletedTab();
//        userChecksIfTodoIsListed(todoName);
    }


}
