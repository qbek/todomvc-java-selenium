package org.example.data;

import java.util.ArrayList;
import java.util.List;

public class StaticDataProvider implements IDataProvider {

    @Override
    public String provideTaskName() {
        return "Zadanie ze statyczną nazwą";
    }

    @Override
    public List<String> provideFewTasksName() {
        List<String> names = new ArrayList<>();
        names.add("Pierwsze zadanie");
        names.add("Drugie zadanie");
        return names;
    }

    @Override
    public boolean isDataProviderType(String type) {
        return type.equals("static");
    }
}
