package com.jk.service;

import com.jk.entity.PeopleEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "tb-provider-two",fallback = UserServiceFallback.class)
public interface UserServiceFeign extends UserService{



}
