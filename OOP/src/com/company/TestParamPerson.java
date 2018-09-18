package com.company;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public   class TestParamPerson {
    private static final String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    //private static final String PHONE_PATTERN ="^\\+?([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{2})([0-9]{2})$";
    private static final String PHONE_PATTERN ="^[0-9,+]{12}$";
    private static Pattern pattern;
    private static Pattern pattern1;
    private static Matcher matcher;
    private static Matcher matcher1;

    public static boolean correctEmail(String email){
           pattern = Pattern.compile(EMAIL_PATTERN);
           matcher = pattern.matcher(email);
           return matcher.matches();

    }

    public static boolean correctPhone(String tel){
        pattern1 = Pattern.compile(PHONE_PATTERN);
        matcher1 = pattern1.matcher(tel);
        return matcher1.matches();
    }

    public static boolean correctAge(int age){
        return (age >=18 && age <= 60)? true:false;
    }

    public static boolean correctSalary(int s){
        return (s >= 15000)? true:false;
    }

    public static boolean correctFio(String fio){
        return (fio.length() >= 5)? true:false;
    }
    public static boolean correctPosition(String fio){
        return (fio.length() >= 5)? true:false;
    }
}
