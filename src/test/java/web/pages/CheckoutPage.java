package web.pages;

import web.config.BasePage;

public class CartPage extends BasePage {

    private final String checkoutButton = "#checkout";

    public CheckoutPage checkout() {
        page.click(checkoutButton);
        return new CheckoutPage();
    }
}
