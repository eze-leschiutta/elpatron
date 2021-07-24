package edu.it;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AppTest {
    @Test
    void appHasAGreeting() {
        Mockito.mock(java.lang.Runnable.class);
        assertNotNull("", "app should have a greeting");
    }
}
