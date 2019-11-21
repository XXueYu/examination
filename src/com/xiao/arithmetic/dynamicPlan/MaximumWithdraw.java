package com.xiao.arithmetic.dynamicPlan;

import com.xiao.utils.Arr;

public class MaximumWithdraw {
    public static void main(String[] args) {
        //int[] arr =  Arr.generateArrRandom(15);
       // Arr.printArr(arr);
        int[] arr = Arr.getArr();
        int[] result = maxWd(arr);
        System.out.println("\nx="+result[0]+",y="+result[1]);
    }

    /**
     * temp[]解释：temp[0]:最大回撤的“左大”，temp[1]:最大回撤的“右小”，temp[2]:“左大”右侧的大于“左大”的最大值
     *  @param arr
     * @return
     */
    public static int[] maxWd(int[] arr){
        int[] result = {-1,-1};
        if(arr.length>1){
            int[] temp;
            if(arr[1]>arr[0])
                temp = new int[]{1, -1, 0};
            else
                temp = new int[]{0,1,0};
            for(int i=2;i<arr.length;i++){
                if(temp[2]==0){
                    if((temp[1]==-1 && arr[i]<arr[temp[0]]) || (temp[1]!=-1 && arr[i]<arr[temp[1]]))
                        temp[1] = i;
                    else {
                        if(arr[i]>arr[temp[0]])
                            temp[2] = i;
                    }
                }
                else {
                    if(arr[i]>arr[temp[2]])
                        temp[2] = i;
                    else {
                        if(arr[i]<arr[temp[1]]+arr[temp[2]]-arr[temp[0]]){
                            temp[0] = temp[2];
                            temp[1] = i;
                            temp[2] = 0;
                        }else {
                            if(arr[i]<arr[temp[1]])
                                temp[1] = i;
                        }
                    }
                }
            }
            result[0] = arr[temp[0]];
            result[1] = arr[temp[1]];
        }
        return result;
    }
}
