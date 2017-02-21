package com.xia.lawyer.dao.system;

import com.xia.lawyer.models.system.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by lindeng on 2/17/2017.
 */
public interface UserDao extends CrudRepository<User,String>{

    User findByUsername(String username);
}
