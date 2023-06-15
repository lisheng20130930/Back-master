package com.qp.ots.utils;

public class Logger {
    private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Logger.class);
    public synchronized static void log(String str){
        logger.warn(str);
    }

    public static void trace(String str) {
        log(str);
    }

    public static void main(String[] args){
        Logger.log("========================");
    }
}
