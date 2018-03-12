package ru.magomed.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

public class FileUtils {
    public static void writeFile(Path file, Iterator iterator) throws IOException {
        StringBuilder builder = new StringBuilder();
        while (iterator.hasNext()){
            builder.append(iterator.next())
                    .append("\n");
        }
        Files.write(file, builder.toString().getBytes(), Options.OPEN_OPTIONS);
    }
}
