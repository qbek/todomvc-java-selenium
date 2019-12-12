package com.github.qbek.steps;

import com.github.qbek.pageobjects.NavigationBar;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;

public class NavigationSteps {

    NavigationBar navBar = new NavigationBar();

    @Step
    public void userSwitchesToCompletedTab() {
        navBar.goToCompletedTodos();
    }

    @Step
    public void userSwitchesToActiveTab() {
        navBar.goToActiveTodos();
    }
}
