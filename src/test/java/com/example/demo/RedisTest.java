package com.example.demo;

import com.example.demo.bean.Product;
import com.example.demo.redis.SequenceUtils;
import com.example.demo.repository.MotorRepository;
import com.example.demo.repository.NcVerRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.ServoRepository;
import com.example.demo.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private SequenceUtils sequenceUtil;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private NcVerRepository ncVerRepository;

    @Autowired
    private ServoRepository servoRepository;

    @Autowired
    private MotorRepository motorRepository;


    @Test
    public void test() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String preStr = simpleDateFormat.format(date);
        System.out.println(preStr + sequenceUtil.getAutoFlowCode());
    }

    @Test
    public void test01() {

    }

}
