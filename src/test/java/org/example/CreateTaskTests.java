package org.example;

import com.github.javafaker.Faker;
import org.example.steps.UserSteps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateTaskTests extends BaseSetup {

    @Test
    public void userCanAddTodo() {
        step.userAddsANewTodo();
        step.userChecksIfTodoIsCreated();
    }

}
