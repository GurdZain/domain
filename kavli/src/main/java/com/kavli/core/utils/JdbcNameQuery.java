package com.kavli.core.utils;

import com.kavli.core.xml.KeyValueHandler;
import com.kavli.core.xml.imp.XmlSax;
import org.apache.commons.collections.map.HashedMap;

import java.io.*;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/8.
 */
public class JdbcNameQuery {
    private static Map<String, String> maps;
    static {
        loadXml();
    }
    public static String getQueryByName(String queryName) {
        return maps.get(queryName);
    }
    private static void loadXml(){
        File path = new File(JdbcNameQuery.class.getResource("/").getPath()+"/common/");
        File file = new File(path, "jdbcNamedQuery-security.xml");
        KeyValueHandler handler = new KeyValueHandler();
        try {
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            XmlSax xmlSax = new XmlSax();
            xmlSax.parserXml(bis, handler);
            bis.close();
            fis.close();
            maps = handler.getMap();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (maps == null) {
            maps = new HashedMap();
        }
    }
}
