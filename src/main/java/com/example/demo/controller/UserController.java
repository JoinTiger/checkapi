package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.bean.response.ResponseEntiry;
import com.example.demo.logger.WaLogger;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value = "导入、导出用户数据", description = "导入、导出用户数据操作 API", position = 100, protocols = "http")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "导入用户", notes = "一次导入一条用户数据")
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

    @ApiOperation(value = "导出用户", notes = "根据用户名导出用户用户名和密码")
    @PostMapping(value = "/user/export")
    @ResponseBody
    public ResponseEntiry excelExport(@RequestBody String json) {

        ResponseEntiry responseEntiry = new ResponseEntiry();

        try {

            ObjectMapper mapper = new ObjectMapper();

            User user = mapper.readValue(json, new TypeReference<User>(){});

            User userData = userService.findFirstByUsername(user.getUsername());

            if(null == userData) {
                throw new Exception("no data!");
            }


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
