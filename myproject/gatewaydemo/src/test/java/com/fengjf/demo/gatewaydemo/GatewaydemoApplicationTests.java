package com.fengjf.demo.gatewaydemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GatewaydemoApplicationTests {

    @Test
    public void contextLoads() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(4);
        list.add(0);
        list.add(9);
        list.add(88);
        list.add(90);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        Collections.sort(list);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}
