package com.xiao.arithmetic;


import java.util.ArrayList;
import java.util.LinkedList;

public class HasPath {
    public static char[] matrix;
    public static int rows;
    public static int cols;
    public static char[] str;
    public static void main(String[] args) {
        matrix = "ABCESFCSADEE".toCharArray();
        rows = 3;
        cols = 4;
        str = "SEE".toCharArray();
        boolean result = hasPath(matrix,rows,cols,str);
        System.out.println(result);
    }

    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(str.length<1)
            return false;
        int[] status = new int[matrix.length];
        //路径初始位置
        for(int i=0;i<matrix.length;i++){
            if(matrix[i] == str[0]){
                status[i]=1;
                //从该位置开始寻找路径
                LinkedList<Integer> path = new LinkedList<>();
                path.add(i);
                boolean flag =findPath(status,path);
                if(flag == true)
                    return true;
            }
        }
        return false;
    }

    public static boolean findPath(int[] status,LinkedList<Integer> path){
        //递归结束的条件
        if(path.size() == str.length)
            return true;
        //扩展当前节点,状态为1的节点不再考虑
        int now = path.getLast();
        ArrayList<Integer> child = new ArrayList<>();
        if(now/cols-1>=0 && status[now-cols]==0)//上
            child.add(now-cols);
        if(now/cols+1<=rows-1 && status[now+cols]==0)//下
            child.add(now+cols);
        if(now%cols-1>=0 && status[now-1]==0)//左
            child.add(now-1);
        if(now%cols+1<=cols-1 && status[now+1]==0)//右
            child.add(now+1);
        //遍历子节点，判断是否满足条件，将满足条件的节点加入到路径中，继续深度优先拓展
        //第几步
        int index = path.size();
        for(int i=0;i<child.size();i++){
            int address = child.get(i);
            if(matrix[address] == str[index]){
                status[address] = 1;
                path.add(address);
                boolean childRe = findPath(status,path);
                if(childRe == true)  //从底层返回true才罢休，否则continue
                    return true;
            }
        }
        //如果子节点都不满足条件，需要将该节点从path中移除
        path.removeLast();
        status[now] = 0;
        return false;
    }
}

