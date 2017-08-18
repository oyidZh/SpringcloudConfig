package com.activiti.mapper;

import com.activiti.pojo.schedule.ScheduleDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 12490 on 2017/8/19.
 */
@Repository
public interface ScheduleMapper {

    ScheduleDto selectScheduleTime(String courseCode);

    void insertScheduleTime(ScheduleDto scheduleDto);

    void updateScheduleTime(ScheduleDto scheduleDto);

    List<ScheduleDto> selectAllScheduleTime();

}
