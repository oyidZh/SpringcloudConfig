package com.activiti.pojo.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生作业相关
 * Created by 12490 on 2017/8/20.
 */
public class StudentWorkInfo implements Serializable {
    private static final long serialVersionUID = 2120869894112984147L;
    private String courseCode;
    private String emailAddress;
    private String workDetail;
    private Date lastCommitTime;
    private Double grade;
    private String judgeType;  //teacher：老師评分  student:学生互评
    private int judgeTimes;      //每份作业互评次数

    public StudentWorkInfo() {
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getWorkDetail() {
        return workDetail;
    }

    public void setWorkDetail(String workDetail) {
        this.workDetail = workDetail;
    }

    public Date getLastCommitTime() {
        return lastCommitTime;
    }

    public void setLastCommitTime(Date lastCommitTime) {
        this.lastCommitTime = lastCommitTime;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public String getJudgeType() {
        return judgeType;
    }

    public void setJudgeType(String judgeType) {
        this.judgeType = judgeType;
    }

    public int getJudgeTimes() {
        return judgeTimes;
    }

    public void setJudgeTimes(int judgeTimes) {
        this.judgeTimes = judgeTimes;
    }

    @Override
    public String toString() {
        return "StudentWorkInfo{" +
                "courseCode='" + courseCode + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", workDetail='" + workDetail + '\'' +
                ", lastCommitTime=" + lastCommitTime +
                ", grade=" + grade +
                ", judgeType='" + judgeType + '\'' +
                ", judgeTimes=" + judgeTimes +
                '}';
    }
}
