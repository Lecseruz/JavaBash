package ru.magomed.command.impl;

import ru.magomed.ArrayIterator;
import ru.magomed.command.api.Command;
import ru.magomed.common.Config;
import ru.magomed.common.Messages;

import java.util.ArrayList;
import java.util.List;

public class CommandParser {

    private CommandParser() {
    }

    public static Command parseCommand(String commandLine) {
        String[] commands = commandLine.split(" ");
        //help||cat test.log
        CommandConveyor commandConveyor = new CommandConveyor();

        ArrayIterator<String> iterator = new ArrayIterator<>(commands);
        while (iterator.hasNext()) {
            String command = iterator.next();
            List<String> list = readArgs(iterator);
            switch (command) {
                case Config.HELP: {
                    if (list.size() == 0) {
                        commandConveyor.add(new CommandHelp());
                    }else {
                        commandConveyor.add(new EmptyCommand());
                        System.out.println(Config.HELP + Messages.ERROR);
                    }
                    break;
                }
                case Config.CD: {
                    if (list.size() == 1) {
                        commandConveyor.add(new CommandCD(list.get(0)));
                    }else {
                        commandConveyor.add(new EmptyCommand());
                        System.out.println(Config.CD + Messages.ERROR);
                    }


                    break;
                }
                case Config.LS: {
                    if (list.size() == 0) {
                        commandConveyor.add(new CommandLS());
                    }else {
                        commandConveyor.add(new EmptyCommand());
                        System.out.println(Config.LS + Messages.ERROR);
                    }
                    break;
                }
                case Config.EXIT: {
                    if (list.size() == 0) {
                        commandConveyor.add(new CommandExit());
                    }else {
                        commandConveyor.add(new EmptyCommand());
                        System.out.println(Config.EXIT + Messages.ERROR);
                    }
                    break;
                }
                case Config.MKDIR: {
                    if (list.size() == 1) {
                        commandConveyor.add(new CommandMkDir(list.get(0)));
                    }else {
                        commandConveyor.add(new EmptyCommand());
                        System.out.println(Config.MKDIR + Messages.ERROR);
                    }
                    break;
                }
                case Config.PWD: {
                    if (list.size() == 0) {
                        commandConveyor.add(new CommandPWD());
                    }else {
                        commandConveyor.add(new EmptyCommand());
                        System.out.println(Config.PWD + Messages.ERROR);
                    }
                    break;
                }
                case Config.TOUCH: {
                    if (list.size() == 1) {
                        commandConveyor.add(new CommandTouch(list.get(0)));
                    }else {
                        commandConveyor.add(new EmptyCommand());
                        System.out.println(Config.TOUCH + Messages.ERROR);
                    }
                    break;
                }
                case Config.CAT: {
                    if (list.size() == 1) {
                        commandConveyor.add(new CommandCat(list.get(0)));
                    }else {
                        commandConveyor.add(new EmptyCommand());
                        System.out.println(Config.CAT + Messages.ERROR);
                    }
                    break;
                }
                case "&&": {
                    if (!commandConveyor.execute()) {
                        commandConveyor.setFlag(false);
                    }
                    break;
                }
                case "||": {
                    break;
                }
                case Config.TAIL: {
                    if (list.size() == 2 || list.size() == 1) {
                        if (list.size() == 1) {
                            commandConveyor.add(new CommandTail(list.get(0), Config.MIN_LINES_FILE));
                        } else {
                            commandConveyor.add(new CommandTail(list.get(0), Integer.parseInt(list.get(1))));
                        }
                    }else {
                        commandConveyor.add(new EmptyCommand());
                        System.out.println(Config.TAIL + Messages.ERROR);
                    }
                    break;
                }
                case Config.CP: {
                    if (list.size() == 2) {
                        commandConveyor.add(new CommandCP(list.get(0), list.get(1)));
                    }else {
                        commandConveyor.add(new EmptyCommand());
                        System.out.println(Config.CP + Messages.ERROR);
                    }
                    break;
                }
                default: {
                    commandConveyor.add(new EmptyCommand());
                    System.out.println(Messages.NOT_FOUND);
                    break;
                }
            }
        }
        return commandConveyor;
    }

    private static List<String> readArgs(ArrayIterator<String> iterator) {
        List<String> list = new ArrayList<>();
        if (iterator.get().equals("&&") || iterator.get().equals("||")){
            return list;
        }

        while (iterator.hasNext() && !(iterator.next().equals("&&")) && !(iterator.get().equals("||"))) {
            list.add(iterator.get());
        }


        if (iterator.get().equals("&&") || iterator.get().equals("||")){
            iterator.last();
        }
        return list;
    }
}
