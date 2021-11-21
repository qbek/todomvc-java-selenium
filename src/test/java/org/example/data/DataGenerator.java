package org.example.data;

import com.github.javafaker.Faker;

public class DataGenerator {

    private Faker dataGenerator = new Faker();

    public String getTodoName() {
       return dataGenerator.funnyName().name();
    }

}
