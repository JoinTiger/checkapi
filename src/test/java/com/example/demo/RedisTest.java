package com.example.demo;

import com.example.demo.bean.Motor;
import com.example.demo.bean.Product;
import com.example.demo.bean.User;
import com.example.demo.bean.result.ElecAtrribueSummary;
import com.example.demo.redis.SequenceUtils;
import com.example.demo.repository.*;
import com.example.demo.service.MotorService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private MotorService motorService;

    @Test
    public void test() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String preStr = simpleDateFormat.format(date);
        System.out.println(preStr + sequenceUtil.getAutoFlowCode());
    }

    @Test
    public void test01() {

//        User user = new User(12L, "ad", "123");
//        User user1 = new User(23L, "yx", "345");
//        User user2 = new User(32L, "re", "234");
//
//        userRepository.save(user);
//        userRepository.save(user1);
//        userRepository.save(user2);

        System.out.println(userService.findFirstByUsername("re").getPassword());

    }

    @Test
    public void test02() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        List<ElecAtrribueSummary> atrributeByElecModel = motorService.findAtrributeByElecModel("402F");
        System.out.println(mapper.writeValueAsString(atrributeByElecModel));
    }

}
