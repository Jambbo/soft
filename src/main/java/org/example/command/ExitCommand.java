package org.example.command;

import org.example.ConsoleHelper;
import org.example.exception.InterruptOperationException;

class ExitCommand implements Command{

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("Are you sure you want to exit?(y/n) ");
        String answer = ConsoleHelper.readString();
        if(answer.trim().toLowerCase().equals("y")){
            ConsoleHelper.writeMessage("Thank you for using this cashing machine. Good luck.");
        }else{

        }

    }
}
