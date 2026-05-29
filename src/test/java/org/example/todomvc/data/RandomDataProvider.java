package org.example.todomvc.data;

import com.github.javafaker.Faker;

import java.util.List;

public class RandomDataProvider {
    private static Faker faker = new Faker();

    public String getTodoName() {
        return faker.commerce().productName();
    }

    public List<String> getFewTodos() {
        return faker.lorem().sentences(4);
    }

}
