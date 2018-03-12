package ru.magomed.command.impl;

import ru.magomed.Directory;
import ru.magomed.command.api.Command;
import ru.magomed.common.PathResolve;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class CommandTouch implements Command {

    private boolean flag = false;

    private Path file;

    public CommandTouch(String path) {
        Path file = Paths.get(path);
        this.file = Paths.get(
                PathResolve.cdPath(
                        Directory.getInstance().getPath(),
                        file.getParent().toString()).toString(),
                file.getFileName().toString());    }

    @Override
    public boolean execute() {
        if (!Files.exists(file)) {
            try {
                Files.createFile(file);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            try {
                Files.setLastModifiedTime(file, FileTime.from(LocalDateTime.now().getSecond(), TimeUnit.SECONDS));
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    @Override
    public boolean isRequiredSuccess() {
        return flag;
    }

    @Override
    public void setRequiredSuccess(boolean flag) {
        this.flag = flag;
    }
}
