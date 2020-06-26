package Com.FirstAutomation.Pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Com.FirstAutomation.Baselayer.BaseClass;
import Com.FirstAutomation.Utilities.BrowserFactory;

public class HomebasedMethods extends BaseClass {

	public ArrayList<Map<String, Object>> totalmaprecords = new ArrayList<Map<String, Object>>();

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

	// creating arrylist of all records

	public void getallrecordsasarraylist(WebElement exceltable) {

		WebElement firstrow = exceltable.findElement(By.xpath("./tbody//tr[1]"));

		List<WebElement> allrows = exceltable.findElements(By.xpath("./tbody//tr"));

		for (int i = 2; i < allrows.size(); i++)

		{
			Map<String, Object> maprow = new HashMap<String, Object>();

			WebElement onerow = exceltable.findElement(By.xpath("./tbody//tr[" + i + "]"));
			List<WebElement> allcols = onerow.findElements(By.xpath("./td"));
			int colsize = allcols.size();

			for (int j = 1; j <=allcols.size(); j++) {

				WebElement celval = onerow.findElement(By.xpath("./td[" + j + "]/p"));

				String mainval = firstrow.findElement(By.xpath("./td[" + j + "]/p/b")).getText();
				String subval = celval.getText();

				maprow.put(firstrow.findElement(By.xpath("./td[" + j + "]/p/b")).getText(), celval.getText());

			}

			totalmaprecords.add(maprow);

		}

	}

}
