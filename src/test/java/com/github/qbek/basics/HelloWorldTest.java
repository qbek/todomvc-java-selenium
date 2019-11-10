package com.github.qbek.basics;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class HelloWorldTest {

    @Test
    public void helloWorld() {
        System.out.println("I'm Jakub");
        System.out.println("Hello World!!!");
    }
}
