package com.javarush.task.task26.task2613.command;




import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;


class ExitCommand implements Command {
    private ResourceBundle res =ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "exit_en");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        String answer = ConsoleHelper.readString().toLowerCase().trim();
        //if (res.getString("yes").equals(answer))
        if (ConsoleHelper.readString().equals("y"))
            ConsoleHelper.writeMessage(res.getString("thank.message"));

    }
}

/*class ExitCommand implements Command {

    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.task.task26.task2613.resources.exit_en");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        if (ConsoleHelper.readString().equals(res.getString("yes")))
        {
            ConsoleHelper.writeMessage(res.getString("yes"));
            ConsoleHelper.writeMessage(res.getString("thank.message"));
        }
    }


}*/

/*import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

class ExitCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle("com.javarush.task.task26.task2613.resources.exit_en");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        String answer = ConsoleHelper.readString().toLowerCase().trim();
        if (res.getString("yes").equals(answer)) {
            ConsoleHelper.writeMessage(res.getString("thank.message"));
        }
    }
}

/*class ExitCommand implements Command {

    private ResourceBundle res=ResourceBundle.getBundle("com.javarush.task.task26.task2613.resources.exit_en");

    @Override


    public void execute()throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));//"Действительно хотите выйти??? y/n");
        String s=ConsoleHelper.readString().toLowerCase().trim();
        //while (!s.toLowerCase().equals(res.getString("yes"))&&!s.toLowerCase().equals("n")){
            //ConsoleHelper.writeMessage("Ввод неверный. Повторите: y/n");
        //    s = ConsoleHelper.readString();
        //}

        if (s.equals(res.getString("yes")))
            ConsoleHelper.writeMessage(res.getString("thank.message"));
        /*switch (s.toLowerCase()){
            case "y": {
                ConsoleHelper.writeMessage(res.getString("thank.message"));
                //System.exit(0);
            }
            case "n": {
                //ConsoleHelper.writeMessage("Досвидания!!!");
                //System.exit(0);
            }
        }
    }
}*/
