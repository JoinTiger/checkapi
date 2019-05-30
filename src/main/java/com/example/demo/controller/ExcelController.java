package com.example.demo.controller;

import com.example.demo.bean.Motor;
import com.example.demo.bean.Product;
import com.example.demo.bean.datatmp.DataBean;
import com.example.demo.bean.datatmp.TransferProdcutAndDatabean;
import com.example.demo.bean.response.ResponseEntiry;
import com.example.demo.bean.result.ElecAtrribueSummary;
import com.example.demo.logger.WaLogger;
import com.example.demo.service.MotorService;
import com.example.demo.service.ProductService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(value = "检测工具导入、导出数据", description = "检测工具导入、导出数据操作 API", position = 100, protocols = "http")
@Controller
public class ExcelController {

    @Autowired
    private ProductService productService;

    @Autowired
    private MotorService motorService;

    @ApiOperation(value = "导入数据", notes = "一次导入一条数据")
    @PostMapping("/excel/import")
    @ResponseBody
    public ResponseEntiry excelImport(@RequestBody String json) {

        ResponseEntiry responseEntiry = new ResponseEntiry();

        try {

            ObjectMapper mapper = new ObjectMapper();

            DataBean dataBean = mapper.readValue(json, new TypeReference<DataBean>(){});

            Product product = TransferProdcutAndDatabean.dataBeanToProduct(dataBean);

            productService.save(product);

            responseEntiry.setMsgCode(0);
            responseEntiry.setMsgDesc("录入成功");
            responseEntiry.setData(product);
        } catch (Exception e) {
            responseEntiry.setMsgCode(1);
            responseEntiry.setMsgDesc(e.toString());
        }

        return responseEntiry;


    }

    @ApiOperation(value = "导出所有数据", notes = "一次导出所有数据")
    @GetMapping(value = "/excel/export")
    @ResponseBody
    public ResponseEntiry excelExport() {

        ResponseEntiry responseEntiry = new ResponseEntiry();

        try {

            List<Product> products = productService.findAll();

            List<DataBean> dataBeans = TransferProdcutAndDatabean.productsToDataBeans(products);

            if(dataBeans.size() == 0) {
                throw new Exception("no data!");
            }

            responseEntiry.setMsgCode(0);
            responseEntiry.setMsgDesc("查询成功");
            responseEntiry.setData(dataBeans);

        } catch (Exception e) {
            WaLogger.logger.warn(e.toString());
            responseEntiry.setMsgCode(1);
            responseEntiry.setMsgDesc(e.toString());
        }

        return responseEntiry;

    }

    @ApiOperation(value = "导入出电机数据", notes = "根据elecModel导出电机各属性值")
    @PostMapping(value = "/elecData/export")
    @ResponseBody
    public ResponseEntiry exportElecAtrributes(@RequestBody String json) {
        ResponseEntiry responseEntiry = new ResponseEntiry();
        try {

            ObjectMapper mapper = new ObjectMapper();

            Motor motor = mapper.readValue(json, new TypeReference<Motor>(){});


            List<ElecAtrribueSummary> atrributeByElecModel = motorService.findAtrributeByElecModel(motor.getElecModel());

            if(atrributeByElecModel.size() == 0) {
                throw new Exception("no data!");
            }

            responseEntiry.setMsgCode(0);
            responseEntiry.setMsgDesc("查询成功");
            responseEntiry.setData(atrributeByElecModel);


        } catch (Exception e) {
            WaLogger.logger.warn(e.toString());
            responseEntiry.setMsgCode(1);
            responseEntiry.setMsgDesc(e.toString());
        }


        return responseEntiry;
    }


}