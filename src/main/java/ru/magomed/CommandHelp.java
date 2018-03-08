package ru.magomed;

public class CommandHelp implements Command {
    @Override
    public void execute() {
        System.out.println(Config.HELP);
    }
}
