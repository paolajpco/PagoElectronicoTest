package web.tests;

import org.junit.jupiter.api.*;
import web.pages.LoginPage;
import web.steps.WebSteps;

import static org.junit.jupiter.api.Assertions.*;

public class SauceDemoTest {

    WebSteps steps;

    @BeforeEach
    void setUp() {
        steps = new WebSteps();
    }

    @Test
    void loginExitoso() {
        LoginPage login = steps.loginAs("standard_user", "secret_sauce");
        assertTrue(login.getPage().url().contains("inventory"));
        login.closeContext();
    }

    @Test
    void loginFallidoUsuarioBloqueado() {
        LoginPage login = steps.loginAs("locked_out_user", "secret_sauce");
        assertTrue(login.isErrorVisible());
        login.closeContext();
    }

    @Test
    void agregarDosProductosAlCarrito() {
        LoginPage login = steps.loginAs("standard_user", "secret_sauce");
        steps.completePurchaseFlow();
        login.closeContext();
    }

    @Test
    void completarFlujoDeCompra() {
        LoginPage login = steps.loginAs("standard_user", "secret_sauce");
        steps.completePurchaseFlow();
        login.closeContext();
    }
}
