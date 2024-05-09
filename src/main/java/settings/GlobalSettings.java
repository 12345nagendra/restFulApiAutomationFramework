package main.java.settings;

import lombok.Getter;
import main.java.utils.CommonUtility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
public class GlobalSettings {

    private static GlobalSettings globalSettings = null;
    private int parallelMethodThreadCount;
    private int parallelDataProviderThreads;
    private int failedTestRetryCount;

    private GlobalSettings() throws IOException {

        InputStream input = CommonUtility.getInputStreamForFile(GlobalSettings.class.getClassLoader(), "configurations/TestSettings.properties");
        Properties parallelTestProp = new Properties();
        parallelTestProp.load(input);

        try {
//            looking for external input for failed test retry from command line
            failedTestRetryCount = Integer.parseInt(System.getProperty("retryTestCount"));
        } catch (NumberFormatException nfe) {
//            no external input, reading it from TestSetting property file
            failedTestRetryCount = Integer.parseInt(parallelTestProp.getProperty("failedTestRetryCount"));
        }

        try {
//            looking for external input for parallel methods run count from command line
            parallelMethodThreadCount = Integer.parseInt(System.getProperty("parallelMethodThreadCount"));
        } catch (NumberFormatException nfe) {
//            no external input, reading it from TestSetting property file
            parallelMethodThreadCount = Integer.parseInt(parallelTestProp.getProperty("parallelMethodThreadCount"));
        }

        try {
//            looking for external input for parallel data provider tests run count from command line
            parallelDataProviderThreads = Integer.parseInt(System.getProperty("parallelDataProviderThreads"));
        } catch (NumberFormatException nfe) {
//            no external input, reading it from TestSetting property file
            parallelDataProviderThreads = Integer.parseInt(parallelTestProp.getProperty("dataProviderParallelThreads"));
        }
        input.close();
    }

    //    This method will provide an instance of GlobalSettings class
    public static synchronized GlobalSettings getGlobalSettings() throws IOException {
        if (globalSettings == null) {
            globalSettings = new GlobalSettings();
        }
        return globalSettings;
    }
}
