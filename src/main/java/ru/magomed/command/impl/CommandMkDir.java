package ru.magomed.command.impl;

import ru.magomed.Directory;
import ru.magomed.command.api.Command;
import ru.magomed.common.NamesCommands;
import ru.magomed.common.Options;
import ru.magomed.common.Messages;
import ru.magomed.common.PathResolve;
import ru.magomed.exception.AlreadyExistException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CommandMkDir implements Command {

    private boolean flag = false;

    private Path path;

    public CommandMkDir(String nameDir) {
        this.path = PathResolve.cdPath(Directory.getInstance().getPath(), nameDir);
    }

    @Override
    public boolean execute() {
        try {
            if (Files.exists(path)) {
                throw new AlreadyExistException();
            }
            Files.createDirectories(path);
            return true;
        } catch (AlreadyExistException e) {
            System.out.println(NamesCommands.MKDIR + Messages.EXIST + path.getFileName());
            return false;
        } catch (IOException e) {
            //fail to create directory
            e.printStackTrace();
            return false;
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
