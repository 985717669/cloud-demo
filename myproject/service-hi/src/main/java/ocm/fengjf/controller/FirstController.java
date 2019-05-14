package ocm.fengjf.controller;

import com.fengjf.Stu;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import ocm.fengjf.stream.ProductKafkaMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author fengjf
 * @Desc
 **/
@RestController
@Api(description = "测试")
public class FirstController {


    @Resource
    ProductKafkaMessage productKafkaMessage;
    @Value("${server.port}")
    String port;

    @ApiOperation(value = "say Hello", notes = "")
    @GetMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    @ApiOperation(value = "say Hello", notes = "")
    @GetMapping("/stu")
    public Stu stu() {
        Stu stu = new Stu();
        stu.setAge(10);
        stu.setId(11);
        stu.setName("dddddd");
        productKafkaMessage.sendKafkaMessage("stu", stu);
        return stu;
    }


}
