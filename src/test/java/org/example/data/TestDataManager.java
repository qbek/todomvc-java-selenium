package org.example.data;

import com.github.javafaker.Faker;
import net.serenitybdd.core.Serenity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.data.TestDataTypes.TODOS_NAMES;

public class TestDataManager {

    static Faker faker = new Faker();

    public static void setupTodosNamesTestData() {
        var todosNames = faker.lorem().sentences(faker.number().numberBetween(2, 4));;
        Serenity.setSessionVariable(TODOS_NAMES).to(todosNames);
    }
}
