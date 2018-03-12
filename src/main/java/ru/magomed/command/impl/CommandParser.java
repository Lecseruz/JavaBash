package ru.magomed.command.impl;

import ru.magomed.command.api.Command;
import ru.magomed.common.NamesCommands;
import ru.magomed.common.Options;
import ru.magomed.common.Messages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CommandParser {

    private CommandParser() {
    }

    public static Command parseCommand(String commandLine) {
        List<String> commands = Arrays.asList(commandLine.split(" "));
        CommandConveyor commandConveyor = new CommandConveyor();

        Iterator<String> iterator = commands.iterator();
        while (iterator.hasNext()) {
            String nameCommand = iterator.next();
            Command command = null;
            StringBuilder state = new StringBuilder();
            List<String> list = readArgs(iterator, state);

            switch (nameCommand) {
                case NamesCommands.HELP: {
                    if (list.size() == 0) {
                        command = new CommandHelp();
                    } else {
                        command = new EmptyCommand();
                        System.out.println(NamesCommands.HELP + Messages.ERROR);
                    }
                    break;
                }
                case NamesCommands.CD: {
                    if (list.size() == 1) {
                        command = new CommandCD(list.get(0));
                    } else {
                        command = new EmptyCommand();
                        System.out.println(NamesCommands.CD + Messages.ERROR);
                    }
                    break;
                }
                case NamesCommands.LS: {
                    if (list.size() == 0) {
                        command = new CommandLS();
                    } else {
                        command = new EmptyCommand();
                        System.out.println(NamesCommands.LS + Messages.ERROR);
                    }
                    break;
                }
                case NamesCommands.EXIT: {
                    if (list.size() == 0) {
                        command = new CommandExit();
                    } else {
                        command = new EmptyCommand();
                        System.out.println(NamesCommands.EXIT + Messages.ERROR);
                    }
                    break;
                }
                case NamesCommands.MKDIR: {
                    if (list.size() == 1) {
                        command = new CommandMkDir(list.get(0));
                    } else {
                        command = new EmptyCommand();
                        System.out.println(NamesCommands.MKDIR + Messages.ERROR);
                    }
                    break;
                }
                case NamesCommands.PWD: {
                    if (list.size() == 0) {
                        command = new CommandPWD();
                    } else {
                        command = new EmptyCommand();
                        System.out.println(NamesCommands.PWD + Messages.ERROR);
                    }
                    break;
                }
                case NamesCommands.TOUCH: {
                    if (list.size() == 1) {
                        command = new CommandTouch(list.get(0));
                    } else {
                        command = new EmptyCommand();
                        System.out.println(NamesCommands.TOUCH + Messages.ERROR);
                    }
                    break;
                }
                case NamesCommands.CAT: {
                    if (list.size() == 2 || list.size() == 1) {
                        if (list.size() == 1) {
                            command = new CommandCat(list.get(0));
                        } else {
                            command = new CommandCat(list.get(0), list.get(1));
                        }
                    } else {
                        command = new EmptyCommand();
                        System.out.println(NamesCommands.CAT + Messages.ERROR);
                    }
                    break;
                }
                case NamesCommands.TAIL: {
                    if (list.size() <= 4 && list.size() >= 1) {
                        switch (list.size()) {
                            case 1: {
                                command = new CommandTail(list.get(0), Options.MIN_LINES_FILE);
                                break;
                            }
                            case 2: {
                                command = new CommandTail(list.get(0), Options.MIN_LINES_FILE, list.get(1));
                                break;
                            }
                            case 3: {
                                if (list.get(0).equals("-n")) {
                                    command = new CommandTail(list.get(2), Integer.parseInt(list.get(1)));
                                }
                                break;
                            }
                            case 4: {
                                if (list.get(0).equals("-n")) {
                                    command = new CommandTail(list.get(2), Integer.parseInt(list.get(1)), list.get(3));
                                }
                                break;
                            }
                            default:
                                break;
                        }
                    } else {
                        command = new EmptyCommand();
                        System.out.println(NamesCommands.TAIL + Messages.ERROR);
                    }
                    break;
                }
                case NamesCommands.CP: {
                    if (list.size() == 2) {
                        command = new CommandCP(list.get(0), list.get(1));
                    } else {
                        command = new EmptyCommand();
                        System.out.println(NamesCommands.CP + Messages.ERROR);
                    }
                    break;
                }
                default: {
                    command = new EmptyCommand();
                    System.out.println(Messages.NOT_FOUND);
                    break;
                }
            }
            if (state.toString().equals("&&")) {
                command.setRequiredSuccess(true);
            }
            commandConveyor.add(command);
        }
        return commandConveyor;
    }

    private static List<String> readArgs(Iterator<String> iterator, StringBuilder state) {
        List<String> list = new ArrayList<>();
        if (iterator.hasNext()) {
            String next = iterator.next();

            while (iterator.hasNext() && (!next.equals("&&")) && !next.equals("||")) {
                list.add(next);
                next = iterator.next();
            }
            if (iterator.hasNext()) {
                state.append(next);
            } else {
                list.add(next);
            }
        }
        return list;
    }
}
