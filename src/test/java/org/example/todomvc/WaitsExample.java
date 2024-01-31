package org.example.todomvc;

import org.junit.jupiter.api.Test;

public class WaitsExample extends BaseTestSetup {


    @Test
    public void waitForTHE_ONE() {
        steps.userOpensTodoMVCapp();
        steps.userCreatesANewTask("moje zadanie");
        steps.waitForTheOne();
    }
}
