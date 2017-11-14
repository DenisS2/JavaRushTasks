package com.javarush.task.task26.task2613;


import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {

    public static final String RESOURCE_PATH = "com.javarush.task.task26.task2613.resources.";

    public static void main(String[] args)  {
        Locale.setDefault(Locale.ENGLISH);
        //String currencyCode=  ConsoleHelper.askCurrencyCode();
        //CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        //String[] s=ConsoleHelper.getValidTwoDigits(currencyCode);
        //currencyManipulator.addAmount(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
        //System.out.println(currencyManipulator.getTotalAmount());
        //System.out.println(CashMachine.class.getPackage() + ".resources.verifiedCards");
        try {
            Operation operation;
            CommandExecutor.execute(Operation.LOGIN);
            do {
                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            }
            while (!operation.equals(Operation.EXIT));


        } catch (InterruptOperationException e) {
            //ConsoleHelper.writeMessage("Программа прервана. Досвидания");
        }
        ConsoleHelper.printExitMessage();
    }
}
