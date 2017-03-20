package com.nnbee.core.util;
/**
 *=====================================================================
 * ACP Date Type Handling Utility 
 *
 * This class is used to batch modify the Hibernate Generator strategy 
 * to Sequence Generator in the POJO classes in Oracle DB. 
 * 
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 12/10/2012   create
 *
 */

import java.io.*;

public class HibernateIDGenStrategyChange {

	private static String proPath = System.getProperty("user.dir");
	static String dirPath = proPath+"/src/main/java/com/auction/das/broker/model";
	

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String files;
		File folder = new File(dirPath);
		File[] listOfFiles = folder.listFiles();

		int number = 0;
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				files = listOfFiles[i].getName();
				if (files.endsWith(".java")) {
					String initStr = read(listOfFiles[i]);
					String retStr = addSequenceIDGenStrategy(initStr);
					if(!"".equals(retStr)){
						write(listOfFiles[i],retStr);
						number++;
					}
				}
			}
		}
		System.out.println("Done the changes for "+number+" files.");
	}

	/**
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String read(File file) throws IOException {
		if (file == null) {
			return "";
		}
		StringBuffer fileData = new StringBuffer(1000);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		char[] buf = new char[1024];
		int numRead = 0;
		while ((numRead = reader.read(buf)) != -1) {
			fileData.append(buf, 0, numRead);
		}
		reader.close();
		return fileData.toString();

	}

	/**
	 * @param file
	 * @param content
	 * @throws IOException
	 */
	public static void write(File file, String content) throws IOException {
		if (file == null) {
			return;
		}
		FileWriter fstream = new FileWriter(file);
		BufferedWriter out = new BufferedWriter(fstream);
		out.write(content);
		out.close();
	}

	 /**
	 * @param initString
	 * @return
	 */
	public static String addSequenceIDGenStrategy(String initString) {
		 String returnStr = "";
		 String tableName = "";
		 String seqName = "";
		 String seq_suffix = "_SQ";
		 
		 int i = initString.lastIndexOf("@Table(name =");
		 int tableNameBeginIndex = initString.indexOf("\"", i);
		 int tableNameBeginEnd = initString.indexOf("\"", tableNameBeginIndex+1);
		 tableName = initString.substring(tableNameBeginIndex+1, tableNameBeginEnd);
		 seqName = tableName+seq_suffix;
		 
		 String seqStr = "	@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.SEQUENCE, generator=\""+seqName+"_GEN\")\r\n"+
					"	@javax.persistence.SequenceGenerator(name=\""+seqName+ "_GEN\",sequenceName=\""+seqName+"\",allocationSize=1)";
		 
		 int idIndex = initString.lastIndexOf("@Id");
		 //if there is no '@Id' in the class which means it not a normal id class. We don't do anything for that situation right now.
		 if(idIndex==-1){
			 return "";
		 }else{
			 int idIndex_sec = initString.lastIndexOf("@javax.persistence.GeneratedValue(strategy=javax.persistence.GenerationType.SEQUENCE");
			 if(idIndex_sec!=-1){
				 return "";
			 }
		 }
		 returnStr = initString.substring(0, idIndex+3)+"\r\n"+seqStr +initString.substring(idIndex+3, initString.length());
		 return returnStr;
	 }
}
