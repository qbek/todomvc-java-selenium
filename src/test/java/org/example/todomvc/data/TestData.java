package org.example.todomvc.data;

import com.github.javafaker.Faker;

import java.util.List;

public class TestData {

    public String getTaskName() {
        var tdType = System.getProperty("td", "");
        if (tdType.equals("random")) {
            return Faker.instance().chuckNorris().fact();
        } else {
            return "Jestem statyczny";
        }
    }

    public List<String> getFewTodos() {
        return Faker.instance().lorem().sentences(3);
    }
}
