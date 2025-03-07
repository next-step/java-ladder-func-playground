package utils;

import org.slf4j.*;

public class ExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    public static void handleException(Exception e) {
        System.err.println("시스템 오류 : " + e.getMessage());
        logger.error("시스템 오류 : ", e);
    }
}
