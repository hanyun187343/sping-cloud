package com.jk.service;

import com.jk.entity.PeopleEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/error")
@Component
public class UserServiceFallback implements UserServiceFeign {

    @Override
    @RequestMapping("/findPeopleList")
    public List findpeopleList() {
        System.out.println("熔断器 来了");
        String i = "网络延迟";
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(i);
        return objects;
    }


}
