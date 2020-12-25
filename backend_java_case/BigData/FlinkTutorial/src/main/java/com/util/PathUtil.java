package com.util;

import java.util.Properties;

/**
 * @author yangzl 2020.12.25
 * @version 1.00.00
 * @Description:
 * @history:
 */
public class PathUtil {

    public static String getHelloTxtInputPath() {

        Properties prop = System.getProperties();
        String os = prop.getProperty("os.name");
        String inputPath = null;

        if(os.startsWith("Windows")) {
            inputPath = "C:\\develop\\github\\MobileDevStudy\\backend_java_case\\BigData\\FlinkTutorial\\src\\main\\resources\\hello.txt";
        }else{

        }

        return inputPath;
    }
}
