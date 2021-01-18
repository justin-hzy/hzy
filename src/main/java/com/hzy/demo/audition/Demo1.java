package com.hzy.demo.audition;

import java.util.ArrayList;
import java.util.List;

/*用1234四个数组成的互不相同且不重复的三位数*/
public class Demo1 {

    public static void main(String[] args) {

        int[] array = {1,2,3,4};

        int  length = array.length;

        List<Integer> list = new ArrayList<Integer>();

        int i,j,k,t,num=0;
        for(i=1;i<=4;i++)
        {
            for(j=1;j<=4;j++)
            {
                for(k=1;k<=4;k++)
                {
                    if(i!=j && i!=k && j!=k)
                    {
                        t=i*100 + j*10 + k;
                        list.add(t);
                    }
                }
            }
        }

        System.out.println(list.toString());




    }
}
