package ru.magomed.command.impl;

import ru.magomed.Directory;
import ru.magomed.command.api.Command;
import ru.magomed.common.Config;
import ru.magomed.common.Messages;
import ru.magomed.exception.NotFoundException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommandCat implements Command {

    private String name;

    public CommandCat(String name) {
        this.name = name;
    }

    @Override
    public boolean execute() {
        Path filePath = Paths.get(Directory.getInstance().getPath(), name);

        try {
            if (Files.notExists(filePath)) {
                throw new NotFoundException();
            }
            for (String line : Files.readAllLines(filePath)) {
                System.out.println(line);
            }
            return true;
        } catch (NotFoundException e) {
            System.out.println(Config.CAT + Messages.NOT_FOUND);
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean isRequiredSuccess() {
        return false;
    }
}
