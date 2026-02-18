package org.example.testdata;

import com.github.javafaker.Faker;

import java.util.List;

public class RandomDataGenerator implements DataGenerator{
    @Override
    public String generateTodoName() {
        return Faker.instance().yoda().quote();
    }

    @Override
    public List<String> generateFewTodoNames() {
        return Faker.instance().lorem().sentences(5);
    }

    @Override
    public String getType() {
        return "random";
    }
}
