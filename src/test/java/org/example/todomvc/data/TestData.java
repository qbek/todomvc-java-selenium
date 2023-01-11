package org.example.todomvc.data;

import com.github.javafaker.Faker;

public class TestData {

    public static String getTodoName() {
        Faker generator = new Faker();
        return generator.chuckNorris().fact();


    }
}
