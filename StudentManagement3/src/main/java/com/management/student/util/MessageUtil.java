package com.management.student.util;

import java.io.IOException;
import java.text.MessageFormat;

/**
 * The Class MessageUtil, utility for message, it formats and returns the locale specific message.
 */
public class MessageUtil {
    
    /**
     * Gets the message.
     *
     * @param messageKey the message key
     * @return the message
     */
    public static String getMessage(final String messageKey, final String locale, final Object...arguments) throws IOException {
        return MessageFormat.format(PropertyUtil.getProperties(locale).getProperty(messageKey), arguments);
    }
    
}
