package org.example.data;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class TestDataManager {

    private Faker generator = new Faker();

    private String dataType = System.getProperty("td");

    public String generateTaskName() {
        if (dataType.equals("random")) {
            return generator.funnyName().name();
        } else if (dataType.equals("static")) {
            return "Zadanie ze statyczną nazwą";
        }
        throw new RuntimeException("Missing td parameter in execution command");
    }

    public List<String> generateFewTasksName() {
        if (dataType.equals("random")) {
            return generator.lorem().sentences(
                    generator.number().numberBetween(0, 4)
            );
        } else if (dataType.equals("static")) {
            List<String> names = new ArrayList<>();
            names.add("Pierwsze zadanie");
            names.add("Drugie zadanie");
            return names;
        }
        throw new RuntimeException("Missing td parameter in execution command");
    }
}
