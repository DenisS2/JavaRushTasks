package com.javarush.task.task31.task3113;



/*
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Stack;


Что внутри папки?

/*public class Solution {

    public static void main(String[] args) throws IOException {
        //System.out.println("Введите полный путь к папке");
        Path path;
        try(Scanner scanner = new Scanner(System.in)){
            path= Paths.get(scanner.nextLine());
        }
        if (!Files.isDirectory(path)){
            System.out.println(path.toString()+" - не папка");
            return;
        }

        int countDirectories=0;
        int countFiles=0;
        long dir=0;

        Stack<String> stack = new Stack<>();
        String parent=path.toString()+"\\";
        String[] files= path.toFile().list();
        for (int i = 0; i < files.length ; i++) {
            stack.push(parent+files[i]);
        }
        Path file;
        while (!stack.empty()){
            file=Paths.get(stack.pop());
            if (Files.isDirectory(file)){
                countDirectories++;
                parent=file.toString()+"\\";
                String[] tmp= file.toFile().list();
                for (int i = 0; i < tmp.length; i++) {
                    stack.push(parent+tmp[i]);
                }
            }
            else if (Files.isRegularFile(file)){
                countFiles++;
                dir=dir+Files.size(file);
            }
        }
        System.out.println("Всего папок - "+ countDirectories);
        System.out.println("Всего файлов - "+ countFiles);
        System.out.println("Общий размер - "+dir);

        //System.out.println(Files.getAttribute(path, "basic:size", java.nio.file.LinkOption.NOFOLLOW_LINKS));


    }
}*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

/*
Что внутри папки?
Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.
Первым делом считай путь к папке с консоли.
Если введенный путь не является директорией — выведи «[полный путь] — не папка» и заверши работу.
Затем посчитай и выведи следующую информацию:
Всего папок — [количество папок в директории]
Всего файлов — [количество файлов в директории и поддиректориях]
Общий размер — [общее количество байт, которое хранится в директории]
Используй только классы и методы из пакета java.nio.
*/
public class Solution {
    static long totalFolders = 0;
    static long totalFiles = 0;
    static long totalSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        String pathStr = conReader.readLine();
        conReader.close();

        Path pth = Paths.get(pathStr);

        if (!Files.isDirectory(pth)) {
            System.out.printf(pth.toAbsolutePath().toString() + " - не папка");
            return;
        }

        Files.walkFileTree(pth, new Visitior());

        System.out.println("Всего папок - " + (totalFolders-1));
        System.out.println("Всего файлов - " + totalFiles);
        System.out.println("Общий размер - " + totalSize);

    }

    private static class Visitior extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            totalFolders += 1;
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            totalFiles += 1;
            totalSize = totalSize + attrs.size();
            return CONTINUE;
        }
    }
}