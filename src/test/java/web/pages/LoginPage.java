package web.pages;

import com.microsoft.playwright.Page;
import web.config.BasePage;

public class LoginPage extends BasePage {

    private final String usernameInput = "#user-name";
    private final String passwordInput = "#password";
    private final String loginButton = "#login-button";
    private final String errorMessage = "[data-test='error']";

    public LoginPage open() {
        page.navigate("https://www.saucedemo.com/");
        return this;
    }

    // ❌ Login fallido (permanece en LoginPage)
    public LoginPage loginExpectingError(String username, String password) {
        page.fill(usernameInput, username);
        page.fill(passwordInput, password);
        page.click(loginButton);
        return this;
    }

    // ✅ Login exitoso (navega a InventoryPage)
    public InventoryPage loginSuccessfully(String username, String password) {
        page.fill(usernameInput, username);
        page.fill(passwordInput, password);
        page.click(loginButton);
        return new InventoryPage();
    }

    public boolean isErrorVisible() {
        return page.isVisible(errorMessage);
    }

    public String getErrorMessage() {
        return page.textContent(errorMessage);
    }

    public Page getPage() {
        return page;
    }
}


