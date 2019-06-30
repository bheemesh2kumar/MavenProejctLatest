package Com.FirstAutomation.Pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Com.FirstAutomation.Baselayer.BaseClass;
import Com.FirstAutomation.Utilities.BrowserFactory;

public class HomebasedMethods extends BrowserFactory {

	// get all links of page
	public void GetAlllinks(List<WebElement> elements) throws MalformedURLException, IOException {

		ArrayList<WebElement> activelinks = new ArrayList<WebElement>();

		elements.addAll(driver.findElements(By.tagName("img")));

		for (WebElement ele : elements) {
			if ((ele.getAttribute("href") != null) && (!ele.getAttribute("href").contains("javascript"))) {
				activelinks.add(ele);

			}
		}

		System.out.println("Total links are" + activelinks.size());

		for (int j = 0; j < activelinks.size(); j++) {

			HttpsURLConnection connection = (HttpsURLConnection) new URL(activelinks.get(j).getAttribute("href"))
					.openConnection();
			connection.connect();
			int rescode = connection.getResponseCode();

			System.out.println("the response code of " + " " + activelinks.get(j).getAttribute("href") + rescode);
			connection.disconnect();

		}

	}

}
