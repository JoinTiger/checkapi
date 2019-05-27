package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.bean.response.ResponseEntiry;
import com.example.demo.logger.WaLogger;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/user/import")
    @ResponseBody
    public ResponseEntiry excelImport(@RequestBody String json) {

        ResponseEntiry responseEntiry = new ResponseEntiry();

        try {

            ObjectMapper mapper = new ObjectMapper();

            User user = mapper.readValue(json, new TypeReference<User>(){});

            userService.save(user);

            responseEntiry.setMsgCode(0);
            responseEntiry.setMsgDesc("录入成功");
            responseEntiry.setData(user);
        } catch (Exception e) {
            responseEntiry.setMsgCode(1);
            responseEntiry.setMsgDesc(e.toString());
        }

        return responseEntiry;


    }


    @PostMapping(value = "/user/export")
    @ResponseBody
    public ResponseEntiry excelExport(@RequestBody String json) {

        ResponseEntiry responseEntiry = new ResponseEntiry();

        try {

            ObjectMapper mapper = new ObjectMapper();

            User user = mapper.readValue(json, new TypeReference<User>(){});

            User userData = userService.findFirstByUsername(user.getUsername());

            responseEntiry.setMsgCode(0);
            responseEntiry.setMsgDesc("查询成功");
            responseEntiry.setData(userData);

        } catch (Exception e) {
            WaLogger.logger.warn(e.toString());
            responseEntiry.setMsgCode(1);
            responseEntiry.setMsgDesc(e.toString());
        }

        return responseEntiry;

    }






}
