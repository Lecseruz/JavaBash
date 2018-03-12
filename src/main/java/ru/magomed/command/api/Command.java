package ru.magomed.command.api;

public interface Command {
    boolean execute();
    boolean isRequiredSuccess();
    void setRequiredSuccess(boolean flag);
}
