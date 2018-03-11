package ru.magomed.command.impl;

import ru.magomed.Directory;
import ru.magomed.command.api.Command;

public class CommandPWD implements Command {

    @Override
    public boolean execute() {
        System.out.println(Directory.getInstance().getPath());
        return true;
    }

    @Override
    public boolean isRequiredSuccess() {
        return false;
    }
}
