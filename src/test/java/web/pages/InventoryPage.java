package web.pages;

import web.config.BasePage;

public class InventoryPage extends BasePage {

    private final String productBackpack = "#add-to-cart-sauce-labs-backpack";
    private final String productBikeLight = "#add-to-cart-sauce-labs-bike-light";
    private final String cartIcon = ".shopping_cart_link";

    public InventoryPage addTwoProducts() {
        page.click(productBackpack);
        page.click(productBikeLight);
        return this;
    }

    public CartPage goToCart() {
        page.click(cartIcon);
        return new CartPage();
    }
}
