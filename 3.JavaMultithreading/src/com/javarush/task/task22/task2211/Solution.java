package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
            /*FileInputStream input = new FileInputStream(args[0]);
            FileOutputStream output = new FileOutputStream(args[1]);
            Charset utf8 = Charset.forName("UTF-8");
            byte[] buffer = new byte[input.available()];
            input.read(buffer);
            String s = new String(buffer, utf8);
            buffer = s.getBytes();
            output.write(buffer,0, buffer.length);
            input.close();
            output.close();*/

        String fileName_Windows1251 = args[0];
        String fileName_UTF8 = args[1];

        FileInputStream fis = new FileInputStream(fileName_Windows1251);
        byte[] buff_fis = new byte[fis.available()];
        fis.read(buff_fis);
        fis.close();

        String s = new String(buff_fis,"UTF-8");

        FileOutputStream fos = new FileOutputStream(fileName_UTF8);
        fos.write(s.getBytes("windows-1251"));
        fos.close();
    }
}

