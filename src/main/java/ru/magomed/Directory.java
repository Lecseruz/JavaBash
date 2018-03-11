package ru.magomed;

public final class Directory {

    private static Directory _instance = null;

    private String path;


    private Directory(String path) {
        this.path = path;
    }

    public static synchronized Directory getInstance() {
        if (_instance == null) {
            String path = System.getProperty("user.dir");
            _instance = new Directory(path);
        }
        return _instance;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
