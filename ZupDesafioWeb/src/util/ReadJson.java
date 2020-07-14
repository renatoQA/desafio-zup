package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class ReadJson {

	public String readJson(String attribute)
			throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("data/data.json"));

		JSONObject jsonObject = (JSONObject) obj;

		String attributes = (String) jsonObject.get(attribute);

		return attributes;
	}
}
