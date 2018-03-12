package ru.magomed.command.impl;

import ru.magomed.command.api.Command;
import ru.magomed.common.*;
import ru.magomed.exception.NotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommandCP implements Command {


    boolean flag = false;
    /**
     * Путь откуда копировать
     */
    private Path from;

    /**
     * Куда копировать
     */
    private Path to;

    public CommandCP(String srcPath, String targetPath) {
        this.from = Paths.get(srcPath);
        this.to = Paths.get(targetPath);
    }

    @Override
    public boolean execute() {
        try {
            if (Files.exists(from) && Files.exists(to)) {
                throw new NotFoundException();
            }
            Files.copy(from, to, Options.OPTIONS);
//            if (Files.isDirectory(from)) {
//                FolderUtils.copyFolder(new File(from.toString()), new File(to.toString()));
//            }
            Files.walkFileTree(from, new CopyDirVisitor(from, to, Options.OPTIONS));
            return true;
        } catch (NotFoundException e) {
            System.out.println(NamesCommands.CP + Messages.NOT_FOUND);
            return false;
        } catch (IOException e) {
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
