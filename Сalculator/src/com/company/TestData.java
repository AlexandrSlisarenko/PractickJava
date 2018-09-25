package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TestData {
    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean correctData(String data){
        boolean res =false;
        pattern = Pattern.compile("^[0-9]+");
        matcher = pattern.matcher(data);
        res = (matcher.matches()&&(data.length()<=4))? true:false;
        return res;

    }
}
