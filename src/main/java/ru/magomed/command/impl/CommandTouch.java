package ru.magomed.command.impl;

import ru.magomed.Directory;
import ru.magomed.command.api.Command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class CommandTouch implements Command {

    private String name;

    public CommandTouch(String name) {
        this.name = name;
    }

    @Override
    public boolean execute() {
        Path newFilePath = Paths.get(Directory.getInstance().getPath(), name);
        if (!Files.exists(newFilePath)) {
            try {
                Files.createFile(newFilePath);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            try {
                Files.setLastModifiedTime(newFilePath, FileTime.from(LocalDateTime.now().getSecond(), TimeUnit.SECONDS));
                return true;
            }catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    @Override
    public boolean isRequiredSuccess() {
        return false;
    }
}
