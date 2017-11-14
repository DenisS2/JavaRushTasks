package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LoginCommand implements Command {

    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {

        String cardNumber;
        String pin;

        ConsoleHelper.writeMessage(res.getString("before"));

        while (true) {

            ConsoleHelper.writeMessage(res.getString("specify.data"));
            cardNumber = ConsoleHelper.readString();
            pin = ConsoleHelper.readString();

            if (validCreditCards.containsKey(cardNumber)) {

                if (validCreditCards.getString(cardNumber).equals(pin)) {
                    ConsoleHelper.writeMessage(res.getString("success.format"));
                    break;
                }
                else {
                    ConsoleHelper.writeMessage(res.getString("not.verified.format"));
                    ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                }
            }
            else {
                ConsoleHelper.writeMessage(res.getString("not.verified.format"));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
        }
    }
}



/*public class LoginCommand implements Command {

    //private ResourceBundle validCreditCards=ResourceBundle.getBundle(CashMachine.class.getPackage() + ".resources.verifiedCards.properties");
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res=ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");


    @Override
    public void execute() throws InterruptOperationException {
        //String cardNumberTest="123456789012";
        //String pinTest="1234";
        ConsoleHelper.writeMessage("Введите номер карты (12 символов): ");
        String cardNumber=ConsoleHelper.readString();
        ConsoleHelper.writeMessage("Введите ПИН: ");
        String pin=ConsoleHelper.readString();

        Pattern pCardNumber = Pattern.compile("\\d{12}");
        Matcher mCardNumber = pCardNumber.matcher(cardNumber);
        Pattern pPin = Pattern.compile("\\d{4}");
        Matcher mPin = pPin.matcher(pin);

        boolean verification=false;

        while (!verification) {
            while (!mCardNumber.matches() && !mPin.matches()) {
                ConsoleHelper.writeMessage("Ввод не верный, повторите");
                ConsoleHelper.writeMessage("Введите номер карты (12 символов): ");
                cardNumber = ConsoleHelper.readString();
                ConsoleHelper.writeMessage("Введите ПИН: ");
                pin = ConsoleHelper.readString();
                mCardNumber = pCardNumber.matcher(cardNumber);
                mPin = pPin.matcher(pin);
            }

            if (validCreditCards.containsKey(cardNumber) && validCreditCards.getString(cardNumber).equals(pin)) {
                ConsoleHelper.writeMessage("Верификация прошла успешно");
                verification = true;
            } else {
                ConsoleHelper.writeMessage("Данные не верефицированы. Повторите ввод");
                verification = false;
                cardNumber="";
                pin="";
                mCardNumber = pCardNumber.matcher(cardNumber);
                mPin = pPin.matcher(pin);
            }
        }
    }
}*/
