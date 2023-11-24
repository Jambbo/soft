package org.example.command;

import org.example.exception.InterruptOperationException;

interface Command {
     void execute() throws InterruptOperationException;
}
