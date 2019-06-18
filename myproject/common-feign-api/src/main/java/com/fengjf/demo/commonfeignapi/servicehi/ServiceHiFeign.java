package com.fengjf.demo.commonfeignapi.servicehi;

import com.fengjf.Stu;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author fengjf
 * Desc
 */
@FeignClient(value = "service-hi")
public interface ServiceHiFeign {

    @ApiOperation(value = "say Hello", notes = "")
    @GetMapping("/hi")
    String home(@RequestParam(value = "name", defaultValue = "forezp") String name);

    @ApiOperation(value = "say Hello", notes = "")
    @GetMapping("/stu")
    Stu stu();
}
