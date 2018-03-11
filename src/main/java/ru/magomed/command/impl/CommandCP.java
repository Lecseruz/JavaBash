package ru.magomed.command.impl;

import ru.magomed.Directory;
import ru.magomed.command.api.Command;
import ru.magomed.common.Config;
import ru.magomed.common.FolderUtils;
import ru.magomed.common.Messages;
import ru.magomed.common.PathResolve;
import ru.magomed.exception.NotFoundException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommandCP implements Command {

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

    public CommandCP(String srcPath) {
        this.from = Paths.get(srcPath);
        this.to = PathResolve.cdPath(Directory.getInstance().getPath(), Paths.get(srcPath).getFileName().toString());
    }

    @Override
    public boolean execute() {
        try {
            if (Files.exists(from) && Files.exists(to)) {
                throw new NotFoundException();
            }
            Files.copy(from, to, Config.OPTIONS);
            if (Files.isDirectory(from)) {
                FolderUtils.copyFolder(new File(from.toString()), new File(to.toString()));
            }
            return true;
        } catch (NotFoundException e) {
            System.out.println(Config.CP + Messages.NOT_FOUND);
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
