package ru.magomed;

import java.util.LinkedList;
import java.util.Queue;

public class CommandConveyor implements Command {
    private Queue<Command> queue = new LinkedList<>();

    @Override
    public void execute() {
        while (!queue.isEmpty()) {
            queue.poll().execute();
        }
    }

    public void add(Command command){
        queue.add(command);
    }


}
