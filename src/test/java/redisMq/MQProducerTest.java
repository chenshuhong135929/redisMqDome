package redisMq;

import com.redisMq.RedisMqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;

/**
 * @Auther ChenShuHong
 * @Date 2021-06-07 10:07
 * 生产者
 */
  @SpringBootTest(classes = RedisMqApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
  @RunWith(SpringRunner.class)
  public class MQProducerTest {
    @Autowired
    private StringRedisTemplate redisTemplate;
    //redis的消息队列直接使用redis数组实现
    private ListOperations<String, String> listRedis;

    /**
     * 初始化时赋值
     */
    @PostConstruct
    private void init(){
      listRedis = redisTemplate.opsForList();
    }

    @Test
    public void test() {
      for(int i=1; i<=10; i++){
        //从左边向堆栈顺序存放1~10个消息
        listRedis.leftPush("storage", i+"");
      }
    }

}
