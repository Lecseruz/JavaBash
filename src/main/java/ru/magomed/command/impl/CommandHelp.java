package ru.magomed.command.impl;

import ru.magomed.command.api.Command;
import ru.magomed.common.Messages;

public class CommandHelp implements Command {
    @Override
    public boolean execute() {
        System.out.println(Messages.HELP);
        return true;
    }

    @Override
    public boolean isRequiredSuccess() {
        return false;
    }
}
