package com.oujeon.reacecrudserver.service;

import com.oujeon.reacecrudserver.mapper.TestMapper;
import com.oujeon.reacecrudserver.vo.Test12Vo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;

    @Override
    public Map<String, Object> getTest(int idId, String nameName) {

        Map<String, Object> mapTemp = testMapper.selectGetTest(idId, nameName);

        return mapTemp;
    }

    @Override
    public Map<String, Object> postTest(Map<String, Object> map) {


        Map<String, Object> mapTemp = testMapper.selectPostTest(map);


        return mapTemp;
    }

    @Override
    public List<Map<String, Object>> restGetSelect(int idId ) {


        List<Map<String, Object>> listMapTemp = testMapper.restGetSelect(idId );

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

    @Override
    public List<Test12Vo> restGetVoSelect(int idId ) {


        List<Test12Vo> listMapTemp = testMapper.restGetVoSelect(idId );

        for (Test12Vo map : listMapTemp) {
            System.out.println("NAMENAME : " + map.getIdId());
            System.out.println("IDID : " + map.getNameName());
        }

        return listMapTemp;
    }

    @Override
    public int restPostVoInsert( Test12Vo test12Vo) {
        //
        System.out.println("test12Vo : " + test12Vo);
        int cnt = testMapper.restPostVoInsert(test12Vo );
        //
        return cnt;
    }

    @Override
    public int restPutVoUpdate( Test12Vo test12Vo) {
        //
        System.out.println("test12Vo : " + test12Vo);
        int cnt = testMapper.restPutVoUpdate(test12Vo );
        //
        return cnt;
    }
    @Override
    public int restPutVoDelete( Test12Vo test12Vo) {
        //
        System.out.println("test12Vo : " + test12Vo);
        int cnt = testMapper.restPutVoDelete(test12Vo );
        //
        return cnt;
    }

}