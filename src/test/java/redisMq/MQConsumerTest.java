package redisMq;

import com.redisMq.RedisMqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

/**
 * @Auther ChenShuHong
 * @Date 2021-06-07 10:09
 */
@SpringBootTest(classes = RedisMqApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class MQConsumerTest {
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
  public void test() throws InterruptedException {
    while(true){
      //从右边取堆栈顺序取1~10个消息
      String msg = listRedis.rightPop("storage");
      if(StringUtils.isEmpty(msg)){
        System.out.println("消息已经全部取出了。。。。");
      //  break;
      }
      System.out.println(msg);
    }
  }
}

