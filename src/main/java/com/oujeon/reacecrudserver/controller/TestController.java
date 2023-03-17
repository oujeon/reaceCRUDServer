package com.oujeon.reacecrudserver.controller;

import com.oujeon.reacecrudserver.service.TestService;
import com.oujeon.reacecrudserver.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

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
        map.put("id", strGetTest);

        return map;
    }
    @PostMapping("/posttest")
    public String postTest(@RequestBody TestVo testvo ){
        System.out.println("testvo :" + testvo.getTest());
        return "/";
    }
}
