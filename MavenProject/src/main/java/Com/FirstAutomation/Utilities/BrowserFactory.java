package Com.FirstAutomation.Utilities;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

	public static WebDriver StartApplication(WebDriver driver, String url, String browser) {

		if (browser.equalsIgnoreCase("Chorome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//Drivers/chromedriver.exe");

			String downloadpathzip = System.getProperty("user.dir") + "\\Zipfolder";

			File file = new File(downloadpathzip);
			if (file.list().length > 0) {
				for (File fileval : file.listFiles()) {
					fileval.delete();
				}
			}

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("profile.default_content_settings.popups", 0);
			map.put("download.default_directory", downloadpathzip);

			ChromeOptions ChromeOptionsref = new ChromeOptions();
			ChromeOptionsref.setExperimentalOption("prefs", map);

			/*
			 * DesiredCapabilities cap = DesiredCapabilities.chrome();
			 * cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			 * cap.setCapability(ChromeOptions.CAPABILITY, ChromeOptionsref);
			 */

			driver = new ChromeDriver(ChromeOptionsref);
			// driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("FireFox")) {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//Drivers/geckodriver.exe");

			String downloadpathzip = System.getProperty("user.dir") + "\\Zipfolder";

			File file = new File(downloadpathzip);
			if (file.list().length > 0) {
				for (File fileval : file.listFiles()) {
					fileval.delete();
				}
			}

			FirefoxOptions options = new FirefoxOptions();

			/*
			 * options.addPreference("browser.download.folderList", 2);
			 * options.addPreference("browser.download.dir", "downloadpathzip");
			 * options.addPreference("browser.download.useDownloadDir", true);
			 * options.addPreference("browser.helperApps.alwaysAsk.force", false);
			 * options.addPreference("browser.helperApps.neverAsk.saveToDisk",
			 * "application/zip");
			 * options.addPreference("browser.download.manager.ShowWhenStarting", false);
			 * options.addPreference("pdfjs.disabled", true);
			 */

			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("browser.download.folderList", 2);
			profile.setPreference("browser.download.dir", "downloadpathzip");
			profile.setPreference("browser.download.useDownloadDir", true);
			profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/zip");

			options.setProfile(profile);

			driver = new FirefoxDriver(options);

		}

		else {

			System.out.println("Browser not supported");
		}

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(ReadConfigUtility.globalwaitMin, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(ReadConfigUtility.globalwaitMin, TimeUnit.SECONDS);
		return driver;

	}

}
