package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author yiche
 * @Description TODO
 * Date Created in 2019-08-19
 **/
@RestController
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/result")
    public Map<Object,Object> getResultTest() {
        Map<Object,Object> result = new HashMap<>();
        List<Map<Object,Object>> parentTagList = new ArrayList<Map<Object,Object>>();
        Map<Object,Object> mapItem1 = new HashMap<Object,Object>();
        mapItem1.put("id",1);
        mapItem1.put("name","人");
        parentTagList.add(mapItem1);
        List<Map<Object,Object>> secondTagList = new ArrayList<>();
        Map<Object,Object> mapItem2 = new HashMap<Object,Object>();
        mapItem2.put("id",1);
        mapItem2.put("name","女神驾到");
        mapItem2.put("tagId","1");
        secondTagList.add(mapItem2);
        result.put("parentTagList",parentTagList);
        result.put("secondTagList",secondTagList);
        return result;
    }
}
