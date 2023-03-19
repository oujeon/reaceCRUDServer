package com.oujeon.reacecrudserver.service;

import com.oujeon.reacecrudserver.vo.TestVo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TestService {


    public String getTest() ;
    public String postTest() ;
    public List<Map<String,Object>> restSelect(Integer id, String name) ;
    public void restPostInsert(Map<String, String> map) ;
    public void restPutUpdate(Map<String, String> map) ;
    public void restDeleteDelete(int idId) ;


}
