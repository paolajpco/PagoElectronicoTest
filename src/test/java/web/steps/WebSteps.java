package web.steps;

import web.pages.*;

public class WebSteps {

    public LoginPage loginAs(String user, String password) {
        return new LoginPage()
                .open()
                .login(user, password);
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
