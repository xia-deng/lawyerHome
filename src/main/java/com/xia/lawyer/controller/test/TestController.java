package com.xia.lawyer.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lindeng on 2/17/2017.
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    @RequestMapping(value = "test")
    public String test(ModelMap map) {
        map.put("name", "ResponseMsg User");
        return "test";
    }
}
