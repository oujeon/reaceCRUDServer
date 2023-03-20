package com.oujeon.reacecrudserver.service;

import com.oujeon.reacecrudserver.mapper.TestMapper;
import com.oujeon.reacecrudserver.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    @Override
    public String getTest() {


        String strTest = testMapper.selectGetTest();


        return strTest;
    }

    @Override
    public String postTest() {


        String strTest = testMapper.selectPostTest();


        return strTest;
    }

    @Override
    public List<Map<String, Object>> restGetSelect(Integer id, String name) {


        List<Map<String, Object>> listMapTemp = testMapper.restGetSelect(id, name);

        for (Map<String, Object> map : listMapTemp) {
            System.out.println("NAMENAME : " + map.get("NAMENAME"));
            System.out.println("IDID : " + String.valueOf(map.get("IDID")));
        }

        return listMapTemp;
    }

    @Override
    public int restPostInsert(Map<String, String> map) {
        //
        System.out.println("testvo : " + map);
        //
        int i = testMapper.restPostInsert(map);
        //                 restpostinsert

        return i;

    }

    @Override
    public int restPutUpdate(Map<String, String> map) {
        //
        System.out.println("testvo : " + map);
        //
        int i = testMapper.restPutUpdate(map);
        //                 restpostinsert

        System.out.println("update i : " + i);

        return i;
    }

    @Override
    public int restDeleteDelete(int idId) {
        //
        int i = testMapper.restDeleteDelete(idId);

        System.out.println("i : " + i);
        //                 restpostinsert
        return i;

    }


}
