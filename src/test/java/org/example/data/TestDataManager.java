package org.example.data;

import java.util.ArrayList;
import java.util.List;

public class TestDataManager {

    private String dataType = System.getProperty("td");

    private static List<IDataProvider> dataProviders;

    static {
        dataProviders = new ArrayList<>();
        dataProviders.add(new RandomDataProvider());
        dataProviders.add(new StaticDataProvider());
    }


    public String generateTaskName() {
        return selectDataProvider().provideTaskName();
    }

    public List<String> generateFewTasksName() {
        return selectDataProvider().provideFewTasksName();
    }

    private IDataProvider selectDataProvider() {
        try {
            return dataProviders.stream().filter(dp -> dp.isDataProviderType(dataType)).findFirst().get();
        } catch (Exception e) {
            throw new RuntimeException("Requested provider doesn't exist");
        }
    }
}
