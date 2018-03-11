package ru.magomed.command.impl;

import ru.magomed.command.api.Command;

public class EmptyCommand implements Command{
    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public boolean isRequiredSuccess() {
        return false;
    }
}
