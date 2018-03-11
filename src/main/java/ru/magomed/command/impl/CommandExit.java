package ru.magomed.command.impl;

import ru.magomed.command.api.Command;

public class CommandExit implements Command {
    @Override
    public boolean execute() {
        System.exit(0);
        return true;
    }

    @Override
    public boolean isRequiredSuccess() {
        return false;
    }
}
