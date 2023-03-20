package com.oujeon.reacecrudserver.mapper;

import com.oujeon.reacecrudserver.vo.TestVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


@Mapper
public interface TestMapper {

    public String selectGetTest();
    public String selectPostTest();
    public List<Map<String,Object>> restGetSelect(Integer id, String name);
    public int restPostInsert(Map<String, String> map);
    public int restPutUpdate(Map<String, String> map);
    public int restDeleteDelete(int idId);


}
