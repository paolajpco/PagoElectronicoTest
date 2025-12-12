package web.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import web.config.PlaywrightFactory;
import web.steps.WebSteps;

public class WebSampleTest {

    private final WebSteps steps = new WebSteps();

    @Test
    public void testSuccessfulLogin() {
        boolean logged = steps.loginAsValidUser();
        Assertions.assertTrue(logged, "El usuario debe llegar al área segura después del login");
    }

    @Test
    public void testInvalidLoginShowsError() {
        String msg = steps.loginWithInvalidCredentials("wrong", "wrong");
        Assertions.assertTrue(msg.toLowerCase().contains("invalid"), "Debe mostrar mensaje de credenciales inválidas");
    }

    @AfterAll
    public static void tearDownAll() {
        // Cerrar Playwright/browser global al final de todos los tests
        PlaywrightFactory.closeAll();
    }
}
