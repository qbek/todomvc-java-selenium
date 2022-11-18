package org.example;

import org.junit.jupiter.api.Test;

public class AwaitilityExample extends BaseSetup {

    @Test
    public void userWaitsForTheOne() {
        when.userWaitForTheOne();
        then.userChecksIfTodoIsOnTheList("THE ONE");
    }
}
