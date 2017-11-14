package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;

/*
Проход по дереву файлов
+ 1. На вход метода main подаются два параметра.
Первый — path — путь к директории, второй — resultFileAbsolutePath — имя файла, который будет содержать результат.
+ 2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
+ 2.1. Если у файла длина в байтах больше 50, то удалить его (используй метод FileUtils.deleteFile).
+ 2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
+ 2.2.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
+ 2.2.2. Переименовать resultFileAbsolutePath в ‘allFilesContent.txt‘ (используй метод FileUtils.renameFile).
2.2.3. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять «n«.
Все файлы имеют расширение txt.
*/

public class Solution {
    private static ArrayList<File> fileList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        try (FileOutputStream fileOutputStream = new FileOutputStream(allFilesContent)) {

            fillFileList(path.getPath());
            fileList.sort(new FileNameComparator());

            for (File file : fileList) {
                FileInputStream fileInputStream = new FileInputStream(file);
                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(fileInputStream.read());
                }
                fileOutputStream.write(System.lineSeparator().getBytes());
                fileOutputStream.flush();

                fileInputStream.close();
            }
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }


    //Рекурсивно пробегаем поддиректории и заполняем список файлов
    private static void fillFileList(String path) {
        File[] files = new File(path).listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                fillFileList(file.getAbsolutePath());
                continue;
            }
            if (file.length() > 50)
                FileUtils.deleteFile(file);
            else
                fileList.add(file);
        }
    }
}

//Компаратор для сравнения
class FileNameComparator implements Comparator<File> {
    public int compare(File first, File second) {
        return first.getName().compareTo(second.getName());
    }
}

/*package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;



Проход по дереву файлов

public class Solution {

    private static ArrayList<File> paths = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            return;
        }



            File dir = new File(args[0]);
            File[] file = dir.listFiles();
            addFiles(file);
            for (int i = paths.size() - 1; i >= 0; i--) {
                if (paths.get(i).length() > 50) {
                    FileUtils.deleteFile(paths.get(i));
                    paths.remove(i);
                }
            }
            for (int i = 0; i < paths.size(); i++) {
                for (int j = 0; j < paths.size() - 1; j++) {
                    if (paths.get(i).getName().compareTo(paths.get(j).getName()) < 0) {
                        File f = paths.get(i);
                        paths.set(i, paths.get(j));
                        paths.set(j, f);
                    }
                }
            }
        File resultFileAbsolutePath = new File(args[1]);
        //if (!resultFileAbsolutePath.exists()){
        //    return;
        //}
        File parent = new File(resultFileAbsolutePath.getParent()+"/allFilesContent.txt");
        //parent = parent + "allFilesContent.txt";
        FileUtils.renameFile(resultFileAbsolutePath, parent);
        //File allFilesContent = new File(parent);
        try (FileOutputStream out = new FileOutputStream(parent)) {
            for (File f : paths) {
                try (FileInputStream input = new FileInputStream(f)) {
                    byte[] b = new byte[input.available()];
                    input.read(b);
                    out.write(b);
                    out.write(System.lineSeparator().getBytes());//"\n".getBytes());
                    //input.close();
                }
            }
            //out.close();
        }
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    public static void addFiles(File[] files) {
        for (File f : files) {
            if (f.isDirectory()) {
                File[] f1 = f.listFiles();//new File(f.getPath());
                addFiles(f1);
            } else paths.add(f);
        }
    }
}
*/