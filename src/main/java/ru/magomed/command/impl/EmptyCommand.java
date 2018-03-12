package ru.magomed.command.impl;

import ru.magomed.command.api.Command;

public class EmptyCommand implements Command{
    private boolean flag = false;

    @Override
    public boolean execute() {
        return false;
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
