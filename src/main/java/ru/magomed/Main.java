package ru.magomed;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            CommandParser.parseCommand(scanner.nextLine()).execute();
        }
    }
}
