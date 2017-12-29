package utilities;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Algemeen {
    public void setup(String browser) throws Exception {

        PropertiesLoader prop = new PropertiesLoader();
        switch (browser){
            case "firefox":
                System.setProperty("webdriver.marionette.driver", System.getProperty("user.dir") + prop.get("driver_firefox"));
                Configuration.timeout = 5000;
                Configuration.browser = "marionette";
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + prop.get("driver_chrome"));
                Configuration.timeout = 5000;
                Configuration.browser = "chrome";
                break;
            case "ie":
                System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + prop.get("driver_ie"));
                Configuration.timeout = 5000;
                Configuration.browser = "ie";
                DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
                ieCapabilities.setCapability("nativeEvents", false);
                break;
            default:
                System.out.println("Geen driver gevonden");
        }
    }
}
