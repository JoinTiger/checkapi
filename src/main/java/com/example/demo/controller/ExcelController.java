package com.example.demo.controller;

import com.example.demo.bean.Product;
import com.example.demo.bean.datatmp.DataBean;
import com.example.demo.bean.datatmp.TransferProdcutAndDatabean;
import com.example.demo.bean.response.ResponseEntiry;
import com.example.demo.logger.WaLogger;
import com.example.demo.service.ProductService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ExcelController {

    @Autowired
    private ProductService productService;


    @RequestMapping("/export")
    public String exportPage(){
        return "export";
    }
    @RequestMapping("/")
    public String importPage(){
        return "import";
    }


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
            responseEntiry.setData(dataBean);
        } catch (Exception e) {
            responseEntiry.setMsgCode(1);
            responseEntiry.setMsgDesc(e.toString());
        }

        return responseEntiry;


    }


    @GetMapping(value = "/excel/export")
    @ResponseBody
    public ResponseEntiry excelExport() {

        ResponseEntiry responseEntiry = new ResponseEntiry();

        try {

            List<Product> products = productService.findAll();

            List<DataBean> dataBeans = TransferProdcutAndDatabean.productsToDataBeans(products);

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





}