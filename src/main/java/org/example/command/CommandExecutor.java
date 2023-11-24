package org.example.command;

import org.example.Operation;
import org.example.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static final Map<Operation, Command>allKnownCommandsMap = new HashMap<>();
    static {
        allKnownCommandsMap.put(Operation.INFO,new InfoCommand());
        allKnownCommandsMap.put(Operation.DEPOSIT,new DepositCommand());
        allKnownCommandsMap.put(Operation.WITHDRAW,new WithdrawCommand());
        allKnownCommandsMap.put(Operation.EXIT,new ExitCommand());
    }
    public static final void execute (Operation operation) throws InterruptOperationException {
        allKnownCommandsMap.get(operation).execute();
    }
    private CommandExecutor(){}
}
