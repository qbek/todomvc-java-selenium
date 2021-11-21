package org.example.data;

public class StaticDataProvider implements DataProviderInterface {

    @Override
    public String getTodoName() {
        return "To jest todo statyczne";
    }

    @Override
    public String getProjectName() {
        return "To jest statyczny projekt";
    }
}
