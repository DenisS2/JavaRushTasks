package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        String resultFileName = args[0];
        int filePartCount = args.length - 1;
        String[] fileNamePart = new String[filePartCount];
        for (int i = 0; i < filePartCount; i++) {
            fileNamePart[i] = args[i + 1];
        }
        Arrays.sort(fileNamePart);

        List<FileInputStream> fisList = new ArrayList<>();
        for (int i = 0; i < filePartCount; i++) {
            fisList.add(new FileInputStream(fileNamePart[i]));
        }
        SequenceInputStream seqInStream = new SequenceInputStream(Collections.enumeration(fisList));
        ZipInputStream zipInStream = new ZipInputStream(seqInStream);
        FileOutputStream fileOutStream = new FileOutputStream(resultFileName);
        byte[] buf = new byte[1024 * 1024];
        while (zipInStream.getNextEntry() != null) {
            int count;
            while ((count = zipInStream.read(buf)) != -1) {
                fileOutStream.write(buf, 0, count);
            }
        }
        seqInStream.close();
        zipInStream.close();
        fileOutStream.close();
    }
}

     /*   Path resultFile = Paths.get(args[0]);
        ArrayList<InputStream> list = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            Path file = Paths.get(args[i]);
            list.add(new FileInputStream(file.toString()));
            }
            //Collections.sort(list.);
        SequenceInputStream sequenceInputStream = new SequenceInputStream(Collections.enumeration(list));
        ZipInputStream zipInputStream = new ZipInputStream(sequenceInputStream);
        FileOutputStream fileOutputStream = new FileOutputStream(resultFile.toString());
        ZipEntry zipEntry=zipInputStream.getNextEntry();*/

        //if (zipEntry !=null)
         //   Files.copy(zipInputStream, resultFile);

        //while (zipEntry  == null){
        //    byte[] buffer= new byte[zipInputStream.available()];
        //    zipInputStream.read(buffer);
        //    fileOutputStream.write(buffer);
        //    zipInputStream.closeEntry();
        //    zipEntry=zipInputStream.getNextEntry();
        //}

        //ZipInputStream zip = new ZipInputStream(new FileInputStream(pathToArchiveFile.toFile()));
        //ZipEntry zipEntry = zip.getNextEntry();
        //if (zipEntry !=null)
        //    Files.copy(zip, pathToResultFile);
        //zip.closeEntry();
        //zip.close();



        //sequenceInputStream.close();
        //zipInputStream.close();
        //fileOutputStream.close();


        //}
    //}

