package ru.magomed.command.impl;

import ru.magomed.Directory;
import ru.magomed.command.api.Command;
import ru.magomed.common.Config;
import ru.magomed.common.Messages;
import ru.magomed.exception.NotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CommandTail implements Command {

    private Path filePath;

    private int countLine;

    public CommandTail(String name, Integer countLine) {
        this.filePath = Paths.get(Directory.getInstance().getPath(), name);
        this.countLine = countLine;
    }

    @Override
    public boolean execute() {
        try {
            if (Files.notExists(filePath)) {
                throw new NotFoundException();
            }
            List<String> list = Files.readAllLines(filePath);
            if (list.size() < countLine) {
                for (String line : list) {
                    System.out.println(line);
                }
            } else {
                for (int i = 0; i < countLine; ++i) {
                    System.out.println(list.get(list.size() - countLine + i));
                }
            }
            return true;
        } catch (NotFoundException e) {
            System.out.println(Config.TAIL + Messages.NOT_FOUND);
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
