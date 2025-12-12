package web.steps;

import web.pages.LoginPage;

public class WebSteps {

    private final LoginPage loginPage = new LoginPage();

    /**
     * Realiza login con las credenciales públicas del sitio de pruebas.
     * Devuelve true si se llega al área segura.
     */
    public boolean loginAsValidUser() {
        try {
            loginPage.navigateToLogin();
            loginPage.login("tomsmith", "SuperSecretPassword!");
            // Espera implícita/pequeña si necesitas, pero Playwright espera por defecto
            boolean ok = loginPage.isAtSecureArea();
            return ok;
        } finally {
            // siempre cerramos contexto local
            loginPage.closeContext();
        }
    }

    /**
     * Intenta un login fallido y devuelve el mensaje mostrado.
     */
    public String loginWithInvalidCredentials(String user, String pass) {
        try {
            loginPage.navigateToLogin();
            loginPage.login(user, pass);
            return loginPage.getFlashText();
        } finally {
            loginPage.closeContext();
        }
    }
}
