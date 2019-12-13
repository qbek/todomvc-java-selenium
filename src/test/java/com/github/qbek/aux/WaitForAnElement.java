package com.github.qbek.aux;

import com.github.qbek.pageobjects.TodoItem;

import java.util.concurrent.Callable;

public class WaitForAnElement implements Callable<Boolean> {
    IsElementDisplayed todo;

    public WaitForAnElement(IsElementDisplayed todo) {
        this.todo = todo;
    }

    @Override
    public Boolean call() throws Exception {
        System.out.println("I'm still waiting!!!");
        return todo.isDisplayed();
    }
}
