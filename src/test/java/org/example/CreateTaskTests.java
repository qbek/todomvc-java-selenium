package org.example;

import com.github.javafaker.Faker;
import org.example.steps.UserSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateTaskTests extends BaseSetup {

    @Test
    public void userCanAddTodo() {
        var todoName = dataGenerator.dragonBall().character();
        step.userAddsANewTodo(todoName);
        step.userChecksIfTodoIsCreated(todoName);
    }

    @Test
    public void userDeletesTodo() {
        step.userAddsANewTodo("aaaa");

    }


}
