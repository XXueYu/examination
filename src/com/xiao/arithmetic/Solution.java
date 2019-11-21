package com.xiao.arithmetic;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int from = sc.nextInt();
        int to = sc.nextInt();
        int[] arr = new int[to];
        arr[0] = 1;
        for (int i = 1; i < to; i++) {
            arr[i] = arr[i - 1] + i + 1;
        }
        int ret = solve(to,arr)-solve(from,arr);
        System.out.println(ret);
    }

    public static int solve(int r,int[] arr) {
        if (r <= 1)
            return 0;
        else
            return solve(r - 1,arr) + isDevide(r,arr);
    }
    public static int isDevide(int r,int[] arr){
        if(arr[r-1]%3 == 0)
            return 1;
        else
            return 0;
    }
}
