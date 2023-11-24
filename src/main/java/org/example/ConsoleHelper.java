package org.example;

import org.example.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString()throws InterruptOperationException{
            try{
                String text = bis.readLine();
                if("exit".equals(text.trim().toLowerCase())){
                    throw new InterruptOperationException();
                }
                return text;
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
    }
    public static String askCurrencyCode() throws InterruptOperationException {
        while(true){
            ConsoleHelper.writeMessage("Please choose a currency code: ");
            String currencyCode = ConsoleHelper.readString();
            if(currencyCode.trim().length()!=3 || currencyCode==null){
                ConsoleHelper.writeMessage("Please specify a valid data");
                continue;
            }
            return currencyCode.trim().toUpperCase();
        }
    }
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        while(true){
            ConsoleHelper.writeMessage("Please enter 2 positive numbers(1st - denomination, 2nd - count");
            String s = ConsoleHelper.readString();

            String[] split =s.split(" ");
            if(s ==null || split.length!=2){
                ConsoleHelper.writeMessage("Please specify a valid data");
                continue;
            }
            try{
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            if( a<=0 || b<=0) {
                ConsoleHelper.writeMessage("Please specify a valid data");
                continue;
            }
            }catch(NumberFormatException e){
                ConsoleHelper.writeMessage("Please specify a valid data");
                continue;
            }
            return split;
        }
    }
    public static Operation askOperaion()throws InterruptOperationException {
        while (true) {
                ConsoleHelper.writeMessage("What operation do you want to perform?\n" +
                        "\t1 - INFO\n\t2 - DEPOSIT\n\t3 - WITHDRAW\n\t4 - EXIT");
                String operation = ConsoleHelper.readString().trim();
                int number = Integer.parseInt(operation);
            try {
                return Operation.getAllowableOperationByOrdinal(number);
            }catch(IllegalArgumentException e){
                ConsoleHelper.writeMessage("Please specify valid data.");
            }
        }
    }
}
