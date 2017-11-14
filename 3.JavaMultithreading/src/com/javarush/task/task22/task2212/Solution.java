/*package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        boolean result=false;
        //Проверка на null
        if (telNumber==null||telNumber.equals("")) return false;
        //Если есть буква то false
        result=telNumber.matches("\\w");
        if (result==true) return false;
        //номер заканчивается на цифру
        char lastChar=telNumber.charAt(telNumber.length()-1);
        String last=String.valueOf(lastChar);
        //result=last.matches("\\d");
        if (!last.matches("\\d"))  return false;
        //если номер начинается с ‘+‘, то он содержит 12 цифр
        result=telNumber.matches("^\\+\\d{12}");
        if (result==true) return true;
        //если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
        result=telNumber.matches("^[\\d,(]\\d{10}");
        if (result==true){
            result=false;
            result = telNumber.matches("[-]{0,2}");

        }
        return result;
    }
    */

package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        // Проверка на null
        if (telNumber == null || telNumber.length() == 0) return false;

        // Проверяем условие 6
        String temp = new String(telNumber);
        temp = temp.replaceAll("[a-zA-Zа-яА-Я]", "");
        if (temp.length() != telNumber.length()) return false;

        // Проверяем условие 7
        char lastLetter = telNumber.charAt(telNumber.length()-1);
        String lastCharStr = String.valueOf(lastLetter);
        if (!lastCharStr.matches("\\d") ) return false;

        // Проверяем условие 1
        int countNumbers = countNumbers(telNumber);
        if ( telNumber.startsWith("+") ? ( countNumbers != 12 ) : ( false ) ) { return false;}

        // Проверяем условие 2
        String firstCharStr = String.valueOf(telNumber.charAt(0));
        if ( (firstCharStr.matches("\\d") || firstCharStr.equals("(") ) ? countNumbers != 10 : false) { return false; }

        // Проверки 3-5, возможно, красивее через split на части, но пока так
        // Проверяем условие 3
        Pattern hyphen = Pattern.compile("-");
        Matcher matcher = hyphen.matcher(telNumber);
        int count = 0;
        int prevIndex = -1;
        boolean isTooClose = false;
        while (matcher.find()) {
            count++;
            if ( count == 1 ) prevIndex = matcher.start();
            // Можно было сделать проверку на подряд идущие дефисы через выражение "--+", но ладно
            if (( count == 2 ) ? matcher.start() - prevIndex <= 1 : false ) isTooClose = true;
            if ( count > 2 ) break;
        }
        if ( count > 2 ) return false;
        if (isTooClose) return false;


        // Проверяем условие 4,5
        int startFirstOpenPar = telNumber.indexOf("(");
        int startFirstClosePat = telNumber.indexOf(")");
        if ( (startFirstClosePat >= 0 && startFirstOpenPar >= 0) ? (startFirstClosePat - startFirstOpenPar) != 4 :
                ((startFirstClosePat >= 0 && startFirstOpenPar < 0) || (startFirstClosePat < 0 && startFirstOpenPar >= 0) ) )
        {
            return false;
        }
        if (startFirstClosePat < startFirstOpenPar) return false;
        if (prevIndex >= 0 ? startFirstClosePat > prevIndex : false ) return false;

        if (telNumber.indexOf("(", startFirstClosePat + 1) >= 0 || telNumber.indexOf(")", startFirstClosePat + 1) >= 0 ) return false;


        return true;
    }

    public static int countNumbers(String telNumber) {
        String temp = new String(telNumber);
        temp = temp.replaceAll("\\D", "");

        return temp.length();
    }

    public static void main(String[] args) {

        System.out.println("1 = "+checkTelNumber("+380501234567"));// - true
        System.out.println("2 = "+checkTelNumber("+38(050)1234567"));// - true
        System.out.println("3 = "+checkTelNumber("+38050123-45-67"));// - true
        System.out.println("4 = "+checkTelNumber("050123-4567"));// - true
        System.out.println("5 = "+checkTelNumber("+38)050(1234567"));// - false
        System.out.println("6 = "+checkTelNumber("+38(050)1-23-45-6-7"));// - false
        System.out.println("7 = "+checkTelNumber("050ххх4567"));// - false
        System.out.println("8 = "+checkTelNumber("050123456"));// - false
        System.out.println("9 = "+checkTelNumber("(0)501234567"));// - false
        System.out.println("10 = "+checkTelNumber("(0501234567"));// - false
        System.out.println("11 = "+checkTelNumber("+380501234567"));// - false

    }
}
