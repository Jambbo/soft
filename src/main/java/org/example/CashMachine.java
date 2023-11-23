package org.example;

import org.example.command.CommandExecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class CashMachine{
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ENGLISH);
        Operation operation;
        do{
            operation= ConsoleHelper.askOperaion();
            CommandExecutor.execute(operation);
        }while(operation != Operation.EXIT);
    }
}