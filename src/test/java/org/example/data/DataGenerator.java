package org.example.data;


public class DataGenerator {

    private RandomDataProvider randomData = new RandomDataProvider();
    private StaticDataProvider staticData = new StaticDataProvider();
    private DatabaseDataProvider databaseData = new DatabaseDataProvider();

    private String data = System.getProperty("data");

    private DataProviderInterface getDataProvider() {
        if (data.equals("random")) {
            return randomData;
        } else if (data.equals("static")) {
           return staticData;
        } else if (data.equals("db")) {
            return databaseData;
        } else {
            throw new RuntimeException("Nie ma takiego zestawu danych!!!");
        }
    }

    public String getTodoName() {
        return getDataProvider().getTodoName();
    }

    public String getProjectName() {
        return getDataProvider().getProjectName();
    }
}
