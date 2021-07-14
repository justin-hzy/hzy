package com.hzy.demo.string;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDemo {

    static String str = "{1:F01AB0CAEAAAXXX.SN..ISN..}{2:I202ABOCAEADXXXXN}{4:"
            +":20:785HR180010278D"
            +":21:444740NM18000003"
            +":32A:180921CNY20331996,67"
            +":52A:/44474601040001713"
            +"ABOCCNBJ190"
            +":57A:ABOCAEAA"
            +":58A:/0"
            +"ABOCAEAD"
            +":72:/CTFX/"
            +"-}";
    static String flag1 = "\\:[0-9][0-9][A-Z]\\:";


    static String flag2 = "\\:[0-9][0-9]\\:";

    public static void main(String[] args) {
        /*System.out.println(str.indexOf("{1:"));
        System.out.println(str.indexOf("{4:"));*/
        str = str.substring(str.indexOf("{4:")+3,str.indexOf("-}"));

        System.out.println(str);

        Pattern r1 = Pattern.compile(flag2);

        Pattern r2 = Pattern.compile(flag1);

        System.out.println("str="+str);

        Matcher m1 = r1.matcher(str);

        Matcher m2 = r2.matcher(str);

        /*str = str.substring(0,4);*/

        System.out.println("str="+str);

        List<Integer> list = new ArrayList<Integer>();

        while (m1.find()){
            list.add(m1.start());
            list.add(m1.end());
            System.out.println("m1.start()="+m1.start());
            System.out.println("m1.end()="+m1.end());

        }

        while (m2.find()){
            list.add(m2.start());
            list.add(m2.end());
            System.out.println("m2.start()="+m2.start());
            System.out.println("m2.end()="+m2.end());
        }

        System.out.println(list.toString());


        Collections.sort(list);

        System.out.println(list.toString());
 


    }
}
