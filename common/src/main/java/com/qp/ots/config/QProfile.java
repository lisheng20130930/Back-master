package com.qp.ots.config;

import com.qp.ots.utils.Logger;

import java.io.InputStream;
import java.util.Properties;

public class QProfile {
    public static final String DATA_DIR = "./";
    public static String env = null;
    public static boolean IS_MAIL_CLOUD = true;
    public static boolean SEND_SMS = true;

    /**
     *  Load Properties
     */
    static{
        try {
            QProfile.load("application.properties");
        }catch (Exception e){
            Logger.log("[Profile] error==>"+e.getMessage());
        }
    }

    private static void load(String configFileName) throws Exception {
        Properties properties = new Properties();
        InputStream in = getResourceAsStream(configFileName);
        properties.load(in);
        in.close();
        loadFromProperties(properties);
    }

    private static InputStream getResourceAsStream(String name) {
        return QProfile.class.getClassLoader().getResourceAsStream(name);
    }

    private static void loadFromProperties(Properties properties){
        env = properties.getProperty("env");
    }

    public static String PCAT(String p){
        return QProfile.DATA_DIR + "/" + p;
    }
}
