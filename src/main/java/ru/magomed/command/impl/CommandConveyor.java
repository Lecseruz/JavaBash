package ru.magomed.command.impl;

import ru.magomed.command.api.Command;

import java.util.LinkedList;
import java.util.Queue;

public class CommandConveyor implements Command {

    private Queue<Command> queue = new LinkedList<>();

    private boolean flag = true;

    @Override
    public boolean execute() {
        boolean success = true;
        while (!queue.isEmpty()) {
            if (!queue.poll().execute()) {
                success = false;
            }
        }
        return success;
    }

    @Override
    public boolean isRequiredSuccess() {
        return false;
    }

    public void add(Command command) {
        if (flag) {
            queue.add(command);
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
