package org.example;

import org.example.command.CommandExecutor;
import org.example.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class CashMachine{
    public static void main(String[] args) throws IOException, InterruptOperationException {
        Locale.setDefault(Locale.ENGLISH);
        try {
            Operation operation;
            do {
                operation = ConsoleHelper.askOperaion();
                CommandExecutor.execute(operation);
            } while (operation != Operation.EXIT);
        }catch(InterruptOperationException e){
            ConsoleHelper.writeMessage("Thank you for using this cashing machine. Good luck.");
        }
    }
}