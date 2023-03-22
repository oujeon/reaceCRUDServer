package com.oujeon.reacecrudserver.controller;

import com.oujeon.reacecrudserver.service.TestService;
import com.oujeon.reacecrudserver.vo.Test12Vo;
import com.oujeon.reacecrudserver.vo.Test6Vo;
import com.oujeon.reacecrudserver.vo.Test7Vo;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
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
    public Map<String, Object> getTest(@RequestParam int id, String name) {

        Map<String, Object> mapTemp = testService.getTest(id, name);

        return mapTemp;
    }

    @PostMapping("/posttest")
    public Map<String, Object> postTest(@RequestBody Map<String, Object> map) {
        //
        log.info("toString : "+ map.toString());
        log.info("idId : "+ map.get("idId")); //대소문자 구별
        log.info("nameName : "+ map.get("nameName")); //대소문자 구별
        //
        Map<String, Object> mapTemp = testService.postTest(map);
        //
        return mapTemp;
    }


    @GetMapping("/restgetselect")
    public  List<Map<String, Object>> restGetSelect(@RequestParam int idId ) {

        //

        List<Map<String, Object>> listMapTemp = testService.restGetSelect(idId );


        return listMapTemp;

    }




    @PostMapping("/restpostinsert")
    public  Map<String, Object> restPostInsert(@RequestBody Map<String, String> map) {
        //

        int i = testService.restPostInsert(map);

        Map<String, Object> hashmap = new HashMap<>();

        hashmap.put("cnt", i);

        return hashmap;
    }

    @PutMapping("/restputupdate")
    public Map<String, Object> restPutUpdate(@RequestBody Map<String, String> map) {


        //
        int i = testService.restPutUpdate(map);
        Map<String, Object> hashmap = new HashMap<>();

        hashmap.put("cnt", i);

        return hashmap;
    }

    @DeleteMapping("/restdeletedelete")
    public Map<String, Object> restDeleteDelete(@RequestParam int idId) {

        //
        int i = testService.restDeleteDelete(idId);
        Map<String, Object> hashmap = new HashMap<>();

        hashmap.put("cnt", i);

        return hashmap;
    }


    @GetMapping("/restGetHttpServletRequestSelect")
    public void restGetHttpServletRequestSelect(HttpServletRequest httpServletRequest) {

        log.info("id : " + httpServletRequest.getParameter("idId"));
        log.info("name : " + httpServletRequest.getParameter("nameName"));


    }

    @PostMapping("/restPostHttpServletRequestInsert")
    public void restPostHttpServletRequestInsert(HttpServletRequest httpServletRequest) {

        // HttpServletRequest에서는 post가 되지 않는다.
        log.info("idId : " + httpServletRequest.getParameter("idId"));
        log.info("nameName : " + httpServletRequest.getParameter("nameName"));


    }

    @GetMapping("/restGetPathVariableSelect/{idId}/{nameName}")
    public void restGetPathVariableSelect(@PathVariable Long idId, @PathVariable(name = "nameName") String nameName) {

        log.info("idId : " + idId);
        log.info("nameName : " + nameName);


    }

    @GetMapping("/restGetRequestParamSelect")
    public void restGetRequestParamSelect(@RequestParam String nameName,
                                          @RequestParam Long idId
//                                          @RequestParam(required = false, defaultValue = "default") String requireValue, // default 처리
//                                          @RequestParam Map<String, Object> map // 한번에 받아오려면 이렇게
    ) {

        log.info("idId : " + idId);
        log.info("nameName : " + nameName);


    }

    @GetMapping("/restGetModelAttributeSelect")
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


        if (!fileName.isEmpty()) {
            log.info("fileName.isEmpty() :  " + fileName.isEmpty());
            log.info("fileName  : " + fileName.getName());
            log.info("getOriginalFilename  : " + fileName.getOriginalFilename());
        }
        fileName.transferTo(new File(fileName.getOriginalFilename()));
        return "fileName";
    }

    // 다운로드 하는 방법 : http://localhost:8080/download
    // http://localhost:3000/download 안됨
    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {


        //
        File f = new File("C:\\Users\\oujeo\\IdeaProjects\\reaceCRUDServer\\src\\main\\resources\\file\\", "upload_업로드_file.png");
        // file 다운로드 설정
        response.setContentType("application/download");
        response.setContentLength((int) f.length());
        response.setHeader("Content-disposition", "attachment;filename=\"" + "upload_file.png" + "\"");
        // response 객체를 통해서 서버로부터 파일 다운로드
        OutputStream os = response.getOutputStream();
        // 파일 입력 객체 생성
        FileInputStream fis = new FileInputStream(f);
        FileCopyUtils.copy(fis, os);
        fis.close();
        os.close();
        //
    }


    @GetMapping("/restgetvoselect")
    public  List<Test12Vo> restGetVoSelect(@RequestParam int idId ) {

        //

        List<Test12Vo> listMapTemp = testService.restGetVoSelect(idId );


        //
        return listMapTemp;

    }

}
