package com.oujeon.reacecrudserver.service;

import com.oujeon.reacecrudserver.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestMapper testMapper;

    public String getTest(){


        String strTest = testMapper.selectGetTest();


        return  strTest;
    }


}
