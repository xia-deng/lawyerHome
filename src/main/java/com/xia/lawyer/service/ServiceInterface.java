package com.xia.lawyer.service;

import com.xia.lawyer.models.ResponseMsg;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lindeng on 2/17/2017.
 */
public interface ServiceInterface<T> {
    List<T> find();
    ResponseMsg<T> add(T t);
    ResponseMsg<T> update(T t);
    ResponseMsg<T> delete(Object id);

    public default List<T> iteratorToList(Iterator<T> iterator){
        List<T> list=new ArrayList<T>();
        while(iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }
}
