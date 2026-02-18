package org.example.testdata;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class TestDataManager {

    private List<DataGenerator> generators;

    public TestDataManager() {
        generators = new ArrayList<>();
        generators.add(new RandomDataGenerator());
        generators.add(new StaticDataGenerator());
        generators.add(new CsvDataGenerator());
    }

    public String generateTodoName() {
        return getGenerator().generateTodoName();
    }

    public List<String> generateFewTodoNames() {
        return getGenerator().generateFewTodoNames();
    }

    private DataGenerator getGenerator () {
        var dataType = System.getProperty("data");
        for (var g : generators) {
            if (g.getType().equals(dataType)) {
                return g;
            }
        }
        throw new RuntimeException("missing data generator");
    }
}
