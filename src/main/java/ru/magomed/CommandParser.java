package ru.magomed;

public class CommandParser {

    private CommandParser(){};
    public static Command parseCommand(String commandLine){
        String[] commands = commandLine.split("\\|\\|");
        //help||cat test.log
        CommandConveyor commandConveyor = new CommandConveyor();

        for (String command: commands) {
            String array[] = commandLine.split(" ");

            switch (array[0]) {
                case "help": {
                    commandConveyor.add(new CommandHelp());
                    break;
                }
                case "cd": {
                    CommandCD commandCD = new CommandCD();

                    commandConveyor.add(commandCD);
                    break;
                }
                case "ls": {
                    commandConveyor.add(new CommandLS());
                    break;
                }
                default:{
                    break;
                }
            }
        }

        return commandConveyor;

    }
}
