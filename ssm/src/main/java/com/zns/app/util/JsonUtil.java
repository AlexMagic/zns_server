package com.zns.app.util;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {

	/**
	 * Convert jsonString to jsonMap
	 * 
	 * @param jsonText
	 * @return
	 */
	public static Map<String, Object> Json2Map(String jsonText) {
		
		Map<String, Object> objMap = new HashMap<String, Object>();

		try {

			ObjectMapper mapper = new ObjectMapper();
			objMap = mapper.readValue(jsonText, Map.class);
			StringWriter writer = new StringWriter();
			JsonGenerator  gen = new JsonFactory().createJsonGenerator(writer);   
			mapper.writeValue(gen, jsonText); 
			writer.close(); 

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objMap;
	}

	/**
	 * Convert jsonMap to jsonString
	 * 
	 * @param jsonMap
	 * @return
	 */
	public static String Map2Json(Map<String, Object> jsonMap) {

		String jsonText = "";

		try {

			ObjectMapper mapper = new ObjectMapper();

			jsonText = mapper.writeValueAsString(jsonMap);
			mapper.configure(org.codehaus.jackson.JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
			JsonNode df = mapper.readValue(jsonText, JsonNode.class);
			jsonText = df.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return  jsonText;
	}
	
	public static List<LinkedHashMap<String, Object>> json2List(String jsonText){
		
		List<LinkedHashMap<String, Object>> list;
		
		try {

			ObjectMapper mapper = new ObjectMapper();
			list = mapper.readValue(jsonText, List.class);  
			StringWriter writer = new StringWriter();
			JsonGenerator  gen = new JsonFactory().createJsonGenerator(writer);   
			mapper.writeValue(gen, jsonText); 
			writer.close(); 

			
			return list;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
//	public static Map<String , Object> json2keyList(String jsonText){
//		Map<String , Object> map = new HashMap<String, Object>();
//		JSONArray array;
//		try {
//			array = new JSONArray(jsonText);
//			for(int i=0 ; i<array.length() ; i++){
//				JSONObject entityObj = array.getJSONObject(i); 
//			}
//			return map;
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	/**
     *      ��JavaBeanת��Ϊjson�ַ��� 
     *      (1)��ͨ����ת����toJson(Student) 
     *      (2)Listת����toJson(List)
     *      (3)Mapת��:toJson(Map)
     * ���Ƿ��ֲ���ʲô���ͣ�������ֱ�Ӵ����������
     * 
     * @param object JavaBean����
     * @return json�ַ���
     */
    public static String toJSon(Object object) {
    	
    	ObjectMapper objectMapper = new ObjectMapper();
    	
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
        }
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
