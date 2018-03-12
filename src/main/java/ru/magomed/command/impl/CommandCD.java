package ru.magomed.command.impl;

import ru.magomed.Directory;
import ru.magomed.command.api.Command;
import ru.magomed.common.NamesCommands;
import ru.magomed.exception.NotDirectoryException;
import ru.magomed.common.Messages;
import ru.magomed.common.PathResolve;
import ru.magomed.exception.NotFoundException;

import java.nio.file.Files;
import java.nio.file.Path;

public class CommandCD implements Command {

    private boolean flag = true;
    private String directory;

    public CommandCD(String directory) {
        this.directory = directory;
    }

    @Override
    public boolean execute() {
        Path currPath = PathResolve.cdPath(Directory.getInstance().getPath(), directory);
        try {
            if (!Files.isDirectory(currPath)) {
                throw new NotDirectoryException();
            }
            if (Files.notExists(currPath)) {
                throw new NotFoundException();
            }
            Directory.getInstance().setPath(currPath.toString());
            return true;
        }catch (NotFoundException e){
            System.out.println(NamesCommands.CD + Messages.NOT_FOUND);
            return false;
        }
        catch (NotDirectoryException e){
            System.out.println(NamesCommands.CD + Messages.NOT_A_DIRECTORY + currPath.getFileName());
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
