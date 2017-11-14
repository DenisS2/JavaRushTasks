package com.javarush.task.task22.task2209;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/*
Составить цепочку слов
*/
/*public class Solution {

    private static ArrayList<String> resultList = new ArrayList<String>();
    private static ArrayList<String> list;
    private static int step = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "d://3.txt";//sc.nextLine(); //"d://3.txt";//
        sc.close();
        String s = "";
        try {
            Scanner in = new Scanner(new File(fileName));
            while (in.hasNext())
                s += in.nextLine() + ' ';
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        String[] sa = s.split(" ");
        //...
        StringBuilder result = getLine(sa);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        StringBuilder builder = new StringBuilder();
        if (words==null) return builder;
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<StringBuilder> builders = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals("")&& !words[i].equals("") )
            list.add(words[i]);
        }
        if (list.size()==0) return builder;

        Collections.sort(list);
        builder.append(list.get(0)+" ");
        list.remove(0);
        int size=list.size();
        for (int j=0; j<size; j++){
            for (int i = 0; i < list.size() ; i++) {
            int p = builder.charAt(builder.length() - 2);//words[i].charAt(words[i].length()-1);
            int v = list.get(i).charAt(0);
            if (p==v|| p+32==v || p==v+32) {

                builder.append(list.get(i) + " ");
                list.remove(i);
            }
            }
        }
        builder.deleteCharAt(builder.length()-1);


        return builder;
    }
}*/

    public class Solution {
        private static ArrayList<String> resultList = new ArrayList<String>();
        private static ArrayList<String> list;
        private static int step = 0;

        public static void main(String[] args) throws IOException {

            //Читаем файл
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            //String fileName = "D:\\JavaProjects\\IO\\input.txt";
            if (fileName == null) System.exit(1);
            reader.close();
            Path path = Paths.get(fileName);
            List<String> lines = Files.readAllLines(path, Charset.forName("utf-8"));
            String[] words;
            if (!lines.isEmpty()) {
                words = lines.get(0).split(" ");
            } else words = null;

            //Решаем задачу. Принимаем, что во входной последовательности слов ОБЯЗАТЕЛЬНО будет цепочка, включающая все доступные слова
            StringBuilder result = getLine(words);

            //Ответ на консоль
            System.out.println(result.toString());
        }

        public static StringBuilder getLine(String... words) {
            // Проверка не некорректные входные условия метода
            if ((words == null) || (words.length == 0)) return new StringBuilder();

            StringBuilder result = new StringBuilder();


            list = new ArrayList<>(Arrays.asList(words));

            // Пускаем один цикл по всем возможным началам цепочки. Если хоть 1 цепочку находим - завершаем
            for (int k = 0; k < list.size(); k++) {
                if (resultList.size() == Solution.list.size()) break;
                resultList.clear();
                resultList.add(list.get(k));
                ArrayList<String> newList = new ArrayList<String>(list);
                newList.remove(k);

                //Запускаем рукурсию для выбранного начала цепочки
                recurFind(newList, 0, resultList.get(0));
            }

            //Выводим найденный результат
            boolean isFirst = true;
            for (String entry : resultList) {
                if (!isFirst) {
                    result.append(" ");
                } else isFirst = false;
                result.append(entry);

            }
            return result;
        }

        private static void recurFind(ArrayList<String> list, int index, String lastWordInChain) {
            //Выполняем рекурсивный поиск цепочки. Если найден конечный элемент цепочки, но использованы еще не все слова, откатываемся на один шаг сбора цепочки назад
            for (int j = 0; j < list.size(); j++) {
                // Учитываем различный регистр букв
                if (String.valueOf(lastWordInChain.charAt(lastWordInChain.length() - 1)).toLowerCase().equals(String.valueOf(list.get(j).charAt(0)).toLowerCase())) {
                    step++;
                    if (resultList.size() > step) resultList.set(step, list.get(j));
                    else resultList.add(list.get(j));
                    String result = list.get(j);
                    ArrayList<String> listNew = new ArrayList<String>(list);
                    listNew.remove(j);
                    recurFind(listNew, 0, result);
                    //Проверяем, если рекурсия не смогла собрать цепочку до конца, то пробуем найти на этом же уровне рекурсии другой элемент цепочки
                    // т.е., например, для списка слов КА АА АБ АВ для цепочки КА АА на следующем месте может стоять как АБ, так и АВ (следующее слово)
                    if (resultList.size() != Solution.list.size()) {
                        step--;
                    } else break;
                }
            }
        }
    }

