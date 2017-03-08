package com.kavli.core.xml.imp;

import java.io.FileInputStream;   
import java.io.FileNotFoundException;   
import java.io.IOException;   
import java.io.InputStream;

import com.kavli.core.xml.KeyValueHandler;
import com.kavli.core.xml.XmlDoc;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;   
import javax.xml.parsers.SAXParser;   
import javax.xml.parsers.SAXParserFactory;   
   
import org.xml.sax.SAXException;   


public class XmlSax implements XmlDoc
{
	public void createXml(String fileName)
	{   
		System.out.println("<<"+fileName+">>");   
	} 
	public void parserXml(InputStream is,DefaultHandler handler)
	{
		SAXParserFactory saxfac = SAXParserFactory.newInstance();   
		try {   
			SAXParser saxparser = saxfac.newSAXParser();     
			saxparser.parse(is, handler);   
		} catch (ParserConfigurationException e) {   
			e.printStackTrace();   
		} catch (SAXException e) {   
			e.printStackTrace();   
		} catch (FileNotFoundException e) {   
			e.printStackTrace();   
		} catch (IOException e) {   
			e.printStackTrace();   
		} 
	}
	public void parserXml(String fileName)
	{   
		SAXParserFactory saxfac = SAXParserFactory.newInstance();   
		try {   
			SAXParser saxparser = saxfac.newSAXParser();   
			InputStream is = new FileInputStream(fileName);   
			saxparser.parse(is, new KeyValueHandler());
		} catch (ParserConfigurationException e) {   
			e.printStackTrace();   
		} catch (SAXException e) {   
			e.printStackTrace();   
		} catch (FileNotFoundException e) {   
			e.printStackTrace();   
		} catch (IOException e) {   
			e.printStackTrace();   
		}   
	}   
}