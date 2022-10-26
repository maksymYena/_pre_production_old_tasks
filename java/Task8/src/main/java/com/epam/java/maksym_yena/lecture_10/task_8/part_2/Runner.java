package com.epam.java.maksym_yena.lecture_10.task_8.part_2;

import java.util.HashMap;
import java.util.Map;

public class Runner {
    public static void main(String[] args) {

        Map<StringHashFirstFour, Products> productsMap = new HashMap<>();
       productsMap.put(new StringHashFirstFour("123"),new Products("App",5));
        productsMap.put(new StringHashFirstFour("234"),new Products("App",5));
        productsMap.put(new StringHashFirstFour("356"),new Products("App",5));
        productsMap.put(new StringHashFirstFour("467"),new Products("App",5));

        for(Map.Entry<StringHashFirstFour, Products> x : productsMap.entrySet()) {
            System.out.println("Key = " + x.getKey() + " , value = " + x.getValue() + " , hashCode = " + x.getKey().hashCode());
        }

        Map<StringHashLength, Products> hashMap = new HashMap<>();
        hashMap.put(new StringHashLength("1"),new Products("App",6));
        hashMap.put(new StringHashLength("12"),new Products("App",5));
        hashMap.put(new StringHashLength("123"),new Products("App",5));
        hashMap.put(new StringHashLength("1234"),new Products("App",5));

        for(Map.Entry<StringHashLength, Products> x : hashMap.entrySet()) {
            System.out.println("Key = " + x.getKey() + " , value = " + x.getValue() + " , hashCode = " + x.getKey().hashCode());
        }
    }
}
