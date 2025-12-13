package web.steps;

import web.pages.CartPage;
import web.pages.CheckoutPage;
import web.pages.InventoryPage;
import web.pages.LoginPage;

public class WebSteps {

    private InventoryPage inventory;
    private CartPage cart;
    private CheckoutPage checkout;

    // ✅ Login exitoso
    public InventoryPage loginAs(String user, String password) {
        LoginPage login = new LoginPage();
        inventory = login
                .open()
                .loginSuccessfully(user, password);
        return inventory;
    }

    // ❌ Login fallido (usuario bloqueado)
    public LoginPage loginAsLockedUser(String user, String password) {
        LoginPage login = new LoginPage();
        return login
                .open()
                .loginExpectingError(user, password);
    }

    // 🛒 Agregar productos
    public void addTwoProductsToCart() {
        cart = inventory
                .addTwoProducts()
                .goToCart();
    }

    // 💳 Flujo completo de compra
    public void completePurchaseFlow() {
        checkout = inventory
                .addTwoProducts()
                .goToCart()
                .checkout();

        checkout
                .fillCheckoutInformation("Paola", "Ortiz", "050001")
                .finishPurchase();
    }
}


