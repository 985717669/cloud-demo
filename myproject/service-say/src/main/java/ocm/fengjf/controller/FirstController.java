package ocm.fengjf.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fengjf
 * @Desc
 **/
@RestController
@Api(description = "测试")
@RefreshScope
public class FirstController {


    @Value("${server.port}")
    String port;

    @Value("${foo.name}")
    String fooName;



    @ApiOperation(value = "say Hello", notes = "")
    @GetMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port + "  name :" + fooName;
    }
}
