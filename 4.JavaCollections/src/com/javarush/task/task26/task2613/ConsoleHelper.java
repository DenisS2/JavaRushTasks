package com.javarush.task.task26.task2613;


import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {

    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res=ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void printExitMessage(){
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }

    public  static void writeMessage(String message){
        System.out.println(message);
    }

    public  static String askCurrencyCode()throws InterruptOperationException{
        writeMessage("Введите код валюты 3 символа: ");
        String currencyCode = readString();
        while (currencyCode.length()!=3){
            writeMessage("ВВод неверный, попробуйте снова");
            writeMessage("Введите код валюты 3 символа: ");
            currencyCode = readString();
        }
        return currencyCode.toUpperCase();
    }

    public static Operation askOperation()throws InterruptOperationException{
        writeMessage("Введите тип операции: ");
        int operationNumber=0;
        try {
        operationNumber=Integer.parseInt(readString());
        }
        catch (NumberFormatException e){};
        while (operationNumber<1||operationNumber>4){
            writeMessage("Введено не верно, попробуйте еще раз  ");
            try {
                operationNumber=Integer.parseInt(readString());
            }
            catch (NumberFormatException e){}
        }
        return Operation.getAllowableOperationByOrdinal(operationNumber);
    }

    public static String[] getValidTwoDigits (String currencyCode) throws InterruptOperationException{
        writeMessage("Введите два целых положительных числа через пробел. Первое число — номинал, второе — количество банкнот ");
        String[] s=readString().split(" ");
        int nominal = 0;
        int county = 0;
        if (s.length==2){
        try {
            nominal = Integer.parseInt(s[0]);
            county = Integer.parseInt(s[1]);
        }
        catch (NumberFormatException e){
            //writeMessage("Введено не верно, попробуйте еще раз");
        }
        }
        while (nominal<1||county<1){
            writeMessage("Введено не верно, попробуйте еще раз");
            s=readString().split(" ");
            if (s.length==2){
            try {
                nominal = Integer.parseInt(s[0]);
                county = Integer.parseInt(s[1]);
            }
            catch (NumberFormatException e){
                //writeMessage("Введено не верно, попробуйте еще раз");
            }
            }
        }
        return s;
    }

    public static String readString() throws InterruptOperationException{
        String s="";
        try {
             s=bis.readLine();
             if (s.toLowerCase().equals("exit")) throw new  InterruptOperationException();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}
