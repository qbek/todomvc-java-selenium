package org.example;

import org.junit.Test;


public class CreateTodoTest extends Base {

    @Test
    public void user_can_create_a_new_todo() {
        String todoName = data.getTodoName();
        steps.userOpensTodoMvcApplication();
        steps.userCreatesANewTodo(todoName);
        steps.userChecksIfTodoWasCreated(todoName);
    }


    @Test
    public void wait_for_todo_STOP() {
        steps.userOpensTodoMvcApplication();
        steps.waitForStopTodo();
    }
}
