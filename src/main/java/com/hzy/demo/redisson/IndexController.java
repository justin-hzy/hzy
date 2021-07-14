package com.hzy.demo.redisson;



import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
public class IndexController {


    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private Redisson redisson;

    @RequestMapping(value = "/deduct_stock", produces = "application/json;charset=utf-8")
    public String deductStock(){

        //使用jvm级别的锁,实现锁的控制
        /*synchronized (this){
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));

            if (stock>0){
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock",realStock+"");
                System.out.println("扣减成功，剩余库存:"+realStock);
            }else {
                System.out.println("扣减不成功");
            }
        }*/

        /*redis分布式锁*/
        /*String clientId = UUID.randomUUID().toString();
        String lockKey = "product_101";
        Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey,clientId,10,TimeUnit.SECONDS);
        if(!result){
            return "error_code";
        }*/
        String lockKey = "product_101";
        RLock redissonLock = redisson.getLock(lockKey);

        try{
            redissonLock.lock();
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));

            if (stock>0){
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock",realStock+"");
                System.out.println("扣减成功，剩余库存:"+realStock);
            }else {
                System.out.println("扣减不成功");
            }
        }finally {
            /*if (clientId.equals(stringRedisTemplate.opsForValue().get(lockKey))){
                stringRedisTemplate.delete(lockKey);
            }*/
            redissonLock.unlock();
        }
        return "end";
    }
}
