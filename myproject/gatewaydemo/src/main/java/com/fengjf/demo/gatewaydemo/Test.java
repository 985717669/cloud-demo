package com.fengjf.demo.gatewaydemo;

import java.util.ArrayList;
import java.util.List;

/**
 * Author fengjf
 * Desc
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(300);
        list.add(50);
        list.add(40);
        list.add(0);
        list.add(9);
        list.add(88);
        list.add(90);
        list.add(90);
        for (Integer integer : list) {
            System.out.println(integer);
        }

        System.out.println("==============");
//        Collections.sort(list);
//        Object[] objects = list.toArray();
//        Arrays.sort(objects, null);
//        ListIterator<Integer> i = list.listIterator();
//        for (Object e : objects) {
//            i.next();
//            i.set((Integer) e);
//        }

        List<Integer> ll = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            if (i == 0) {
                ll.add(i, integer);
            } else {
                //正序

            }
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
