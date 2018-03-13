package ru.magomed.common;

public class Messages {

    private Messages() {

    }

    public static final String HELP =
            "\t help - вывод всех поддерживаемых команд с небольшим описанием.\n" +
            "\t cd <directory name> - переход в указанную директорию, так же можно указать путь в директорию\n" +
            "\t pwd - отображение директории в котором находится эмулятор.\n" +
            "\t ls - отображение списка файлов и директорий в текущей папке и их владельцев.\n" +
            "\t mkdir <directory name> - создание дитектории с указанным именем.\n" +
            "\t touch <file name> - создание файла с указанным именем или обновление last modified данного файла если он уже создан.\n" +
            "\t cat <file name> - чтение файла и вывод содержания.\n" +
            "\t tail <option> <file name> - вывод последних (по умолчанию 10) строк файла. <option> -n число строк. \n" +
            "\t cp <option> <file/directory name>  <file/directory name>  - копирование файла или директории. <option> -f будет производится рекурсивное копирование директории.\n" +
            "\t exit - завершение работы эмулятора.";

    public static final String NOT_FOUND = " does not exist ";

    public static final String EXIST = " directory already exist ";

    public static final String NOT_A_DIRECTORY = " Not a directory ";

    public static final String ERROR = " error args ";
}
