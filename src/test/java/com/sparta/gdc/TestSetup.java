package com.sparta.gdc;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

public class TestSetup {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext browserContext;

    Page page;

    @BeforeAll
    public static void setUpBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setArgs(Arrays.asList("--no-sandbox","--disable-extensions","--disable-gpu"))
        );
    }

    @BeforeEach
    public void setUp() {
        browserContext = browser.newContext();
        page = browserContext.newPage();
    }

    @AfterAll
    public static void tearDown() {
        browser.close();
        playwright.close();
    }
}
