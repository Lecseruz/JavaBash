package ru.magomed.command.impl;

import ru.magomed.command.api.Command;

public class CommandExit implements Command {
    private boolean flag = false;

    @Override
    public boolean execute() {
        System.exit(0);
        return true;
    }

    @Override
    public boolean isRequiredSuccess() {
        return flag;
    }

    @Override
    public void setRequiredSuccess(boolean flag) {
        this.flag = flag;
    }
}
