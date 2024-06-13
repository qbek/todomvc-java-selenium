package org.example.todomvc.data;

import com.github.javafaker.Faker;

public class TestData {

    public String getTaskName() {
        var tdType = System.getProperty("td", "");
        if (tdType.equals("random")) {
            return Faker.instance().chuckNorris().fact();
        } else {
            return "Jestem statyczny";
        }
    }
}
