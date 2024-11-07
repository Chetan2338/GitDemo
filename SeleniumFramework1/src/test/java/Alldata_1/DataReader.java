package Alldata_1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJsondatatomap() throws IOException
	{
		String JsonContent =FileUtils.readFileToString(new File(System.getProperty("D:\\eclipse\\SeleniumFramework1\\src\\test\\java\\Alldata_1\\DataReader.java")));
		//String to Hasmap
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String,String>>>(){});
			return data;
	}
	

}
