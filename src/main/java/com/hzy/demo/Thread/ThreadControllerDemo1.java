package com.hzy.demo.Thread;

import com.hzy.demo.commons.JSONResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;

@RestController
@RequestMapping("ThreadController1")
public class ThreadControllerDemo1 {

    ExecutorService executorService = Executors.newFixedThreadPool(6);

    @GetMapping("/Demo1")
    public JSONResult Demo1(){
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int i = 0;
                for(int j=0;j<100;j++){
                    i++;
                    System.out.println("i+"+i);
                }
                TimeUnit.SECONDS.sleep(20);
                return i;

            }
        };
        Future<Integer> future0 = executorService.submit(callable);
        try {
            System.out.println();
        }catch (Exception e){
            System.out.println("发生异常");
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
        return JSONResult.build(200,"Demo1执行完毕",null);
    }
}
