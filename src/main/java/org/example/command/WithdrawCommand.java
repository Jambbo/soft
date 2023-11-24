package org.example.command;

import org.example.ConsoleHelper;
import org.example.CurrencyManipulator;
import org.example.CurrencyManipulatorFactory;
import org.example.exception.InterruptOperationException;

class WithdrawCommand implements Command{
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Withdrawing...");
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
       while(true){
           try{
               ConsoleHelper.writeMessage("Please enter an amount ");
               String s = ConsoleHelper.readString();
               if(s==null){
                   ConsoleHelper.writeMessage("Please specify valid data");
               }else{
                   try{
                        int amount = Integer.parseInt(s);
                        boolean isAmountAvailable = manipulator.isAmountAvailable(amount);
                        if(isAmountAvailable){

                        }
                   }catch(Exception e){

                   }
               }
           }catch(NumberFormatException e){

           }
       }
    }
}
