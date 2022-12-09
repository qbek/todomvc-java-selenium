package org.example;

import net.thucydides.core.ThucydidesSystemProperty;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockserver.client.MockServerClient;
import org.mockserver.matchers.Times;
import org.mockserver.model.HttpResponse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

public class HelloWorld extends BaseSetup {

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

    @Test
    public void setupMock() {
        MockServerClient client = new MockServerClient("localhost", 8080);
        client.reset();
        client.when(
                request().withPath("/test"),
                Times.exactly(3)
        ).respond(
                response().withBody("Tadaaaam!!!!")
        );
    }

    @Test
    public void sniffUmKielce() throws InterruptedException {
        MockServerClient client = new MockServerClient("localhost", 8080);
        client.reset();

        browser.get("http://www.um.kielce.pl/");
        var rr = client.retrieveRecordedRequestsAndResponses(
                request()
        );
        var exp = client.retrieveRecordedExpectations(request());
        Arrays.stream(exp).forEach(
                e -> {
                    client.when(e.getHttpRequest()).respond(e.getHttpResponse());
                }
        );
        browser.get("http://localhost:8080/");
        Thread.sleep(5000);
    }
}
