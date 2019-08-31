package com.Util;

import java.security.InvalidParameterException;

public class ConversionUtil {
    
    public static boolean strictConvertSTringToBoolean(String boolValue) {
        if ("true".equalsIgnoreCase(boolValue) || "false".equalsIgnoreCase(boolValue)) {
            return  Boolean.valueOf(boolValue);
        } else {
            throw new InvalidParameterException("The Provided value : '" +boolValue +"' is Inavlid.");
        }
    }

}
