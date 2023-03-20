package com.oujeon.reacecrudserver.controller;

import com.oujeon.reacecrudserver.service.TestService;
import com.oujeon.reacecrudserver.vo.Test6Vo;
import com.oujeon.reacecrudserver.vo.Test7Vo;
import com.oujeon.reacecrudserver.vo.TestVo;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
// REST API Controller 사용한다는 것을 프레임워크에 알려줌
// @RestController를 이용하면, 내부적으로 Jackson 라이브러리에 의해 VO 객체를 JSON 형태로 변환하여 응답해준다.
// 만약 @RestController가 아닌 @Controller를 사용한다면, @ResponseBody를 추가해줘야 한다.

@ResponseBody
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/gettest")
    public HashMap<String, String> getTest(Model model) {

        String strGetTest = testService.getTest();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("data", strGetTest);

        return map;
    }

    @PostMapping("/posttest")
    public HashMap<String, String> postTest(@RequestBody TestVo testvo) {
        String strPostTest = testService.postTest();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("data", strPostTest);

        return map;
    }


    @GetMapping("/restgetselect")
    public JSONArray restGetSelect(@RequestParam Integer id, String name) {

        //

        List<Map<String, Object>> listMapTemp = testService.restGetSelect(id, name);
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


    @PostMapping("/restpostinsert")
    public JSONObject restPostInsert(@RequestBody Map<String, String> map) {
        //
        JSONObject jsonObject = new JSONObject();
        int i = testService.restPostInsert(map);

        jsonObject.put("count", i);

        return jsonObject;
    }

    @PutMapping("/restputupdate")
    public JSONObject restPutUpdate(@RequestBody Map<String, String> map) {

        JSONObject jsonObject = new JSONObject();
        //
        int i = testService.restPutUpdate(map);
        jsonObject.put("count", i);

        return jsonObject;
    }

    @DeleteMapping("/restdeletedelete")
    public JSONObject restDeleteDelete(@RequestParam int idId) {

        JSONObject jsonObject = new JSONObject();
        //
        int i = testService.restDeleteDelete(idId);
        jsonObject.put("count", i);

        return jsonObject;
    }


    @GetMapping("/restgethttpservletRequestselect")
    public void restGetHttpServletRequestSelect(HttpServletRequest httpServletRequest) {

        log.info("id : " + httpServletRequest.getParameter("idId"));
        log.info("name : " + httpServletRequest.getParameter("nameName"));


    }

    @PostMapping("/restposthttpservletrequestinsert")
    public void restPostHttpServletRequestInsert(HttpServletRequest httpServletRequest) {

        log.info("id : " + httpServletRequest.getParameter("idId"));
        log.info("name : " + httpServletRequest.getParameter("nameName"));


    }

    @GetMapping("/restgetpathvariableselect/{idId}/{nameName}")
    public void restGetPathVariableSelect(@PathVariable Long idId, @PathVariable(name = "nameName") String nameName) {

        log.info("id : " + idId);
        log.info("name : " + nameName);


    }

    @GetMapping("/restgetrequestparamselect")
    public void restGetRequestParamSelect(@RequestParam String nameName,
                                          @RequestParam Long idId
//                                          @RequestParam(required = false, defaultValue = "default") String requireValue, // default 처리
//                                          @RequestParam Map<String, Object> map // 한번에 받아오려면 이렇게
    ) {

        log.info("id : " + idId);
        log.info("name : " + nameName);


    }

    @GetMapping("/restgetmodelattributeselect")
    public void restGetModelAttributeSelect(@ModelAttribute Test6Vo test6Vo) {

        log.info("id : " + test6Vo.getIdId());
        log.info("name : " + test6Vo.getNameName());


    }

    @PostMapping("/restpostmodelattributeselect")
    public void restPostModelAttributeSelect(@ModelAttribute Test6Vo test6Vo) {

        log.info("id : " + test6Vo.getIdId());
        log.info("name : " + test6Vo.getNameName());


    }

    @PostMapping("/restformmodelattributeselect")
    public void restFormModelAttributeSelect(@ModelAttribute Test6Vo test6Vo) {

        log.info("id : " + test6Vo.getIdId());
        log.info("name : " + test6Vo.getNameName());


    }

    @GetMapping("/restgetrequestbodyselect")
    public void restGetRequestBodySelect(@RequestBody Test7Vo test7Vo) {

        log.info("id : " + test7Vo.getIdId());
        log.info("name : " + test7Vo.getNameName());


    }

    @PostMapping("/restpostrequestbodyselect")
    public void restPostRequestBodySelect(@ModelAttribute Test7Vo test7Vo) {

        log.info("id : " + test7Vo.getIdId());
        log.info("name : " + test7Vo.getNameName());


    }

    @PostMapping("/restformrequestbodyselect")
    public void restFormRequestBodySelect(@ModelAttribute Test7Vo test7Vo) {

        log.info("id : " + test7Vo.getIdId());
        log.info("name : " + test7Vo.getNameName());

    }

    // Model 객체는 컨트롤러에서 데이터를 생성해 이를 JSP 즉 View에 전달하는 역할을 합니다.
    // Model 객체는 Controller 에서 생성된 데이터를 담아 View 로 전달할 때 사용하는 객체이다.
    // ※ Servlet의 request.setAttribute() 와 비슷한 역할을 함
    // addAttribute("key", "value") 메서드를 이용해 view에 전달할 데이터를 key, value형식으로 전달할 수 있다.
    @GetMapping("/restgetmodelselect")
    public String restGetModelSelect(Model model) {

        model.addAttribute("id", "idId");


        return "/";
    }


    //
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest() {
        return "Hello Spring";
    }

    //
    @RequestMapping(method = RequestMethod.POST, path = "/getMethod")
    public String getRequest2() {
        return "Hello Spring";
    }

    @PostMapping("/upload")
    public String fileUpload(MultipartFile fileName) throws
            IOException {


        if(!fileName.isEmpty()) {
            System.out.println( "fileName.isEmpty() :  " + fileName.isEmpty());
            System.out.println("fileName  : " +   fileName.getName() );
            System.out.println("getOriginalFilename  : " +   fileName.getOriginalFilename());
        }
        fileName.transferTo(new File(fileName.getOriginalFilename()));
        return "fileName";
    }


}
