package org.example;

import net.thucydides.core.ThucydidesSystemProperty;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class HelloWorld {

    @Test
    public void browserPuppeteer() {
        var browser = new FirefoxDriver();
        browser.get("http://google.pl");
        browser.close();
    }

    @Test
    public void softAssertions() {
        assertSoftly( soft -> {
            soft.assertThat("aaa").isEqualTo("aaa1");
            soft.assertThat("bbb").isEqualTo("bbb");
            soft.assertThat("ccc").isEqualTo("ccc");
            soft.assertThat("ddd").isEqualTo("1");
        });

    }

    @Test
    public void listOfListAssertions() {
        var a = new ArrayList<ArrayList<String>>();
        a.add(new ArrayList<>(Arrays.asList("abonament", "telefon")));
        a.add(new ArrayList<>(Arrays.asList("abonament")));
        a.add(new ArrayList<>(Arrays.asList("telefon")));

        var b = new ArrayList<ArrayList<String>>();
        b.add(new ArrayList<>(Arrays.asList("abonament", "telefon")));
        b.add(new ArrayList<>(Arrays.asList("telefon")));
//        b.add(new ArrayList<>(Arrays.asList("abonament")));


        MatcherAssert.assertThat("list sa takie same", a, Matchers.containsInAnyOrder(b.toArray()));
    }
}
