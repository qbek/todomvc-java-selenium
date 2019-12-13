package com.github.qbek.aux;

import com.github.javafaker.Faker;
import net.thucydides.core.annotations.Step;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DataGenerator {

    @Step
    public String generateTodoName () {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().fullName();
    }

    public List<String> generateFewTodos() {
        Faker faker = new Faker();
        int numberOfTodos = faker.number().numberBetween(3, 6);
        List<String> todosToCreate = new ArrayList<>();
        for (int i=0; i<numberOfTodos; i++) {
            todosToCreate.add(faker.book().title());
        }
        return todosToCreate;
    }
}
