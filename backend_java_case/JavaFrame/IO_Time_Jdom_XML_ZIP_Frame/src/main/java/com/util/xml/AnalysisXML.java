package com.util.xml;

import java.util.HashMap;
import java.util.Map;

/**
 * analysis xml
 * @author yangzuliang
 *
 */
public class AnalysisXML {

	
	public Map<String, Object> analysisLabel(String xml, String label){
		
		Map<String, Object> params = new HashMap<String, Object>();
		
		int start = xml.indexOf("<" + label + ">");
	    int end = xml.lastIndexOf("</" + label + ">");
	    String paramsString = xml.substring(start+8, end);
	    
	    while(paramsString.length() > 0 && paramsString.contains("<")){
	    	
	    	start = paramsString.indexOf("<");
	 	    end = paramsString.indexOf(">");
	 	    String key = paramsString.substring(start+1, end);
	 	    start = paramsString.indexOf("<" + key + ">");
	 	    end = paramsString.indexOf("</" + key + ">");
	 	    String value = paramsString.substring(start + key.length() + 2, end);
	 	    paramsString = paramsString.substring(end + key.length() + 3);
	 	    params.put(key, value);
	 	    System.out.println((key + "," + value));
	    }
		
		return params;
	}
}
