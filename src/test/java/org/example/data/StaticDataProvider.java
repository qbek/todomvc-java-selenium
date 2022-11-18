package org.example.data;

import java.util.ArrayList;
import java.util.List;

public class StaticDataProvider {

    public String provideTaskName() {
        return "Zadanie ze statyczną nazwą";
    }

    public List<String> provideFewTasksName() {
        List<String> names = new ArrayList<>();
        names.add("Pierwsze zadanie");
        names.add("Drugie zadanie");
        return names;
    }
}
