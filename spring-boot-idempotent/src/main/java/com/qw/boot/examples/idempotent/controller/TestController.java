package com.qw.boot.examples.idempotent.controller;

import com.alibaba.fastjson.JSONObject;
import com.qw.boot.examples.base.util.R;
import com.qw.boot.examples.idempotent.annotation.Idempotent;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * (用一句话描述该文件做什么)
 *
 * @author qiwu
 * <br> Date : 2020/12/23 6:21 下午
 * <br> Copyright (c) 2020/12/23 ZiYun Tech.
 */
@Controller
public class TestController {

    @RequestMapping("/orderStatePush2")
    @ResponseBody
    @Idempotent(key = "orderStatePush2", expirMillis = 2)
    public R orderStatePush2(@RequestParam("name") String name) {
        System.out.println("订单状态推送：" + JSONObject.toJSONString(name));
        return R.ok("订单状态推送：" + JSONObject.toJSONString(name));
    }

}
