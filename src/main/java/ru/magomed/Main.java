package ru.magomed;

import ru.magomed.command.impl.CommandParser;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(Directory.getInstance().getPath() + ">");

        while (scanner.hasNext()) {
            CommandParser.parseCommand(scanner.nextLine()).execute();
            System.out.print(Directory.getInstance().getPath() + ">");
        }
    }
}
