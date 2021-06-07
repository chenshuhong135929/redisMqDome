package redisMq;

import com.redisMq.RedisMqApplication;
import com.redisMq.service.PublishService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther ChenShuHong
 * @Date 2021-06-07 10:43
 * 发布主题测试
 */
@SpringBootTest(classes = RedisMqApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class PublishTest {

  @Autowired
  private PublishService publishService;

  @Test
  public void test() {
    for(int i=1; i<=10; i++){
      //向dj主题里发布10个消息
      publishService.publish("dj", "like "+i+" 次");
    }
  }
}
