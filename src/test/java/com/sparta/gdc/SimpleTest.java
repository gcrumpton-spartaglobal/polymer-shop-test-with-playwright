package com.sparta.gdc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleTest extends TestSetup {
    @Test
    void shouldShowThePageTitle() {
        page.navigate("https://shop.polymer-project.org/");
        String title = page.title();
        Assertions.assertTrue(title.contains("Home - SHOP"));
    }
}
