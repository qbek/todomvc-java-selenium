package org.example;

import org.junit.jupiter.api.Test;

public class AlternativeWait extends BaseSetup {

    @Test
    public void userWaitsForTheOne() {
        given.userIsOnTodoMVCapp();
        when.userWaitsForTodo("special");
        when.userDeletesTodo("special");
    }

}
