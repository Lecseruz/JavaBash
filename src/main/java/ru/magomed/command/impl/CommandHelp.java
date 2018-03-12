package ru.magomed.command.impl;

import ru.magomed.command.api.Command;
import ru.magomed.common.Messages;

public class CommandHelp implements Command {

    private boolean flag = false;

    @Override
    public boolean execute() {
        System.out.println(Messages.HELP);
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
