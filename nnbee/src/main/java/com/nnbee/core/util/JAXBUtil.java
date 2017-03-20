package com.nnbee.core.util;
/**
 *=====================================================================
 * ACP JABX Utility 
 *
 * 
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 12/10/2012   create
 *
 */

import com.nnbee.core.constant.ErrorDescription;
import com.nnbee.core.constant.ExceptionType;
import com.nnbee.core.exception.UtilityException;
import com.nnbee.core.vo.json.ErrorVO;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.inject.Named;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Named
public class JAXBUtil {
    private static Logger mLogger = LoggerFactory.getLogger(JAXBUtil.class.getName());
   
    private static Map<String,Marshaller> marshallerMap = new HashMap<String,Marshaller>();
    
    private static Map<String,Unmarshaller> unmarshallerMap = new HashMap<String,Unmarshaller>();
    

    /**
     * @param object
     * @param cdataElements
     * @return
     * @throws UtilityException
     */
    public static String marshallerObject(Object object, String[] cdataElements)
            throws UtilityException {
        if (object == null) {
            return "";
        }
        String xmlData = null;
        ByteArrayOutputStream oStream = null;

        try {
            Marshaller m = getMarshallerByName(object.getClass(),"");
            oStream = new ByteArrayOutputStream();
            // get an Apache XMLSerializer configured to generate CDATA
            XMLSerializer serializer = getXMLSerializer(cdataElements, oStream);
            synchronized(m){
            	m.marshal(object, serializer.asContentHandler());
            }
        } catch (JAXBException e) {
            mLogger.error(MessageFormattor.errorFormat(JAXBUtil.class.getName(),
                    "marshallerObject", ExceptionType.EXCEPTION_XML,
                    e.getMessage()));
            throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
	                   new ErrorVO(ErrorDescription.ERR_CD_UT_XML_CONVERSION, ErrorDescription.ERR_MSG_UT_XML_CONVERSION, e.getMessage()));
        } catch (IOException e) {
            mLogger.error(MessageFormattor.errorFormat(JAXBUtil.class.getName(),
                    "marshallerObject", ExceptionType.EXCEPTION_XML,
                    e.getMessage()));
            throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
	                   new ErrorVO(ErrorDescription.ERR_CD_UT_XML_CONVERSION, ErrorDescription.ERR_MSG_UT_XML_CONVERSION, e.getMessage()));
        } catch (Exception e) {
            mLogger.error(MessageFormattor.errorFormat(JAXBUtil.class.getName(),
                    "marshallerObject", ExceptionType.EXCEPTION_XML,
                    e.getMessage()));
            throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
	                   new ErrorVO(ErrorDescription.ERR_CD_UT_XML_CONVERSION, ErrorDescription.ERR_MSG_UT_XML_CONVERSION, e.getMessage()));
        }
        xmlData = new String(oStream.toByteArray());
        return xmlData;
    }

    /**
     * 
     * @param object
     * @param cdataElements 
     * @param xsdPath
     */
    public static String marshallerObjectWithXsdValidation(Object object, String[] cdataElements, String xsdPath) throws UtilityException {
        if (object == null || StringUtil.isBlank(xsdPath)) {
            return "";
        }
        String xmlData = null;
        ByteArrayOutputStream oStream = null;
        
        try {
        	Marshaller m = getMarshallerByName(object.getClass(),xsdPath);
        	oStream = new ByteArrayOutputStream();
            // get an Apache XMLSerializer configured to generate CDATA
            XMLSerializer serializer = getXMLSerializer(cdataElements, oStream);
            synchronized(m){
            	m.marshal(object, serializer.asContentHandler());
            }
        }catch (JAXBException e) {
            mLogger.error(MessageFormattor.errorFormat(JAXBUtil.class.getName(),
                    "marshallerObject", ExceptionType.EXCEPTION_UTILITY,
                    e.getMessage()));
            throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
	                   new ErrorVO(ErrorDescription.ERR_CD_UT_XML_CONVERSION, ErrorDescription.ERR_MSG_UT_XML_CONVERSION, e.getMessage()));
        } catch (IOException e) {
            mLogger.error(MessageFormattor.errorFormat(JAXBUtil.class.getName(),
                    "marshallerObject", ExceptionType.EXCEPTION_UTILITY,
                    e.getMessage()));
            throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
	                   new ErrorVO(ErrorDescription.ERR_CD_UT_XML_CONVERSION, ErrorDescription.ERR_MSG_UT_XML_CONVERSION, e.getMessage()));
        } catch (Exception e) {
            mLogger.error(MessageFormattor.errorFormat(JAXBUtil.class.getName(),
                    "marshallerObject", ExceptionType.EXCEPTION_UTILITY,
                    e.getMessage()));
            throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
	                   new ErrorVO(ErrorDescription.ERR_CD_UT_XML_CONVERSION, ErrorDescription.ERR_MSG_UT_XML_CONVERSION, e.getMessage()));
        }
        xmlData = new String(oStream.toByteArray());
        return xmlData;
    }

    /**
     * @param cdataElements
     *            specify which of your elements you want to be handled as
     *            CDATA. The use of the '^' between the namespaceURI and the
     *            localname seems to be an implementation detail of the xerces
     *            code. When processing xml that doesn't use namespaces, simply
     *            omit the namespace prefix as shown in the third CDataElement
     *            below. new String[] { "ns1^foo", // "ns2^bar", // "^baz" }
     * @return
     */
    private static XMLSerializer getXMLSerializer(String[] cdataElements,
            ByteArrayOutputStream oStream) {
        // configure an OutputFormat to handle CDATA
        OutputFormat of = new OutputFormat();
        of.setCDataElements(cdataElements); //
        // set any other options you'd like
        of.setPreserveSpace(true);
        of.setIndenting(true);
        // create the serializer
        XMLSerializer serializer = new XMLSerializer(of);
        serializer.setOutputByteStream(oStream);
        return serializer;
    }

    /**
     * @param xml
     * @param className
     * @return unmarshal object without XSD validation
     * @throws UtilityException
     */
    public static Object unmarshallerWithoutXsdValidation(String xml, Class<?> className) throws UtilityException {
        Object object = null;
        if (StringUtil.isBlank(xml) || className == null) {
            return null;
        }
        try {
            StringReader reader = new StringReader(xml);
            Unmarshaller um = getUnmarshallerByName(className,"");
            synchronized(um){
            	object = um.unmarshal(reader);
            }
        } catch (JAXBException e) {
            mLogger.error(MessageFormattor.errorFormat(JAXBUtil.class.getName(),
                    "unmarshallerWithoutXsdValidation",
                    ExceptionType.EXCEPTION_UTILITY, e.getMessage()));
            throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
	                   new ErrorVO(ErrorDescription.ERR_CD_UT_XML_CONVERSION, ErrorDescription.ERR_MSG_UT_XML_CONVERSION, e.getMessage()));
        } catch (Exception e) {
            mLogger.error(MessageFormattor.errorFormat(JAXBUtil.class.getName(),
                    "unmarshallerWithoutXsdValidation",
                    ExceptionType.EXCEPTION_XML, e.getMessage()));
            throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
	                   new ErrorVO(ErrorDescription.ERR_CD_UT_XML_CONVERSION, ErrorDescription.ERR_MSG_UT_XML_CONVERSION, e.getMessage()));
        }
        return object;
    }
    
    /**
     * @param xml
     * @param className
     * @param xsdPath
     * @return
     * @throws UtilityException
     */
    public static Object unmarshallerWithXsdValidation(String xml,
            Class<?> className, String xsdPath) throws UtilityException {
        Object object = null;
        if (StringUtil.isBlank(xml) || className == null
                || StringUtil.isBlank(xsdPath)) {
            return null;
        }
        String errorMsg = "";
        try {
        	StringReader reader = new StringReader(xml);
        	Unmarshaller um = getUnmarshallerByName(className,xsdPath);
        	synchronized(um){
        		object = um.unmarshal(reader);
        	}
        }catch (JAXBException e) {
            errorMsg = "Can't unmarshall object with input: " + xml + ".";
            mLogger.error(MessageFormattor.errorFormat(JAXBUtil.class.getName(),
                    "unmarshallerWithXsdValidation",
                    ExceptionType.EXCEPTION_UTILITY, errorMsg + e.getMessage()));
            throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
	                   new ErrorVO(ErrorDescription.ERR_CD_UT_XML_CONVERSION, ErrorDescription.ERR_MSG_UT_XML_CONVERSION, e.getMessage()));
        }catch (Exception e) {
            errorMsg = "Can't unmarshall object with input: " + xml + ".";
            mLogger.error(MessageFormattor.errorFormat(JAXBUtil.class.getName(),
                    "unmarshallerWithXsdValidation",
                    ExceptionType.EXCEPTION_UTILITY, errorMsg + e.getMessage()));
            throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
	                   new ErrorVO(ErrorDescription.ERR_CD_UT_XML_CONVERSION, ErrorDescription.ERR_MSG_UT_XML_CONVERSION, e.getMessage()));
        }
        return object;
    }
    
    
    
    /**
     * @param className
     * @param xsdPath
     * @return
     * @throws UtilityException
     */
    private static Unmarshaller getUnmarshallerByName(Class<?> className, String xsdPath) throws UtilityException{
    	String key = className.getName()+xsdPath;
    	Unmarshaller unmarshaller = unmarshallerMap.get(key);
    	if(unmarshaller==null){
    		unmarshaller = newUnmarshallerInstance(className,xsdPath);
    		unmarshallerMap.put(key, unmarshaller);
    	}
    	return unmarshaller;
    }
    
    /**
     * @param className
     * @param xsdPath
     * @return
     * @throws UtilityException
     */
    private static Marshaller getMarshallerByName(Class<?> className, String xsdPath) throws UtilityException{
    	String key = className.getName()+xsdPath;
    	Marshaller marshaller = marshallerMap.get(key);
    	if(marshaller==null){
    		marshaller = newMarshallerInstance(className,xsdPath);
    		marshallerMap.put(key, marshaller);
    	}
    	return marshaller;
    }
    
    /**
     * @param className
     * @param xsdPath
     * @return
     * @throws UtilityException
     */
    private static Marshaller newMarshallerInstance(Class<?> className, String xsdPath) throws UtilityException {
    	String errorMsg = "";
    	String completePath = "";
    	try {
			JAXBContext context = JAXBContext.newInstance(className);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	        //Check the Schema is null or not
	        if(StringUtil.isNotBlank(xsdPath)){
		        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	        	String basePath = xsdPath;
//		        URL tempPath = JAXBUtil.class.getResource(basePath + xsdPath);
		        completePath = basePath + xsdPath;
//		        Schema schema = schemaFactory.newSchema(new File(completePath));
		        InputStream is = JAXBUtil.class.getResourceAsStream(completePath);;  
		        if (is == null) {
		            mLogger.error(MessageFormattor.errorFormat(
		                    JAXBUtil.class.getName(),
		                    "unmarshallerWithXsdValidation",
		                    ExceptionType.EXCEPTION_UTILITY,
		                    "Can't find the schema file through the path '"
		                    + basePath + xsdPath + "' ."));
		            return null;
		        }
		        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                Schema schema = schemaFactory.newSchema(new SAXSource(new InputSource(br)));
		        marshaller.setSchema(schema);
	        }
	        return marshaller;
    	} catch (SAXException e) {
            errorMsg = "Can't create a new schema with the path '"
                    + completePath + "'," + e.getMessage();
            mLogger.error(MessageFormattor.errorFormat(JAXBUtil.class.getName(),
                    "marshallerWithXsdValidation",
                    ExceptionType.EXCEPTION_UTILITY, errorMsg));
            throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
	                   new ErrorVO(ErrorDescription.ERR_CD_UT_XML_CONVERSION, ErrorDescription.ERR_MSG_UT_XML_CONVERSION, e.getMessage()));
        } catch (JAXBException e) {
            errorMsg = "Can't create a new instance of Marshaller.";
            mLogger.error(MessageFormattor.errorFormat(JAXBUtil.class.getName(),
                    "newInstanceMarshaller",
                    ExceptionType.EXCEPTION_UTILITY, errorMsg + e.getMessage()));
            throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
	                   new ErrorVO(ErrorDescription.ERR_CD_UT_XML_CONVERSION, ErrorDescription.ERR_MSG_UT_XML_CONVERSION, e.getMessage()));
        } catch (Exception e) {
            errorMsg = "Can't create a new instance of Marshaller.";
            mLogger.error(MessageFormattor.errorFormat(JAXBUtil.class.getName(),
                    "newInstanceMarshaller",
                    ExceptionType.EXCEPTION_UTILITY, errorMsg + e.getMessage()));
            throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
	                   new ErrorVO(ErrorDescription.ERR_CD_UT_XML_CONVERSION, ErrorDescription.ERR_MSG_UT_XML_CONVERSION, e.getMessage()));
        }
    }
    
    /**
     * @param className
     * @param xsdPath
     * @return
     * @throws UtilityException
     */
    private static Unmarshaller newUnmarshallerInstance(Class<?> className, String xsdPath) throws UtilityException {
    	String errorMsg = "";
    	String completePath = "";
    	try {
			JAXBContext context = JAXBContext.newInstance(className);
			Unmarshaller unmarshaller = context.createUnmarshaller();
	        //Check the Schema is null or not
	        if(StringUtil.isNotBlank(xsdPath)){
		        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
	        	String basePath = xsdPath;
//		        URL tempPath = JAXBUtil.class.getResource(basePath + xsdPath);
		        completePath = basePath + xsdPath;
//		        Schema schema = schemaFactory.newSchema(new File(completePath));
		        InputStream is = JAXBUtil.class.getResourceAsStream(completePath);  ;  
		        if (is == null) {
		            mLogger.error(MessageFormattor.errorFormat(
		                    JAXBUtil.class.getName(),
		                    "unmarshallerWithXsdValidation",
		                    ExceptionType.EXCEPTION_UTILITY,
		                    "Can't find the schema file through the path '"
		                    + basePath + xsdPath + "' ."));
		            return null;
		        }
		        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                Schema schema = schemaFactory.newSchema(new SAXSource(new InputSource(br)));
		        unmarshaller.setSchema(schema);
	        }
	        return unmarshaller;
    	} catch (SAXException e) {
            errorMsg = "Can't create a new schema with the path '"
                    + completePath + "'," + e.getMessage();
            mLogger.error(MessageFormattor.errorFormat(JAXBUtil.class.getName(),
                    "unmarshallerWithXsdValidation",
                    ExceptionType.EXCEPTION_UTILITY, errorMsg));
            throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
	                   new ErrorVO(ErrorDescription.ERR_CD_UT_XML_CONVERSION, ErrorDescription.ERR_MSG_UT_XML_CONVERSION, e.getMessage()));
        } catch (JAXBException e) {
            errorMsg = "Can't create a new instance of Unmarshaller.";
            mLogger.error(MessageFormattor.errorFormat(JAXBUtil.class.getName(),
                    "unmarshallerWithXsdValidation",
                    ExceptionType.EXCEPTION_UTILITY, errorMsg + e.getMessage()));
            throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
	                   new ErrorVO(ErrorDescription.ERR_CD_UT_XML_CONVERSION, ErrorDescription.ERR_MSG_UT_XML_CONVERSION, e.getMessage()));
        } catch (Exception e) {
            errorMsg = "Can't create a new instance of Unmarshaller.";
            mLogger.error(MessageFormattor.errorFormat(JAXBUtil.class.getName(),
                    "unmarshallerWithXsdValidation",
                    ExceptionType.EXCEPTION_UTILITY, errorMsg + e.getMessage()));
            throw new UtilityException(ExceptionType.EXCEPTION_UTILITY,
	                   new ErrorVO(ErrorDescription.ERR_CD_UT_XML_CONVERSION, ErrorDescription.ERR_MSG_UT_XML_CONVERSION, e.getMessage()));
        }
    }
}
