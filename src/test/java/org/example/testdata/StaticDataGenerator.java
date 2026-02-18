package org.example.testdata;

import java.util.List;

public class StaticDataGenerator implements DataGenerator {
    @Override
    public String generateTodoName() {
        return "Jestem statyczna nazwa";
    }

    @Override
    public List<String> generateFewTodoNames() {
        return List.of("task 1", "zadanie 2", "zadanie 4");
    }

    @Override
    public String getType() {
        return "static";
    }
}
