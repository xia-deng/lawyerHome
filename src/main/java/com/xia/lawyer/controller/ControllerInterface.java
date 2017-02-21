package com.xia.lawyer.controller;

import com.xia.lawyer.models.ResponseMsg;

/**
 * Created by lindeng on 2/17/2017.
 */
public interface ControllerInterface<T> {
    String index();
    ResponseMsg<T> add(T t);
    ResponseMsg<T> deleteT(Object id);
    ResponseMsg<T> update(T t);
}
