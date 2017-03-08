package com.kavli.core.xml.imp;

import com.kavli.core.xml.XmlDoc;

public class XmlDom4j implements XmlDoc
{

	public void createXml(String fileName) {   
		/*
		Document document = DocumentHelper.createDocument();   
		Element employees=document.addElement("employees");   
		Element employee=employees.addElement("employee");   
		Element name= employee.addElement("name");   
		name.setText("ddvip");   
		Element sex=employee.addElement("sex");   
		sex.setText("m");   
		Element age=employee.addElement("age");   
		age.setText("29");   
		try {   
		Writer fileWriter=new FileWriter(fileName);   
		XMLWriter xmlWriter=new XMLWriter(fileWriter);   
		xmlWriter.write(document);   
		xmlWriter.close();   
		} catch (IOException e) {   

		System.out.println(e.getMessage());   
		}   */


		}   


		public void parserXml(String fileName) {   
		/*File inputXml=new File(fileName);   
		SAXReader saxReader = new SAXReader();   
		try {   
		Document document = saxReader.read(inputXml);   
		Element employees=document.getRootElement();   
		for(Iterator i = employees.elementIterator(); i.hasNext();){   
		Element employee = (Element) i.next();   
		for(Iterator j = employee.elementIterator(); j.hasNext();){   
		Element node=(Element) j.next();   
		System.out.println(node.getName()+":"+node.getText());   
		}   

		}   
		} catch (DocumentException e) {   
		System.out.println(e.getMessage());   
		}   
		System.out.println("dom4j parserXml");   */
		}   

}
 