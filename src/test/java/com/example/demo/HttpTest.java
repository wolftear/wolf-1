package com.example.demo;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.example.demo.util.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2020/9/22
 **/
public class HttpTest {
    private static final Logger logger = LoggerFactory.getLogger(HttpTest.class);

    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        HttpResponse httpResponse = HttpRequest.get("https://www.baidu.com/").timeout(5000).execute();
        Long endTime = System.currentTimeMillis();
        logger.info("status:{},time:{}",httpResponse.getStatus(),(endTime - startTime));
    }
}
