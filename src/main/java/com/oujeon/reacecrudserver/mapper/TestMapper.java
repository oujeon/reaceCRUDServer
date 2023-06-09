package com.oujeon.reacecrudserver.mapper;

import com.oujeon.reacecrudserver.vo.Test12Vo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface TestMapper {

    public Map<String,Object> selectGetTest(int idId, String nameName);
    public Map<String,Object>  selectPostTest(Map<String, Object> map);
    public List<Map<String,Object>> restGetSelect(int idId );
    public int restPostInsert(Map<String, String> map);
    public int restPutUpdate(Map<String, String> map);
    public int restDeleteDelete(int idId);

    public List<Test12Vo> restGetVoSelect(int idId );

    public int restPostVoInsert(Test12Vo test12Vo );
    public int restPutVoUpdate(Test12Vo test12Vo );
    public int restPutVoDelete(Test12Vo test12Vo );

}