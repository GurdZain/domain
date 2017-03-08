package com.kavli.core.xml;

import org.apache.commons.collections.map.HashedMap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Map;

public class KeyValueHandler extends DefaultHandler
{   
	private boolean hasAttribute = false;
	private Attributes attributes = null;
	private Map<String, String> map = null;
	private String tagName;
	private int deep;
	private int parseIndex;
	private String key;
	private String value;
	
	public Map getMap(){
		return this.map;
	}
	public void startDocument() throws SAXException 
	{
		parseIndex = 0;
		deep = 0;
		//System.out.println("start parse");
		map = new HashedMap();
	}   

	public void endDocument() throws SAXException
	{   
		//System.out.println("end document");
	}   

	public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException
	{  
		this.tagName = qName;
		//System.out.println("start element");
		deep++;
	}   

	public void endElement(String uri, String localName, String qName)throws SAXException
	{
		this.tagName = null;
		//System.out.println("end element");
		deep--;
	}   

	public void characters(char[] ch, int start, int length) throws SAXException
	{
		String strData = new String(ch,start,length);
		if((this.tagName != null) && (strData != null)){
			switch (parseIndex) {
				case 0:
					if (deep == 4 && tagName.endsWith("key")) {
						parseIndex++;
					}
					break;
				case 1:
					if (deep == 5 && tagName.endsWith("value")) {
						key = strData;
						parseIndex++;
					}
					break;
				case 2:
					if (deep == 4 && tagName.endsWith("value")) {
						value = strData;
						//System.out.println("---------"+key+"-"+value);
						map.put(key.trim(), value.trim());
					}
					parseIndex=0;
					break;
				default:
					parseIndex=0;
					break;
			}

			//System.out.println("deep="+deep+",parseIndex="+parseIndex+" @@"+tagName+" get String: "+strData+" length="+strData.length());
		}
	}   
}  
