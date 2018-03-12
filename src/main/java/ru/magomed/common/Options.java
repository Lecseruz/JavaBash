package ru.magomed.common;

import java.nio.file.CopyOption;
import java.nio.file.OpenOption;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class Options {

    public static final int MIN_LINES_FILE = 10;

    public static final CopyOption[] OPTIONS = new CopyOption[]{
            StandardCopyOption.REPLACE_EXISTING,
            StandardCopyOption.COPY_ATTRIBUTES
    };

    public static final OpenOption[] OPEN_OPTIONS = new OpenOption[]{
            StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING,
            StandardOpenOption.WRITE
    };
}
