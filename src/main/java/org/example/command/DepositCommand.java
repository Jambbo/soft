package org.example.command;

import org.example.ConsoleHelper;
import org.example.CurrencyManipulator;
import org.example.CurrencyManipulatorFactory;
import org.example.exception.InterruptOperationException;

class DepositCommand implements Command{

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Depositing...");
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        while(true) {
            String[] split = ConsoleHelper.getValidTwoDigits(currencyCode);
            try {
                int denomination = Integer.parseInt(split[0]);
                int count = Integer.parseInt(split[1]);
                manipulator.addAmount(denomination,count);
                ConsoleHelper.writeMessage(String.format("%d %s was successfully deposited",(denomination*count),currencyCode));
                break;
            }catch (NumberFormatException e){
                ConsoleHelper.writeMessage("Please specify valid data.");
            }
        }
    }
}
