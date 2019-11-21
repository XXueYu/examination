package com.xiao.arithmetic;

import com.xiao.utils.Arr;

/**
 *找到数组中第K小的数,K>1
 */
public class TopK {
    //方法1：利用快排的思想
    public static int partition(int[] arr,int start,int end){
        //进行一次快排
        int temp = arr[start];
        int left=start,right=end;
        while (left < right){
            //从右向左扫描
            while (arr[right] > temp && left < right) right--;   //注意不能是left<=right
            if(left == right) break;
            arr[left] = arr[right];
            left++;
            //从左向右扫描
            while (arr[left] < temp && left < right) left++;
            if(left == right) break;
            arr[right] = arr[left];
            right--;
        }
        arr[right] = temp;
        return right;
    }
    public static int solution(int[] arr,int k,int start,int end){
        int index = partition(arr,start,end);
        if(index == k-1)
            return arr[index];
        if(index > k-1)
            return solution(arr,k,start,index -1);
        if(index < k-1 && index+1<arr.length)
            return solution(arr,k,index+1,end);
        else
            return -1;
    }

    //方法2：利用堆排序的思想

    public static void main(String[] args) {
        //int[] arr = Arr.generateArrRandom(5);
        int[] arr = Arr.getArr();
        Arr.printArr(arr);
        int result = solution(arr,4,0,arr.length-1);
        System.out.println("\n"+result);
    }
}
