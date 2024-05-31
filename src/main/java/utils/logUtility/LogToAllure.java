package main.java.utils.logUtility;

import groovy.util.logging.Log;
import io.qameta.allure.Attachment;

public class LogToAllure implements Logger {
    @Override
    @Attachment(value = "{0}", type = "text/plain")
    public String log(String message) {
        System.out.println(message);
        return message;
    }
}
