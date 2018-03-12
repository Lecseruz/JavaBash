package ru.magomed.command.impl;

import ru.magomed.Directory;
import ru.magomed.command.api.Command;
import ru.magomed.common.*;
import ru.magomed.exception.NotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CommandTail implements Command {

    private Path file;

    private boolean flag = false;

    private String sign = "";

    private Path toFile = null;

    private int countLine;

    public CommandTail(String path, Integer countLine) {
        Path file = Paths.get(path);
        this.file = Paths.get(
                PathResolve.cdPath(
                        Directory.getInstance().getPath(),
                        path).toString());
        this.countLine = countLine;
    }

    public CommandTail(String from, int countLine, String to) {
        this.countLine = countLine;
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
                List<String> list = Files.readAllLines(file);
                if (list.size() < countLine) {
                    for (String line : list) {
                        System.out.println(line);
                    }
                } else {
                    for (int i = 0; i < countLine; ++i) {
                        System.out.println(list.get(list.size() - countLine + i));
                    }
                }
            } else {
                if (sign.equals(">")) {
                    List<String> list = Files.readAllLines(file);
                    if (list.size() < countLine) {
                        FileUtils.writeFile(toFile, Files.readAllLines(file).iterator());
                    } else {
                        FileUtils.writeFile(toFile, list.listIterator(list.size() - countLine));
                    }
                }else {
                    System.out.println(NamesCommands.SIGN + Messages.NOT_FOUND);
                    return false;
                }
            }
            return true;
        } catch (NotFoundException e) {
            System.out.println(NamesCommands.TAIL + Messages.NOT_FOUND);
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
