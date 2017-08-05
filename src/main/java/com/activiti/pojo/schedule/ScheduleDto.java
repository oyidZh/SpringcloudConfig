package com.activiti.pojo.schedule;

import java.io.Serializable;
import java.util.Date;

/**
 * 互评时间表
 * Created by 12490 on 2017/8/6.
 */
public class ScheduleDto implements Serializable {
    private static final long serialVersionUID = 2120869894112984147L;

    private String courseName;  //课程名称
    private String courseCode;  //课程代码
    private Date startTime;    //作业开始时间时间
    private Date commitEndTime;   //提交作业结束时间（互评开始时间）
    private Date finishTime;    //互评结束时间
    private Date publishTime;    //发布成绩时间

    public ScheduleDto() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getCommitEndTime() {
        return commitEndTime;
    }

    public void setCommitEndTime(Date commitEndTime) {
        this.commitEndTime = commitEndTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    @Override
    public String toString() {
        return "ScheduleDto{" +
                "courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", startTime=" + startTime +
                ", commitEndTime=" + commitEndTime +
                ", finishTime=" + finishTime +
                ", publishTime=" + publishTime +
                '}';
    }
}
