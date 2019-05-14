package ocm.fengjf.stream;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Author fengjf
 * Desc  生成kafka消息
 */
@Service
public class ProductKafkaMessage {
    @Autowired
    private KafkaTemplate kafkaTemplate;


    public void sendKafkaMessage(String topic, Object object) {
        kafkaTemplate.send(topic, JSON.toJSONString(object));
        System.err.println("发送一条消息  " + object);
    }
}
