package web.config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

    private static Playwright playwright;
    private static Browser browser;

    /**
     * Crea/retorna un browser reutilizable.
     * Modo headless por defecto. Cambia la opción si necesitas ver la UI.
     */
    public static Browser getBrowser() {
        if (playwright == null) {
            playwright = Playwright.create();
        }
        if (browser == null) {
            // Headless true para CI; cambiar a false para ver el navegador
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        }
        return browser;
    }

    public static void closeAll() {
        if (browser != null) {
            browser.close();
            browser = null;
        }
        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
    }
}
