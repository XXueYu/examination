package com.xiao.arithmetic;

public class Test {
    public String test(String str){
        StringBuilder sb = new StringBuilder();
        char ch;
        for(int i=0;i<str.length();i++){
            if((ch = str.charAt(i))==' ')
                sb.append("%20");
            else
                sb.append(ch);
        }
        return sb.toString();
    }
}
