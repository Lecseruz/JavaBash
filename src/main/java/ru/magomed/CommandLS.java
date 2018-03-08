package ru.magomed;

import java.io.File;

public class CommandLS implements Command {
    @Override
    public void execute() {
        File file = new File(Directory.getInstance().getPath());
//        file.isDirectory()

        for (String childFile : file.list()){
            System.out.println(childFile);
        }
    }
}
