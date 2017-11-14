package com.javarush.task.task22.task2201;

/* 
Строки нитей или строковые нити? Вот в чем вопрос
*/
public class Solution {
    public static void main(String[] args) {
        new Solution();
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();
    }

    protected void initThreads() {
        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#");

        Thread.setDefaultUncaughtExceptionHandler(new ThisUncaughtExceptionHandler());

        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    public String getPartOfString(String string, String threadName) {
        int first;
        int last;
        String result="";
        try{
            first = string.indexOf('\t');
            last = string.lastIndexOf('\t');
            result = string.substring(first+1, last);
            //System.out.println("+++++++++++++++++++++++++++++++++++++");
            //System.out.println(result);
            //System.out.println("-------------------------------------");
            //wait();
        }/*catch (Exception e){
            switch (threadName) {
                case FIRST_THREAD_NAME:
                    throw new TooShortStringFirstThreadException();
                    //break;
                case SECOND_THREAD_NAME:
                    throw new TooShortStringSecondThreadException();
                    //break;
                default:
                    throw new RuntimeException();
                    //break;
            }
        }*/
        catch(Exception e)
        {
            if (FIRST_THREAD_NAME.equals(threadName)) throw new TooShortStringFirstThreadException(e);
            if (SECOND_THREAD_NAME.equals(threadName)) throw new TooShortStringSecondThreadException(e);
            Exception f = new RuntimeException();
            throw new RuntimeException(e);
        }
        return result;
    }
}
