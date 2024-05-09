package main.java.configurations;

import main.java.enums.EnvironmentType;
import main.java.utils.CommonUtility;

import java.io.InputStream;
import java.util.Properties;

public class Environment {

    public static EnvironmentType environment;
    public static String restFulApiDevServiceHost;

    public static void prepareEnvironment(EnvironmentType environmentType) throws Exception {

        environment = environmentType;
        InputStream input = null;
        try {
            switch (environmentType) {
                case STAGING:
                    // Extracting the path of configurations package
                    input = CommonUtility.getInputStreamForFile(Environment.class.getClassLoader(), "configurations/StagingConfiguration.properties");
                    break;

                case LOCAL:
                    // Extracting the path of configurations package
                    input = CommonUtility.getInputStreamForFile(Environment.class.getClassLoader(), "configurations/Local.properties");
                    break;

                case TEST:
                    // Extracting the path of configurations package
                    input = CommonUtility.getInputStreamForFile(Environment.class.getClassLoader(), "configurations/TestConfiguration.properties");
                    break;

                case PROD:
                    // Extracting the path of configurations package
                    input = CommonUtility.getInputStreamForFile(Environment.class.getClassLoader(), "configurations/ProdConfiguration.properties");
                    break;

                default:
                    throw new Exception("Undefined environment");
            }
            Properties environmentProperty = new Properties();
            environmentProperty.load(input);
            restFulApiDevServiceHost = environmentProperty.getProperty("restFulApiDevServiceHost");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (input != null) input.close();
        }
    }
}
