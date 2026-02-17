package org.example.todomvc;


import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateTodoTests {

    private By newTodoInputSelector =  By.cssSelector("#new-todo");
    private By todoListSelector = By.cssSelector("#todo-list");
    private By todoItemSelector = By.cssSelector("#todo-list li");
    private By todoCompleteChkboxSelector = By.cssSelector(".toggle");

    private By activeTabSelector = By.cssSelector("[href=\"#/active\"]");
    private By completedTabSelector = By.cssSelector("[href=\"#/completed\"]");

    private By xpathCost = By.xpath("asdfasdf");

    private String TodoMVC_URL = "https://todomvc.com/examples/jquery/dist/#/all";


    @Test
    public void userCanCreateANewTodo() {
        var todoName = "Moje zadanie żółć";

        var browser = new FirefoxDriver();
        browser.get(TodoMVC_URL);

        var newTodoInput = browser.findElement(newTodoInputSelector);
        newTodoInput.sendKeys(todoName);
        newTodoInput.sendKeys(Keys.RETURN);

        var todoList = browser.findElement(todoListSelector);

        MatcherAssert.assertThat("Todo exists on the list",
                todoList.isDisplayed(),
                Matchers.equalTo(true));

        MatcherAssert.assertThat("Todo has correct name",
                todoList.getText(),
                Matchers.equalTo(todoName));

        browser.close();
    }

    @Test
    public void userCanCompleteTheTodo() {
        var todoName = "Zadanie do zakończenia";
        var browser = new FirefoxDriver();
        browser.get(TodoMVC_URL);

        var newTodoInput = browser.findElement(newTodoInputSelector);
        newTodoInput.sendKeys(todoName);
        newTodoInput.sendKeys(Keys.RETURN);

        var todoCompleteBtn = browser.findElement(todoCompleteChkboxSelector);
        todoCompleteBtn.click();

        var todoItem = browser.findElement(todoItemSelector);
        MatcherAssert.assertThat("Todo is marked as completed",
                todoItem.getAttribute("class"),
                Matchers.containsString("completed"));

        var activeTab = browser.findElement(activeTabSelector);
        activeTab.click();

//        sprawdzanie czy lista jest pusta przy założeniu że lista jest na stronie
//        var todoList = browser.findElement(todoListSelector); // nie dopuszcza braku elementu -> rzuca wyjatek
//        MatcherAssert.assertThat("Todo has correct name",
//                todoList.getText(),
//                Matchers.emptyOrNullString());


//        sprawdzenie czy NIE MA takiego elementu
        var todoItems = browser.findElements(todoItemSelector); //dopuszcza brak elementu -> zwraca pusta liste
        MatcherAssert.assertThat("Empty todo list",
                todoItems,
                Matchers.empty());

        var todoList = browser.findElement(todoListSelector);
        var completedTab = browser.findElement(completedTabSelector);
        completedTab.click();
        MatcherAssert.assertThat("Todo has correct name",
                todoList.getText(),
                Matchers.equalTo(todoName));
        browser.close();

    }
}
