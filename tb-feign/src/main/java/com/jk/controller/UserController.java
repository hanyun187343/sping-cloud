package com.jk.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.entity.PeopleEntity;
import com.jk.service.UserService;
import com.jk.utils.CheckSumBuilder;
import com.jk.utils.Constant;
import com.jk.utils.HttpClientUtil;
import com.jk.utils.RedisUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping("/findPeopleList")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "sdsand")
    public List<PeopleEntity> peopleList(){
        List<PeopleEntity> userList  =(List<PeopleEntity>) redisUtil.get(Constant.SELECT_USER_LIST);
        // 1. 有值   2. 没有值
        if (userList==null ||  userList.size()<=0 || userList.isEmpty()){
            // 从数据库查询，存redis
            userList =   userService.findpeopleList();
            redisUtil.set(Constant.SELECT_USER_LIST,userList,30);
        }
        return   userList;
    }



    private List<PeopleEntity> sdsand() throws Exception {
        ArrayList<PeopleEntity> peopleEntities = new ArrayList<>();
        PeopleEntity peopleEntity = new PeopleEntity();

       /*String userPhone = "";
        HashMap hashMap = new HashMap<String, Object>();
        HashMap<String, Object> headers = new HashMap<String, Object>();
        headers.put("AppKey", Constant.APP_KEY);
        String nonce = UUID.randomUUID().toString().replaceAll("-", "");
        headers.put("Nonce",nonce);
        String curTime = System.currentTimeMillis()+"";
        headers.put("CurTime", curTime);
        headers.put("CheckSum", CheckSumBuilder.getCheckSum(Constant.APP_SECRET, nonce, curTime));

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("mobile", userPhone);
        params.put("templateid", Constant.TEMPLATEID);
        int authCode = 1314521;
        params.put("authCode",authCode);

        String post = HttpClientUtil.post(Constant.SMS_URL, params, headers);
        JSONObject parseObject = JSON.parseObject(post);
        int code = parseObject.getIntValue("code");
        if (code!=200) {
            System.out.println(" 发送失败");
        }
        //发送验证码成功只存在五分钟
        redisTemplate.opsForValue().set(Constant.SMS_CODE+userPhone, authCode, 5, TimeUnit.MINUTES);
        //将用户发送状态锁定60秒
        redisTemplate.opsForValue().set(Constant.SMS_LOCK+userPhone, "lock", 60, TimeUnit.SECONDS);

        System.out.println(" 发送成功");*/

        peopleEntity.setName("降级。。。。");
        peopleEntities.add(peopleEntity);
        return peopleEntities;
    }









}
