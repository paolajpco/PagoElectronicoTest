package web.tests;

import org.junit.jupiter.api.*;
import web.pages.LoginPage;
import web.steps.WebSteps;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SauceDemoTest {

    WebSteps steps;

    @BeforeEach
    void setUp() {
        steps = new WebSteps();
    }

    @Test
    @Order(1)
    void loginExitoso() {
        LoginPage login = steps.loginAs("standard_user", "secret_sauce");
        assertTrue(login.getPage().url().contains("inventory"));
        login.closeContext();
    }

    @Test
    @Order(2)
    void loginFallidoUsuarioBloqueado() {
        LoginPage login = steps.loginAs("locked_out_user", "secret_sauce");
        assertTrue(login.isErrorVisible());
        login.closeContext();
    }

    @Test
    @Order(3)
    void agregarDosProductosAlCarrito() {
        LoginPage login = steps.loginAs("standard_user", "secret_sauce");
        steps.addTwoProductsToCart(); // 🔹 recomendado separar la acción
        login.closeContext();
    }

    @Test
    @Order(4)
    void completarFlujoDeCompra() {
        LoginPage login = steps.loginAs("standard_user", "secret_sauce");
        steps.completePurchaseFlow();
        login.closeContext();
    }
}


