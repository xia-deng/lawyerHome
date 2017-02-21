package com.xia.lawyer.service.system;

import com.xia.lawyer.models.system.User;
import com.xia.lawyer.service.ServiceInterface;

import java.util.List;

/**
 * Created by lindeng on 2/17/2017.
 */
public interface UserService extends ServiceInterface<User> {

    User findByUsername(String username);
}
