package Com.FirstAutomation.TestScripts;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Jsonreader {

	@Test(dataProvider = "jsondata")
	public void getjsondata(String data) {

		String[] jsoneles = data.split(",");

		System.out.println("first set of data ");
		System.out.println(jsoneles[0]);
        System.out.println(jsoneles[1]);
        
        System.out.println("********************************");

	}

	@DataProvider(name = "jsondata")
	public String[] jsondata() throws IOException, ParseException {

		JSONParser JSONParserref = new JSONParser();
		FileReader FileReaderref = new FileReader("./jsonfiles/employeeinfo.json");

		Object obj = JSONParserref.parse(FileReaderref);

		JSONObject jsonobj = (JSONObject) obj;

		JSONArray jsonarry = (JSONArray) jsonobj.get("employees");

		int jsonarrysize = jsonarry.size();

		String stringarry[] = new String[jsonarrysize];

		for (int i = 0; i < jsonarrysize; i++) {
			JSONObject jsonobjval = (JSONObject) jsonarry.get(i);
			String firstname = (String) jsonobjval.get("firstName");
			String lastname = (String) jsonobjval.get("lastName");

			stringarry[i] = firstname + "," + lastname;

		}

		return stringarry;

	}

}
