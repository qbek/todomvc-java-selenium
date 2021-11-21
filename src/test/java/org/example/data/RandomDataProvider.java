package org.example.data;

import com.github.javafaker.Faker;

public class RandomDataProvider implements DataProviderInterface {

    private Faker dataGenerator = new Faker();

    @Override
    public String getTodoName() {
        return dataGenerator.funnyName().name();
    }

    @Override
    public String getProjectName() {
        return dataGenerator.hipster().word();
    }
}
