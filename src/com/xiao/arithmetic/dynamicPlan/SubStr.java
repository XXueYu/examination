package com.xiao.arithmetic.dynamicPlan;

public class SubStr {
    public static void main(String[] args) {
        String s = "abcbefgf";
        String r = longestNotRepeating(s);
        System.out.println(r);
    }

    public static String longestNotRepeating(String s){
        if(s.length()==1)
            return s;
        StringBuilder result = new StringBuilder();
        StringBuilder cond = null;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int firstIndex = s.indexOf(ch);
            if(firstIndex == i){//不重复
                if(cond == null)
                    result.append(ch);
                else{
                    cond.append(ch);
                    if(cond.length()>result.length()){
                        result = cond;
                        cond = null;
                    }
                }
            }else {//遇到重复一定会新建一个空的cond
                s = s.substring(firstIndex+1);
                i = i-firstIndex-1;//截掉前面(firstIndex+1)之后，每个字符的索引自动改变，相应的i也得变
                cond = new StringBuilder();//
                for(int j=0;j<=i;j++){
                    cond.append(s.charAt(j));
                }
                if(cond.length()>result.length()){
                    result = cond;
                    cond = null;
                }
            }
        }
        return new String(result);
    }
}
