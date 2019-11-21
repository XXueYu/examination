package com.xiao.utils;

import java.util.Scanner;

public class Arr {
    //从键盘录入一个数组
    public static int[] getArr(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] ss = s.split(" ");
        int len = ss.length;
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            arr[i] = Integer.parseInt(ss[i]);
        }
        return arr;
    }

    //随机生成指定长度的数组,随机数范围0-99
    public static int[] generateArrRandom(int len){
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            arr[i] = (int)(Math.random()*100);
        }
        return arr;
    }

    //随机生成指定大小的二维数组，随机数范围0-99
    public static int[][] generateMatrixRandom(int row,int cols){
        int[][] matrix = new int[row][cols];
        for(int i=0;i<row;i++){
            matrix[i] = generateArrRandom(cols);
        }
        return matrix;
    }

    //输出数组
    public static void printArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void printArr(char[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void printArr(Object[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
