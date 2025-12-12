package web.pages;

import com.microsoft.playwright.Page;
import web.config.BasePage;

public class LoginPage extends BasePage {

    // Selectores de la página "the-internet"
    private final String usernameInput = "#username";
    private final String passwordInput = "#password";
    private final String loginButton = "button[type='submit']";
    private final String flashMessage = "#flash";

    public LoginPage() {
        super();
    }

    public void navigateToLogin() {
        page.navigate("https://the-internet.herokuapp.com/login");
    }

    public void login(String username, String password) {
        page.fill(usernameInput, username);
        page.fill(passwordInput, password);
        page.click(loginButton);
    }

    public String getFlashText() {
        // El texto incluye un '×' al principio; se puede limpiar si se necesita
        return page.textContent(flashMessage).trim();
    }

    public boolean isAtSecureArea() {
        return page.url().contains("/secure");
    }
}
