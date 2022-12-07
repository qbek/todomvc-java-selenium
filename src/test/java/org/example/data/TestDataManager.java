package org.example.data;

import net.serenitybdd.core.Serenity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.data.TestDataTypes.TODOS_NAMES;

public class TestDataManager {

    public static void setupTodosNamesTestData() {
        var todosNames = new ArrayList<String>(Arrays.asList("Zadanie 1", "Zadanie 2", "Zadanie 3"));
        Serenity.setSessionVariable(TODOS_NAMES).to(todosNames);
    }
}
