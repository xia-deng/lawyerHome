package com.xia.lawyer.controller.system.user;

import com.xia.lawyer.controller.ControllerInterface;
import com.xia.lawyer.models.ResponseMsg;
import com.xia.lawyer.models.system.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lindeng on 2/17/2017.
 */
@Controller
@RequestMapping(value = "/system/user")
public class UserController implements ControllerInterface<User>{


    @Override
    @RequestMapping(value = "index")
    public String index() {
        return "system/user/userInfo";
    }

    @Override
    public ResponseMsg<User> add(User user) {
        return null;
    }

    @Override
    public ResponseMsg<User> deleteT(Object id) {
        return null;
    }

    @Override
    public ResponseMsg<User> update(User user) {
        return null;
    }
}
