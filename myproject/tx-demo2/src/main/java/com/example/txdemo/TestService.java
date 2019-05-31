package com.example.txdemo;

import com.example.txdemo.entity.Bussiness;
import com.example.txdemo.mapper.BussinessMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Author fengjf
 * Desc
 */
@Service
public class TestService {
    @Resource
    BussinessMapper bussinessMapper;

    public String testsave() {
        Bussiness bussiness = new Bussiness();
        bussiness.setBussinessName("name");
        bussiness.setBussinessId("id");
        bussiness.setCouponId("coupon");
        bussiness.setBussinessType("type");
        int insert = bussinessMapper.insert(bussiness);
        if (insert > 0) {
            return "SUCCESS";
        }
        return "FALI";
    }
}
