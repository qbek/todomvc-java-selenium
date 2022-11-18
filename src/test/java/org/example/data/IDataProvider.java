package org.example.data;

import java.util.List;

public interface IDataProvider {

    String provideTaskName();

    List<String> provideFewTasksName();

    boolean isDataProviderType(String type);
}
