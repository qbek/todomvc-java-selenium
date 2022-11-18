package org.example.data;

import com.github.javafaker.Faker;

import java.util.List;

public class RandomDataProvider {

    private Faker generator = new Faker();

    public String provideTaskName() {
        return generator.funnyName().name();
    }

    public List<String> provideFewTasksName() {
        return generator.lorem().sentences(
                generator.number().numberBetween(0, 4)
        );
    }
}
