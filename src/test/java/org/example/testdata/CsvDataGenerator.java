package org.example.testdata;

import java.util.List;

public class CsvDataGenerator implements DataGenerator {
    @Override
    public String generateTodoName() {
        return "jestm z CSV";
    }

    @Override
    public List<String> generateFewTodoNames() {
        return List.of();
    }

    @Override
    public String getType() {
        return "csv";
    }
}
