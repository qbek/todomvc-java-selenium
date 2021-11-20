package org.example;

import org.junit.Test;


public class CreateTodoTest extends Base {

    @Test
    public void user_can_create_a_new_todo() throws InterruptedException {
        String todoName = "Nauczyć się automatyzacji testów";
        steps.userOpensTodoMvcApplication();
        steps.userCreatesANewTodo(todoName);
        steps.userChecksIfTodoWasCreated(todoName);
    }

}
