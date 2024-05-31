package main.java.utils.logUtility;

import java.util.Objects;

public class LoggerFactory {

    public static Logger getLogger(LogType logType) {
        if (Objects.requireNonNull(logType) == LogType.ALLURE_REPORT) {
            return new LogToAllure();
        }
        throw new RuntimeException();
    }
}
