package ru.magomed.common;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.List;

public class PathResolve {
    public static Path cdPath(String path1, String path2) {
        if (path2.charAt(0) == '/') {
            return Paths.get(path2);
        }

        String[] array = path2.split("/");
        Path path = Paths.get(path1);
        for (String element : array) {
            switch (element) {
                case "..": {
                    path = path.getParent();
                    break;
                }
                default: {
                    path = Paths.get(path.toString() + "/" + element);
                    break;
                }
            }
        }
        return path;
    }



    public static List<String> fileList(String directory) {
        List<String> fileNames = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
            for (Path path : directoryStream) {
                FileOwnerAttributeView view = Files.getFileAttributeView(path,
                        FileOwnerAttributeView.class);
                UserPrincipal userPrincipal = view.getOwner();
                fileNames.add(userPrincipal.getName() + "    " + path.getFileName().toString());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileNames;
    }

    public static void printFile(Path path) throws IOException {
        List<String> list = Files.readAllLines(path);

    }
}
