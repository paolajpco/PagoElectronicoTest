package web.tests;

import org.junit.jupiter.api.*;
import web.pages.InventoryPage;
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
        InventoryPage inventory =
                steps.loginAs("standard_user", "secret_sauce");

        assertTrue(inventory.getPage().url().contains("inventory"));
        inventory.closeContext();
    }

    @Test
    @Order(2)
    void loginFallidoUsuarioBloqueado() {
        LoginPage login =
                steps.loginAsLockedUser("locked_out_user", "secret_sauce");

        assertTrue(login.isErrorVisible());
        login.closeContext();
    }

    @Test
    @Order(3)
    void agregarDosProductosAlCarrito() {
        InventoryPage inventory =
                steps.loginAs("standard_user", "secret_sauce");

        steps.addTwoProductsToCart();
        inventory.closeContext();
    }

    @Test
    @Order(4)
    void completarFlujoDeCompra() {
        InventoryPage inventory =
                steps.loginAs("standard_user", "secret_sauce");

        steps.completePurchaseFlow();
        inventory.closeContext();
    }
}



