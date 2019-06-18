package com.fengjf.demo.commonfeignapi.servicehi;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Author fengjf
 * Desc
 */
@FeignClient("service-say")
public interface ServiceSayFeign {

    @ApiOperation(value = "say Hello", notes = "")
    @GetMapping("/hi")
    String home(@RequestParam(value = "name", defaultValue = "forezp") String name);
}
