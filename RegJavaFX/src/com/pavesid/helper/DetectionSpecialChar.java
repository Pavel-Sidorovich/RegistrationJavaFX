package com.pavesid.helper;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DetectionSpecialChar {

    public static Boolean isPassword(String s) {
        // Password must contain at least one number and one uppercase and lowercase letter, and (@$=!:.#%) and at least 8 or more characters
        if (s == null || s.trim().isEmpty() || s.equals("")) {
            return false;
        }
        Pattern p = Pattern.compile("^.*(?=.{8,})(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(^[a-zA-Z0-9@\\$=!:.#%]+$)");
        //Pattern p = Pattern.compile("^(?=.*[A-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@])\\S{6,12}$");
        Matcher m = p.matcher(s);
        return m.find();
    }

    public static Boolean isMail(String s) {
        // email in format xxx@xxx.xxx
        if (s == null || s.trim().isEmpty() || s.equals("")) {
            return false;
        }
        Pattern p = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
        Matcher m = p.matcher(s);
        return m.find();
    }
}
