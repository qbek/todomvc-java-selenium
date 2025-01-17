package org.example.todomvc;

import net.serenitybdd.annotations.Steps;
import org.example.todomvc.steps.UserPreconditions;
import org.junit.jupiter.api.Test;

public class CompleteTodoTests extends BaseTestSetup {


//
//
//    Given User has todo completed
//    When user switch to active tab
//    Then User checks if completed todo is not on ‘Active’ tab
//
//
//    Given User complete the todo
//    When user swich to complete tab
//    Then User checks if completed todo is on ‘Completed’ tab



    //    Given User has new todo created
//    When User completes the todo
//    Then User checks if it is marked as completed
//

    @Steps
    UserPreconditions preconditions;

    @Test
    public void userCanCompleteATodo() {
        var name = "Zadanie do skonczenia";
        preconditions.userHasTodoCreated(name);
        userActions.userCompletesTodo();
        userActions.userChecksIfTodoMarkedAsCompleted();
    }

    @Test
    public void userCanFilterActiveTodos() {
        var name = "Zadanie XYZ";

        preconditions.userHasCompletedTodo(name);
        userActions.userChecksIfCompletedTodoIsNotOnActiveTab();
    }

    @Test
    public void  userCanFilterCompletedTodos() {
        var name = "Zadanie 123";
        userActions.userOpensTodoMVCapp();
        userActions.userCreatesANewTodo(name);
        userActions.userCompletesTodo();
        userActions.userChecksIfCompletedTodoIsOnCompletedTab();
    }
}
