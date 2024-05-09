package main.java.utils;

import io.qameta.allure.Attachment;

public class Logger {
    @Attachment(value = "{0}", type = "text/plain")
    public static String log(String message) {
        System.out.println(message);
        return message;
    }
}
