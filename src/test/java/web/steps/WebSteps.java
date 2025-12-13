package web.steps;

import web.pages.InventoryPage;
import web.pages.LoginPage;

public class WebSteps {

    public LoginPage loginAs(String user, String password) {
        return new LoginPage()
                .open()
                .login(user, password);
    }

    // ✅ NUEVO MÉTODO
    public void addTwoProductsToCart() {
        inventory.addProductToCart("Sauce Labs Backpack");
        inventory.addProductToCart("Sauce Labs Bike Light");
        inventory.goToCart();
    }

    public void completePurchaseFlow() {
        InventoryPage inventory = new InventoryPage();
        inventory.addTwoProducts()
                .goToCart()
                .checkout()
                .fillInformation("Paola", "Ortiz", "110111")
                .finishPurchase();
    }
}
