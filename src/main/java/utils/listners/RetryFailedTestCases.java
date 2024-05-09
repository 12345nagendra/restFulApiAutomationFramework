package main.java.utils.listners;

import main.java.settings.GlobalSettings;
import main.java.utils.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.io.IOException;

public class RetryFailedTestCases implements IRetryAnalyzer {
    private int retryCount = 0;
    //You could mentioned maxRetryCnt (Maximum Retry Count) as per your requirement.
    private int maxRetryCnt;

    {
        try {
            maxRetryCnt = GlobalSettings.getGlobalSettings().getFailedTestRetryCount();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //This method will be called everytime a test fails. It will return TRUE if a test fails and need to be retried, else it returns FALSE
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCnt) {
            Logger.log("Retrying " + result.getName() + " again and the count is " + (retryCount + 1));
            retryCount++;
            return true;
        }
        return false;
    }
}
