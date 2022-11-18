package org.example.data;

import java.util.List;

public class TestDataManager {

    private String dataType = System.getProperty("td");
    private IDataProvider randomData = new RandomDataProvider();
    private IDataProvider staticData = new StaticDataProvider();

    public String generateTaskName() {
        return selectDataProvider().provideTaskName();
    }

    public List<String> generateFewTasksName() {
        return selectDataProvider().provideFewTasksName();
    }

    private IDataProvider selectDataProvider() {
        if (dataType.equals("random")) {
            return randomData;
        } else if (dataType.equals("static")) {
            return staticData;
        }
        throw new RuntimeException("Invalid td parameter in execution command");
    }
}
