package com.hzy.demo.collection;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        List<Map<String,String>> list1 = new ArrayList<Map<String,String>>();

        /*int max=100,min=1;
        int ran2 = (int) (Math.random()*(max-min)+min);
        System.out.println(ran2);*/

        String extend1 = "";
        String notExist = "";
        String errorKey = "";

        for(int i=0;i<10;i++){
            int max=100,min=1;
            int ran2 = (int) (Math.random()*(max-min)+min);
            Map<String,String> map = new HashMap<String,String>();
            map.put(String.valueOf(i),String.valueOf(ran2));
            list1.add(map);
        }

        System.out.println("list1="+list1.toString());

        List<Map<String,String>> list2 = new ArrayList<Map<String,String>>();


        for(int i=5;i<15;i++){
            int max=100,min=1;
            int ran2 = (int) (Math.random()*(max-min)+min);
            Map<String,String> map = new HashMap<String,String>();
            map.put(String.valueOf(i),String.valueOf(ran2));
            list2.add(map);
        }

        System.out.println("list2="+list2.toString());


        Map<String,String> map3 = new HashMap<String,String>();

        map3.put("5","123");
        list2.add(map3);
        System.out.println("list2="+list2.toString());

        List keyList = new ArrayList();

        /*把要配对的key装到list里面*/
        for (Map<String,String> map :list2){
            Set<String> keySet  = map.keySet();
            for (String str : keySet){
                keyList.add(str);
            }
        }
        /*判断域是否存*/
        for (Map<String,String> map :list1){
            Set<String> keySet  = map.keySet();
            for (String  str: keySet){
                if(!keyList.contains(str)){
                    notExist += str+"域";
                }

            }
        }
        extend1 += notExist + "不存在";


        List errorKeyList = new ArrayList();

        /*对比域的值是否匹配*/
        for (Map<String,String> map1 :list1){
            Set<String> keySet  = map1.keySet();
            String key = null;
            for (String  str: keySet){
                key = str;
            }
            for (Map<String,String> map2 :list2){
                if (map2.get(key)!=null){
                    if(!errorKeyList.contains(key)){
                        if (!map2.get(key).equals(map1.get(key))){
                            errorKeyList.add(key);
                            errorKey += key+"域";
                        }
                    }

                }

            }

        }

        extend1 += "|"+errorKey + "不匹配";

        System.out.println(extend1);

       add();
    }

    public static void add(){

    }
}
