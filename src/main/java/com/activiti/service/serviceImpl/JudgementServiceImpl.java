package com.activiti.service.serviceImpl;

import com.activiti.mapper.JudgementMapper;
import com.activiti.pojo.user.JudgementLs;
import com.activiti.pojo.user.StudentWorkInfo;
import com.activiti.service.JudgementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching
public class JudgementServiceImpl implements JudgementService {
    @Autowired
    private JudgementMapper judgementMapper;

    @Override
    public int commitWork(StudentWorkInfo studentWorkInfo) {
        return judgementMapper.commitWork(studentWorkInfo);
    }

    @Override
    public int updateStuGrade(StudentWorkInfo studentWorkInfo) {
        return judgementMapper.updateStuGrade(studentWorkInfo);
    }

    @Override
    public int updateStuJudgeTime(StudentWorkInfo studentWorkInfo) {
        return judgementMapper.updateStuJudgeTime(studentWorkInfo);
    }

    @Override
    public int insertJudgementLs(List<JudgementLs> list) {
        return judgementMapper.insertJudgementLs(list);
    }

    @Override
    public StudentWorkInfo selectStudentWorkInfo(StudentWorkInfo studentWorkInfo) {
        return judgementMapper.selectStudentWorkInfo(studentWorkInfo);
    }

    @Override
    public List<JudgementLs> selectJudgementLs(JudgementLs judgementLs) {
        return judgementMapper.selectJudgementLs(judgementLs);
    }

    @Cacheable(value = "ehCache300", keyGenerator = "keyGenerator")
    @Override
    public int countAllWorks(String courseCode) {
        return judgementMapper.countAllWorks(courseCode);
    }

    @Override
    public int selectChaosId(String emailAddress) {
        return judgementMapper.selectChaosId(emailAddress);
    }
}
