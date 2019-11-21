package com.xiao.arithmetic;

import com.xiao.utils.Arr;

public class Search {
    //二维数组中查找
    public static boolean existMatrix(int target,int[][] array){
        int column = array[0].length;
        int row = array.length;
        for(int i = row-1,j=0;i>=0&&j<column;){//思路：矩阵整体是有序的，左下角是关键选点，因为向上向右数的大小变化是反向的
            if(target == array[i][j])
                return true;
            if(target < array[i][j])
                i--;
            else
                j++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = Arr.generateMatrixRandom(4,4);
        boolean flag = existMatrix(5,array);
        System.out.println(flag);
    }
}
