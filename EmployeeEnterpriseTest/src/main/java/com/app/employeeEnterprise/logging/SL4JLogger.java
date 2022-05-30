package com.app.employeeEnterprise.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SL4JLogger {
    private static Logger logger = LoggerFactory.getLogger(SL4JLogger.class);

    public static Logger getLogger() {
        return logger;
    }
}
