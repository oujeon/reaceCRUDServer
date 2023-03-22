package com.oujeon.reacecrudserver.mapper;

import com.oujeon.reacecrudserver.vo.Test12Vo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface TestMapper {

    public Map<String,Object> selectGetTest(int id, String name);
    public Map<String,Object>  selectPostTest(Map<String, Object> map);
    public List<Map<String,Object>> restGetSelect(int idId );
    public int restPostInsert(Map<String, String> map);
    public int restPutUpdate(Map<String, String> map);
    public int restDeleteDelete(int idId);

    public List<Test12Vo> restGetVoSelect(int idId );
}
