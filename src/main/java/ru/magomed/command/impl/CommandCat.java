package ru.magomed.command.impl;

import ru.magomed.Directory;
import ru.magomed.command.api.Command;
import ru.magomed.common.*;
import ru.magomed.exception.NotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CommandCat implements Command {

    private Path file;
    private Path toFile = null;
    private String sign = "";

    public CommandCat(String path) {
        this.file = Paths.get(
                PathResolve.cdPath(
                        Directory.getInstance().getPath(),
                        path).toString());
    }

    public CommandCat(String from, String to) {
        this.file = Paths.get(
                PathResolve.cdPath(
                        Directory.getInstance().getPath(),
                        from).toString());
        Path file_ = Paths.get(to.substring(1, to.length()));
        this.toFile = Paths.get(
                PathResolve.cdPath(
                        Directory.getInstance().getPath(),
                        file_.toString()).toString());
        this.sign = String.valueOf(to.charAt(0));
    }

    @Override
    public boolean execute() {
        try {
            if (Files.notExists(file)) {
                throw new NotFoundException();
            }
            if (toFile == null && sign.isEmpty()) {
                for (String line : Files.readAllLines(file)) {
                    System.out.println(line);
                }
            } else {
                if (sign.equals(">")) {
                    FileUtils.writeFile(toFile, Files.readAllLines(file).iterator());
                } else {
                    System.out.println(NamesCommands.SIGN + Messages.NOT_FOUND);
                    return false;
                }
            }
            return true;
        } catch (NotFoundException e) {
            System.out.println(NamesCommands.CAT + Messages.NOT_FOUND + file.toString());
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

    @Override
    public void setRequiredSuccess(boolean flag) {

    }
}
