package com.activiti.controller;

import com.activiti.pojo.schedule.ScheduleDto;
import com.activiti.service.CommonService;
import com.activiti.service.ScheduleService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 12490 on 2017/8/14.
 */
@RestController
@RequestMapping("/common")
public class CommonController {
    @Autowired
    private CommonService commonService;
    @Autowired
    private ScheduleService scheduleService;

    /**
     * gitlab请求题目和答案
     *
     * @param qDir
     * @param qNo
     * @return
     */
    @RequestMapping("/getQAContent")
    @ResponseBody
    public JSONObject getQAFromGitLab(@RequestParam(value = "qDir", required = true) String qDir,
                                      @RequestParam(value = "qNo", required = true) String qNo) {
        return commonService.getQAFromGitLab(qDir, qNo);
    }

    /**
     * 查询指定课程的互评时间表
     *
     * @param courseCode
     * @return
     */
    @RequestMapping("/selectScheduleTime")
    @ResponseBody
    public ScheduleDto selectScheduleTime(@RequestParam(value = "courseCode", required = true) String courseCode) {
        return scheduleService.selectScheduleTime(courseCode);
    }

    /**
     * 插入指定课程的互评时间
     *
     * @param scheduleDto
     * @return
     */
    @RequestMapping("/insertScheduleTime")
    @ResponseBody
    public ScheduleDto insertScheduleTime(@RequestParam(value = "schedule", required = true) ScheduleDto scheduleDto) throws Exception {
        String courseCode = scheduleDto.getCourseCode();
        if (null == courseCode) throw new Exception("courseCode字段不能为空");
        scheduleService.insertScheduleTime(scheduleDto);
        return scheduleService.selectScheduleTime(courseCode);
    }

    /**
     * 更新指定课程的互评时间
     *
     * @param scheduleDto
     * @return
     */
    @RequestMapping("/updateScheduleTime")
    @ResponseBody
    public ScheduleDto updateScheduleTime(@RequestParam(value = "schedule", required = true) ScheduleDto scheduleDto) throws Exception {
        String courseCode = scheduleDto.getCourseCode();
        if (null == courseCode) throw new Exception("courseCode字段不能为空");
        scheduleService.updateScheduleTime(scheduleDto);
        return scheduleService.selectScheduleTime(courseCode);
    }

    /**
     * 查询所有课程相关的时间表
     *
     * @return
     */
    @RequestMapping("/selectAllScheduleTime")
    @ResponseBody
    public List<ScheduleDto> selectAllScheduleTime() {
        return scheduleService.selectAllScheduleTime();
    }

    /**
     * 查询指定课程所处的阶段
     *
     * @return
     */
    @RequestMapping("/selectTimeStage")
    @ResponseBody
    public List<ScheduleDto> selectAllScheduleTime(@RequestParam(value = "courseCode", required = true) String courseCode) {
        return scheduleService.selectAllScheduleTime();
    }
}
