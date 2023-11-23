package org.example.command;

import org.example.ConsoleHelper;
import org.example.CurrencyManipulator;
import org.example.CurrencyManipulatorFactory;

class InfoCommand implements Command{
    @Override
    public void execute() {
        ConsoleHelper.writeMessage("Information: ");
        boolean hasMoney = false;
        for(CurrencyManipulator manipulator: CurrencyManipulatorFactory.getAllCurrencyManipulators()){
            if(manipulator.hasMoney()) {
                hasMoney = true;
                ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
            }
        }
        if(!hasMoney){
            ConsoleHelper.writeMessage("No money available.");
        }

    }
}
