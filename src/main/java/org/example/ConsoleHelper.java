package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() {
            try{
                String text = bis.readLine();
                return text;
            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
    }
}
