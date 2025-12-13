package web.steps;

import web.pages.CartPage;
import web.pages.InventoryPage;
import web.pages.LoginPage;

public class WebSteps {

    private InventoryPage inventory;
    private CartPage cart;

    public InventoryPage loginAs(String user, String password) {
        LoginPage login = new LoginPage();
        return login.login(user, password); // devuelve InventoryPage
    }


    // ✅ Usa el método que YA existe
    public void addTwoProductsToCart() {
        inventory
                .addTwoProducts()
                .goToCart();
    }

    public void completePurchaseFlow() {
        cart = inventory
                .addTwoProducts()
                .goToCart();

        cart.checkout();
        cart.fillCheckoutInformation("Paola", "Ortiz", "050001");
        cart.finishPurchase();
    }
}


