package web.config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class BasePage {
    protected BrowserContext context;
    protected Page page;

    public BasePage() {
        // cada PageObject obtiene su propio contexto para aislamiento entre tests
        Browser browser = PlaywrightFactory.getBrowser();
        this.context = browser.newContext();
        this.page = context.newPage();
    }

    /**
     * Cierra el contexto local (llamar desde el test o desde un afterEach)
     */
    public void closeContext() {
        if (context != null) {
            context.close();
        }
    }
}
