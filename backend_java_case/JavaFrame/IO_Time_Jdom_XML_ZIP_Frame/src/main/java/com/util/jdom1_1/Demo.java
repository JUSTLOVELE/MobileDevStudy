package com.util.jdom1_1;

import java.io.StringReader;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.junit.Test;
import org.xml.sax.InputSource;

public class Demo {

	@Test
	public void parseXMLtoDocument(){
		try {
			String xml = "<>";
			StringReader stringReader = new StringReader(xml);
			InputSource inputSource = new InputSource(stringReader);
			SAXBuilder sax = new SAXBuilder();
			Document doc = sax.build(inputSource);
			Element root = doc.getRootElement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
