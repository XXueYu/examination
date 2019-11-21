package com.xiao.arithmetic.dynamicPlan;

public class CutTheRope {
    public int cutRope(int target) {
        if(target == 2 || target == 1)
            return 1;
        else {
            int max = 0;
            for(int i = 1;i<=target/2 ;i++){
                int con = max(cutRope(i),i)*max(cutRope(target-i),target-i);
                if(con >max)
                    max = con;
            }
            return max;
        }
    }
    public int max(int a,int b){
        if(a>=b)
            return a;
        else
            return b;
    }
}
