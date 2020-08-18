package com.jk.service;

import com.jk.entity.PeopleEntity;
import com.jk.mapper.UserMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper userMapper;

    @Override
    @RequestMapping("/findPeopleList")
    public List<PeopleEntity> findpeopleList() {
        return userMapper.findpeopleList();
    }


}
