package com.activiti.controller;

import com.activiti.service.CommonService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 12490 on 2017/8/14.
 */
@RestController
@RequestMapping("/common")
public class CommonController {
    @Autowired
    private CommonService commonService;

    /**
     * gitlab请求题目和答案
     *
     * @param qDir
     * @param qNo
     * @return
     */
    @RequestMapping("/getQAContent")
    @ResponseBody
    public JSONObject getQAFromGitLab(@RequestParam(value = "qDir", required = true) String qDir, @RequestParam(value = "qNo", required = true) String qNo) {
        return commonService.getQAFromGitLab(qDir, qNo);
    }
}
