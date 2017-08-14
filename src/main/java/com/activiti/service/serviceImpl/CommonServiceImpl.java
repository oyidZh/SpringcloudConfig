package com.activiti.service.serviceImpl;

import com.activiti.common.utils.CommonUtil;
import com.activiti.service.CommonService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

/**
 * Created by 12490 on 2017/8/14.
 */
@Service
@EnableCaching
public class CommonServiceImpl implements CommonService {
    @Autowired
    private CommonUtil commonUtil;

    /**
     * 从gitlab取题目数据
     *
     * @param url
     * @return
     */
    @Override
    @Cacheable(value="test",key="'QAFromGitLab_'+#url")
    public JSONObject getQAFromGitLab(String url) {
        return commonUtil.getQAFromGitLab(url);
    }
}
