package com.hzy.demo;

import com.hzy.demo.service.HzyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private HzyService hzyService;
    @Test
    void contextLoads() {
        hzyService.aopTest();
    }


}
