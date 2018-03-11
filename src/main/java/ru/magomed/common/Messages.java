package ru.magomed.common;

public class Messages {

    private Messages() {

    }

    public static final String HELP = "\t- help - вывод всех поддерживаемых команд с небольшим описанием.\n" +
            "\t- cd <directory name> - переход в указанную директорию.\n" +
            "\t- ls - отображение списка файлов и директорий в текущей папке. Опционально - с аттрибутами файлов и/или их владельцев.\n" +
            "\t- mkdir <directory name> - создание дитектории с указанным именем.\n" +
            "\t- touch <file name> - создание файла с указанным именем или обновление last modified данного файла если он уже создан.\n" +
            "\t- cat <file name> - чтение файла и вывод содержания.\n" +
            "\t- tail <file name> - вывод последних (по умолчанию 10) строк файла.\n" +
            "\t- cp <file/directory name> - копирование файла или директории. Опционально - с возможностью указания флага рекурсивного копирования.\n" +
            "\t- exit - завершение работы эмулятора.\n";

    public static final String NOT_FOUND = " Does not exist ";

    public static final String EXIST = " Directory already exist ";

    public static final String NOT_A_DIRECTORY = " Not a directory ";

    public static final String ERROR = " error args ";
}
