package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;
import java.util.ResourceBundle;

class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException
    {

        ConsoleHelper.writeMessage("Enter currency code");
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int sum;
        while(true)
        {
            ConsoleHelper.writeMessage(res.getString("before"));
            String s = ConsoleHelper.readString();

            try {
                sum = Integer.parseInt(s);

            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                continue;
            }

            if (sum <= 0) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }

            if (!currencyManipulator.isAmountAvailable(sum)) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }

            try {
                currencyManipulator.withdrawAmount(sum);
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }

            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), sum, currencyCode));
            break;

        }

    }
}


/*class WithdrawCommand implements Command {

    private ResourceBundle res=ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override

    public void execute() throws InterruptOperationException
    {
        //ConsoleHelper.writeMessage("Enter currency code");
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        int sum;
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String s = ConsoleHelper.readString();
            try {
                sum = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            if (sum <= 0) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            if (!currencyManipulator.isAmountAvailable(sum)) {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }
            try {
                currencyManipulator.withdrawAmount(sum);
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }
            ConsoleHelper.writeMessage("Транзакция выполнена успешно");
            break;
        }

    }


    /*public void execute() throws InterruptOperationException {

        String currencyCode =  ConsoleHelper.askCurrencyCode();
        CurrencyManipulator currencyManipulator =
                CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        ConsoleHelper.writeMessage("Введите требуемую сумму: ");
        int summa=0;
        Map<Integer, Integer> map=null;
        try {
            summa=Integer.parseInt(ConsoleHelper.readString());
        }
        catch (NumberFormatException e){}
        while (summa<=0||!currencyManipulator.isAmountAvailable(summa)){
            ConsoleHelper.writeMessage("Введено не верно, попробуйте еще раз  ");
            try {
                summa=Integer.parseInt(ConsoleHelper.readString());
            }
            catch (NumberFormatException e){}

        try {
            map = currencyManipulator.withdrawAmount(summa);
        }
        catch (NotEnoughMoneyException e){
            ConsoleHelper.writeMessage("Нехватает банкнот");
            summa=0;
        }
        }
        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            ConsoleHelper.writeMessage("\t"+entry.getKey()+" - "+entry.getValue());
        }
        ConsoleHelper.writeMessage("Транзакция прошла успешно");
    }
}*/
