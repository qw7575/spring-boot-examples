package com.qw.boot.examples.controller;

import com.qw.boot.examples.service.ServiceF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Future;


/**
 * ����
 *
 * @author: 72153169--����
 * @date: 2021/9/30 16:10
 * @Copyright (c) 2021/9/30 vivo Tech
 */

@Controller
public class AsyncController {

    @Autowired
    private ServiceF sf;

    /**
     * �޷���ֵ
     */
    @RequestMapping("/getfTest")
    @ResponseBody
    public void getfTest() {
        for (int i = 0; i < 100; i++) {
            System.out.println("ѭ�����У�"+i);
            sf.get01();
            sf.get02();
        }
    }

    /**
     * �з���ֵ���԰��̳߳طŴ�Щ
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping("/zszExecute")
    @ResponseBody
    public String zszExecute(HttpServletRequest req) throws Exception {
        String url = req.getParameter("url") == null ? "" : req.getParameter("url");
        Future<String> future = sf.execute(url);
        return future.get();
    }
}