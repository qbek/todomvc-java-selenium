package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
}
