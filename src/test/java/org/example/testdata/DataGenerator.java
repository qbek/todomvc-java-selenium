package org.example.testdata;

import java.util.List;

public interface DataGenerator {

    String generateTodoName();
    List<String> generateFewTodoNames();
    String getType();
}
