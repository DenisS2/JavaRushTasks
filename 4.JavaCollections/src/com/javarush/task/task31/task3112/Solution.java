package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("http://www.xeroxscanners.com/downloads/Manuals/XMS/PDF_Converter_Pro_Quick_Reference_Guide.RU.pdf", Paths.get("D:\\SecretFolder"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        if (urlString == null || downloadDirectory == null)
            return null;
        URL url = new URL(urlString);
        InputStream inputStream = url.openStream();

        Path tempFile = Files.createTempFile("temp-",".tmp");
        Files.copy(inputStream, tempFile);
        String fileName = urlString.substring(urlString.lastIndexOf("/"));
        fileName = downloadDirectory.toString() + fileName;
        if (Files.notExists(downloadDirectory))
            Files.createDirectories(downloadDirectory);
        if (Files.isDirectory(downloadDirectory))
            downloadDirectory = Paths.get(fileName);
        if (Files.notExists(downloadDirectory))
        Files.move(tempFile, downloadDirectory);

        return downloadDirectory;
    }
}
