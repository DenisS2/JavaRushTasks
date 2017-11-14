package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.Operation;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

import static com.javarush.task.task26.task2613.Operation.*;

public class CommandExecutor {

    private static final Map<Operation, Command> allKnownCommandsMap=new HashMap<>();

    static {
        allKnownCommandsMap.put(INFO,new InfoCommand());
        allKnownCommandsMap.put(DEPOSIT,new DepositCommand());
        allKnownCommandsMap.put(WITHDRAW,new WithdrawCommand());
        allKnownCommandsMap.put(EXIT,new ExitCommand());
        allKnownCommandsMap.put(LOGIN, new LoginCommand());
    }

    private CommandExecutor() {

    }

    public static final void execute(Operation operation)throws InterruptOperationException {
        switch (operation){
            case LOGIN:allKnownCommandsMap.get(operation).execute();
                break;
            case INFO:allKnownCommandsMap.get(operation).execute();
                break;
            case DEPOSIT:allKnownCommandsMap.get(operation).execute();
                break;
            case WITHDRAW:allKnownCommandsMap.get(operation).execute();
                break;
            case EXIT:allKnownCommandsMap.get(operation).execute();
                break;
        }
    }
}
