package test.java;

import lombok.Getter;
import lombok.Setter;
import main.java.configurations.Environment;
import main.java.enums.EnvironmentType;
import main.java.settings.GlobalSettings;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlSuite;

import java.lang.reflect.Method;

@Setter
@Getter
public class Commons implements ITest {

    private ThreadLocal<String> testName = new ThreadLocal<>();

    @BeforeSuite(alwaysRun = true, description = "Initializing everything")
    public void initializer() throws Exception {
        //Reading the environment name from command line and setting it
        String environment = System.getProperty("env");

        if (environment == null)
            environment = "STAGING";

        EnvironmentType environmentType = EnvironmentType.valueOf(environment.toUpperCase());
        Environment.prepareEnvironment(environmentType);
    }

    /* Setting the parallel thread count for both method and dataproviders
    Any testNG.xml file property can be changed from this method
     */
    @BeforeSuite(alwaysRun = true, description = "Setting up Global configurations")
    public void performTestSettings(ITestContext context) throws Exception {
        context.getCurrentXmlTest().getSuite().setParallel(XmlSuite.ParallelMode.METHODS);
        context.getCurrentXmlTest().getSuite().setThreadCount(GlobalSettings.getGlobalSettings().getParallelMethodThreadCount());
        context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(GlobalSettings.getGlobalSettings().getParallelDataProviderThreads());
    }

    @BeforeMethod(description = "Setting test Name into the allure report")
    public void BeforeMethod(Method method, Object[] testData, ITestContext ctx) {
        if (testData.length > 0) {
            testName.set(method.getName() + ":" + testData[0]);
            ctx.setAttribute("testName", testName.get());
        } else
            ctx.setAttribute("testName", method.getName());
    }

    @Override
    public String getTestName() {
        return testName.get();
    }

}

