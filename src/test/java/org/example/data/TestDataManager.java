package org.example.data;

import java.util.List;

public class TestDataManager {

    private String dataType = System.getProperty("td");
    private RandomDataProvider randomData = new RandomDataProvider();
    private StaticDataProvider staticData = new StaticDataProvider();

    public String generateTaskName() {
        if (dataType.equals("random")) {
            return randomData.provideTaskName();
        } else if (dataType.equals("static")) {
            return staticData.provideTaskName();
        }
        throw new RuntimeException("Invalid td parameter in execution command");
    }

    public List<String> generateFewTasksName() {
        if (dataType.equals("random")) {
            return randomData.provideFewTasksName();
        } else if (dataType.equals("static")) {
            return staticData.provideFewTasksName();
        }
        throw new RuntimeException("Invalid td parameter in execution command");
    }
}
