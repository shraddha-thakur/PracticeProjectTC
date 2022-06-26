package com.dataprovider.latest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

// Dataprovider with JSON
public class DataProviderWithJSON {

	@Test(dataProvider="getData")
	public void testDPWithJson(Map<String, Object> map){

		for(Map.Entry<String, Object> m: map.entrySet()) {
			System.out.println(m.getKey()+":"+m.getValue());
		}
//		map.forEach((k,v)->System.out.println(k+":"+v));

	}

	@DataProvider
	public Object [] getData() throws StreamReadException, DatabindException, IOException {

		HashMap<String, Object> map1 = new ObjectMapper().
				readValue(new File(System.getProperty("user.dir") + "/src/test/resources/jsons/config.json"), 
						new TypeReference<HashMap<String, Object>>(){});

		HashMap<String, Object> map2 = new ObjectMapper().
				readValue(new File(System.getProperty("user.dir") + "/src/test/resources/jsons/config2.json"), 
						new TypeReference<HashMap<String, Object>>(){});


		return new Object[] {map1, map2};

	}

}

