package com.fengjf.servicesleuth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author fengjf
 * Desc
 */
@RestController
public class Controller {
    @RequestMapping(value = "/getSome", method = RequestMethod.GET)
    public String getSome() {
        return "我是第一个服务器";
    }

    @RequestMapping(value = "/getOther", method = RequestMethod.GET)
    public String getOther() {
        return "我是第二个服务器";
    }

}
