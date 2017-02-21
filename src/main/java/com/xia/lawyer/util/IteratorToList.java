package com.xia.lawyer.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lindeng on 2/17/2017.
 */
public class IteratorToList {
    public static List iteratorToList(Iterator iterator){
        List list=new ArrayList();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }
}
