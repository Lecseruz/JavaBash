package ru.magomed.command.impl;

import ru.magomed.Directory;
import ru.magomed.command.api.Command;
import ru.magomed.common.PathResolve;

import java.io.File;

public class CommandLS implements Command {
    private boolean flag = false;

    @Override
    public boolean execute() {
        for (String childFile : PathResolve.fileList(Directory.getInstance().getPath())){
            System.out.println(childFile);
        }
        return true;
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
