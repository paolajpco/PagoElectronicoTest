package web.pages;

import web.config.BasePage;

public class CheckoutPage extends BasePage {

    private final String firstName = "#first-name";
    private final String lastName = "#last-name";
    private final String postalCode = "#postal-code";
    private final String continueButton = "#continue";
    private final String finishButton = "#finish";
    private final String successMessage = ".complete-header";

    public CheckoutPage fillInformation(String name, String lastNameValue, String zip) {
        page.fill(firstName, name);
        page.fill(lastName, lastNameValue);
        page.fill(postalCode, zip);
        page.click(continueButton);
        return this;
    }

    public CheckoutPage finishPurchase() {
        page.click(finishButton);
        return this;
    }

    public boolean isPurchaseCompleted() {
        return page.isVisible(successMessage);
    }
}
