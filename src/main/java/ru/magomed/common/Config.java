package ru.magomed.common;

import java.nio.file.CopyOption;
import java.nio.file.StandardCopyOption;

public class Config {

    public static final int MIN_LINES_FILE = 10;

    public static final CopyOption[] OPTIONS = new CopyOption[]{
            StandardCopyOption.REPLACE_EXISTING,
            StandardCopyOption.COPY_ATTRIBUTES
    };

    public static final String MKDIR = "mkdir";

    public static final String LS = "ls";

    public static final String HELP = "help";

    public static final String EXIT = "exit";

    public static final String CP = "cp";

    public static final String CD = "cd";

    public static final String CAT = "cat";

    public static final String PWD = "pwd";

    public static final String TAIL = "tail";

    public static final String TOUCH = "touch";


}
