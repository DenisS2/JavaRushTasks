package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int startX, startY, endX, endY, count=0;
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a.length ; j++) {
                if (a[i][j]==1){
                    startX=i;
                    startY=j;
                    endX=startX;
                    endY=startY;
                    while (a[endX][endY] == 1 && endX != a.length - 1) endX++;
                    if (a[endX][endY] != 1) endX--;
                    while (a[endX][endY]==1&&endY!=a.length-1) endY++;
                    if (a[endX][endY] != 1) endY--;
                    count++;
                    for (int k = startX; k <=endX ; k++) {
                        for (int l = startY; l <=endY ; l++) {
                            a[k][l]=0;
                        }
                    }
                }
            }
        }

        return count;
    }
}
