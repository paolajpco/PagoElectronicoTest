package web.steps;

import web.pages.CartPage;
import web.pages.CheckoutPage;
import web.pages.InventoryPage;
import web.pages.LoginPage;

public class WebSteps {

    private InventoryPage inventory;
    private CartPage cart;
    private CheckoutPage checkout;

    public InventoryPage loginAs(String user, String password) {
        LoginPage login = new LoginPage();
        inventory = login.login(user, password);
        return inventory;
    }

    public void addTwoProductsToCart() {
        cart = inventory
                .addTwoProducts()
                .goToCart();
    }

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

