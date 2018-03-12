package ru.magomed.command.impl;

import ru.magomed.Directory;
import ru.magomed.command.api.Command;

public class CommandPWD implements Command {
    private boolean flag = false;

    @Override
    public boolean execute() {
        System.out.println(Directory.getInstance().getPath());
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
