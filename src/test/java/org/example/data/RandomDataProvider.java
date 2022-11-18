package org.example.data;

import com.github.javafaker.Faker;

import java.util.List;

public class RandomDataProvider implements IDataProvider {

    private Faker generator = new Faker();

    @Override
    public String provideTaskName() {
        return generator.funnyName().name();
    }

    @Override
    public List<String> provideFewTasksName() {
        return generator.lorem().sentences(
                generator.number().numberBetween(0, 4)
        );
    }
}
