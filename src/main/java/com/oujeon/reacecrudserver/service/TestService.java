package com.oujeon.reacecrudserver.service;

import com.oujeon.reacecrudserver.vo.Test12Vo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TestService {


    public Map<String,Object> getTest(int id, String name) ;
    public Map<String,Object> postTest(Map<String, Object> map) ;
    public List<Map<String,Object>> restGetSelect(int idId ) ;
    public int restPostInsert(Map<String, String> map) ;
    public int restPutUpdate(Map<String, String> map) ;
    public int restDeleteDelete(int idId) ;

    public List<Test12Vo> restGetVoSelect(int idId ) ;
    public int restPostVoInsert( Test12Vo test12Vo) ;

    public int restPutVoUpdate( Test12Vo test12Vo) ;
    public int restPutVoDelete( Test12Vo test12Vo) ;


}