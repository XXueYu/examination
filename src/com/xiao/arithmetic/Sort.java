package com.xiao.arithmetic;

import com.xiao.utils.Arr;

import java.util.Scanner;

/**
 * 各种排序算法
 */
public class Sort {
    //负责输入、输出
    public static void main(String[] args) {
        //输入
        //int[] arr = Arr.generateArrRandom(10);
        int[] arr = Arr.getArr();
        int len = arr.length;
        Arr.printArr(arr);
        System.out.println();
        //排序
        //quickSort(arr,0,len-1);
        mergeSort(arr,0,len-1);
        //输出
        Arr.printArr(arr);
    }

    //快排
    public static void quickSort(int[] a,int start,int end){
        int temp = a[start];
        int left = start,right = end;
        while (left < right){
            //向左扫面
            while (a[right]>temp && left<right)
                right--;
            if(left == right) break;
            a[left]=a[right];
            left++;
            //向右扫描
            while (a[left]<temp&& left<right)
                left++;
            if(left == right) break;
            a[right] = a[left];
            right--;
        }
        if(left == right){
            a[left] = temp;
            if(left >0)
                quickSort(a,start,left-1);
            if(left<a.length-1)
                quickSort(a,left+1,end);
        }
    }

    //归并排序
    public static void mergeSort(int[] arr,int start ,int end){
        if(start<end){
            int mid = (start+end)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);
        }
    }
    public static void merge(int[] arr,int start,int mid ,int end){
        //将数组中要合并的两个部分分别放到两个数组中
        int len1 = mid-start+1;
        int len2 = end-mid;
        int left[] = new int[len1];
        int right[] = new int[len2];
        for(int i=0,p=start;i<len1;i++,p++){
            left[i] = arr[p];
        }
        for(int i=0,p=mid+1;i<len2;i++,p++){
            right[i]=arr[p];
        }
        //对两个子数组排序
        int le=0,r=0,k=start;
        for(;le<len1&&r<len2;k++){
            if(left[le]<=right[r]){
                arr[k] = left[le];
                le++;
            }else {
                arr[k] = right[r];
                r++;
            }
        }//for
        if(le<len1){
            for(;le<len1;le++,k++){
                arr[k]= left[le];
            }
        }
        if(r<len2){
            for(;r<len2;r++,k++)
                arr[k] =right[r];
        }
    }
}
