package com.example.demo.controller;

import com.example.demo.bean.Product;
import com.example.demo.bean.datatmp.DataBean;
import com.example.demo.bean.datatmp.TransferProdcutAndDatabean;
import com.example.demo.bean.response.ResponseEntiry;
import com.example.demo.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
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
    public String excelExport() throws JsonProcessingException {

        List<Product> products = productService.findAll();

        DataBean dataBean = TransferProdcutAndDatabean.productToDataBean(products.get(0));

        ObjectMapper mapper = new ObjectMapper();

        return mapper.writeValueAsString(dataBean);
    }





}