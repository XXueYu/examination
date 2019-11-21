package com.xiao.arithmetic.dynamicPlan;

import com.xiao.utils.Arr;

public class SubArray {
    public static void main(String[] args) {
        int[] arr = Arr.getArr();
        int result = maxSumContiguous(arr);
        System.out.println("\n最大子数组和为"+result);
    }

    public static int maxSumContiguous(int[] arr){
        int maxSum = 0;
        if(arr.length>0){
            int[] temp = new int[6];
            for(int i=0;i<arr.length;i++){
                if(arr[i]<0 ){
                    if(temp[5]==0){
                        temp[3] += arr[i];
                    }else {
                        merge(temp,i);
                    }
                }
                else {
                    if(temp[0] == 0 && temp[2]==0){//最开始遇到非负数
                        temp[0] += arr[i];
                        temp[1] = i;
                        temp[2] = i;
                    }else {
                        if(i == temp[2]+1){//连续，直接累加
                            temp[0] += arr[i];
                            temp[2] = i;
                        }else {//不连续，加到右侧一堆
                            if(temp[4]==0){
                                temp[5] = i;
                            }
                            temp[4] +=arr[i];
                            if(temp[4]>=temp[0]){//判断是否要合并的时机
                                merge(temp,i);
                            }
                        }
                    }
                }
            }
            System.out.println("子数组起始index:"+temp[1]+",终止index："+temp[2]);
            maxSum = temp[0];
        }
        return maxSum;
    }
    public static void merge(int[] temp,int t){
        if(temp[3]+temp[0]>0){
            temp[0] += temp[3]+temp[4];
            temp[2] = t;
            reinit(temp);
        }else {
            temp[0] = temp[4];
            temp[1]= temp[5];
            temp[2] = t;
            reinit(temp);
        }
    }

    public static void reinit(int[] arr){
        arr[3] = 0;
        arr[4] = 0;
        arr[5] = 0;
    }
}
