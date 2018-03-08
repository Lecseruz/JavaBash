package ru.magomed;

import javax.print.DocFlavor;

public final class Directory {

    private static Directory _instance = null;

    private String path;

    private Directory(String path){
        this.path = path;
    }

    public static synchronized Directory getInstance() {
        if (_instance == null)
            _instance = new Directory(System.getProperty("user.dir"));
        return _instance;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
