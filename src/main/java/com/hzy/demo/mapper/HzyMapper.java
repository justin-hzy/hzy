package com.hzy.demo.mapper;


import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository(value = "HzyMapper")
public interface HzyMapper {

        int getNum();

        int getNum1();

        int updateNum(int i);

}
