package com.kavli.core.utils;

import com.kavli.main.DoMain;
import org.apache.commons.collections.map.HashedMap;

import java.io.*;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/8.
 */
public class PropertyUtil {
    private static Map<String, String> maps;
    static {
        maps = new HashedMap();
        PropertyUtil.loadPropertyFile();
    }
    public static String get(String key){
        if (maps != null) {
            return maps.get(key);
        }
        return null;
    }
    private static void loadPropertyFile(){
        File path = new File(PropertyUtil.class.getResource("/").getPath());
        //读取根目录下
        loadFile(path);
        loadFile(new File(path.getPath()+"/common"));
        if (DoMain.PROD_ENV) {
            loadFile(new File(path.getPath()+"/prod"));
        } else {
            loadFile(new File(path.getPath()+"/qa"));
        }
    }

    private static void loadFile(File path) {
        //System.out.println(path.getAbsolutePath());
        String[] fileName = path.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (name.endsWith(".properties")
                        || name.endsWith(".conf")
                        || name.endsWith(".CONF")
                        || name.endsWith(".ini")
                        || name.endsWith(".INI")
                        || name.endsWith(".dat")
                        || name.endsWith(".DAT")
                        || name.endsWith(".PROPERTIES")) {
                    return true;
                }
                return false;
            }
        });
        if (fileName != null && fileName.length>0) {
            for (String name : fileName) {
                Properties properties=new Properties();
                try {
                    FileInputStream fs = new FileInputStream(new File(path, name));
                    BufferedInputStream bis = new BufferedInputStream(fs);
                    InputStreamReader ir = new InputStreamReader(bis);
                    properties.load(ir);
                    Enumeration propertyNames = properties.propertyNames();
                    if (propertyNames != null) {
                        while (propertyNames.hasMoreElements()) {
                            String key = (String) propertyNames.nextElement();
                            String value = properties.getProperty(key);
                            maps.put(key.trim(), value.trim());
                        }
                    }
                    ir.close();
                    bis.close();
                    fs.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
