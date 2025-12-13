package web.config;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class PlaywrightFactory {

    private static Playwright playwright;
    private static Browser browser;

    private PlaywrightFactory() {
    }

    public static Browser getBrowser() {
        if (browser == null) {
            playwright = Playwright.create();
            browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions()
                            .setChannel("chrome")   // ✅ USA CHROME DEL SISTEMA
                            .setHeadless(false)     // true en CI
            );
        }
        return browser;
    }

    public static void closePlaywright() {
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}


