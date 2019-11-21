package com.xiao.arithmetic;

import com.xiao.utils.Arr;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 输入一串数字，输出数字对应的字符的全排列
 */
public class FullArrange {
    public static void main(String[] args){
        //构建数字与字母的对应关系
        HashMap<Character,char[]> map = new HashMap<>();
        int count = 0;
        for(int i=2;i<=9;i++){
            char ch = (char) ('0'+i );
            int len = 3;
            if(ch == '7' || ch == '9')
                len = 4;
            char[] arr = new char[len];
            for(int j=0;j<len;j++){
                arr[j] =(char)('a'+count);
                count++;
            }
            map.put(ch,arr);
        }
        System.out.println("对应关系构建完成！");

        //全排列标准
        String biao = "235";

        //全排列输出
        ArrayList<String> result = new ArrayList<>();
        result.add("");
        for(int k =0;k<biao.length();k++){
            char[] arr = map.get(biao.charAt(k));
            int orgSize = result.size();//这里需要记录进入循环时result,否则进入循环后result一直在变大会进入死循环
            for(int j=0;j<orgSize;j++){
                for(int i=0;i<arr.length;i++){
                    String ban = result.get(0)+arr[i];
                    result.add(ban);
                }
                result.remove(0);
            }
        }

        //输出结果
        Object[] resultArr = result.toArray();
        Arr.printArr(resultArr);

    }

}
