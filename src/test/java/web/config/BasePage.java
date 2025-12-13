package web.config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
     * 🔹 Exponer Page para validaciones desde tests o steps
     */
    public Page getPage() {
        return page;
    }

    /**
     * Captura screenshot con timestamp
     *
     * @param name nombre lógico del pantallazo
     */
    public void takeScreenshot(String name) {
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

        page.screenshot(new Page.ScreenshotOptions()
                .setFullPage(true)
                .setPath(Paths.get(
                        "src/test/resources/evidences/screenshots/"
                                + name + "_" + timestamp + ".png"
                )));
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
