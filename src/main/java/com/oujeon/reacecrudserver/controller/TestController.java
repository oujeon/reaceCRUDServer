package com.oujeon.reacecrudserver.controller;

import com.oujeon.reacecrudserver.service.TestService;
import com.oujeon.reacecrudserver.vo.TestVo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/gettest")
    public HashMap<String, String> getTest(Model model ){

        String strGetTest = testService.getTest( );
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("data", strGetTest);

        return map;
    }
    @PostMapping("/posttest")
    public HashMap<String, String> postTest(@RequestBody TestVo testvo ){
        String strPostTest = testService.postTest( );
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("data", strPostTest);

        return map;
    }
    @ResponseBody
    @GetMapping("/restselect")
    public JSONArray    restSelect(@RequestParam Integer id, String name ){

        //

        List<Map<String,Object>> listMapTemp = testService.restSelect(id, name);
        //

        JSONArray jsonArray = new JSONArray();

        for (Map<String, Object> map : listMapTemp) {

            jsonArray.add(convertMapToJson(map));

        }

        return jsonArray;

    }
    public static JSONObject convertMapToJson(Map<String, Object> map) {

        JSONObject json = new JSONObject();

        for (Map.Entry<String, Object> entry : map.entrySet()) {

            String key = entry.getKey();

            Object value = entry.getValue();

            // json.addProperty(key, value);

            json.put(key, value);

        }

        return json;

    }


    @PostMapping ("/restpostinsert")
    public int restPostInsert(@RequestBody Map<String, String> map) {
        //
          testService.restPostInsert(map);
        return 0;
    }

    @PutMapping ("/restputupdate")
    public int restPutUpdate(@RequestBody Map<String, String> map) {


        //
        testService.restPutUpdate(map);


        return 0;
    }
    @DeleteMapping ("/restdeletedelete")
    public int restDeleteDelete( @RequestParam int idId) {

        System.out.println("idId : " + idId);
        //
        testService.restDeleteDelete(  idId);


        return 0;
    }
}
