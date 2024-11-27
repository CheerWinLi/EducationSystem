package com.school.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.school.entity.po.StuCourseScore;
import com.school.mapper.StuClassScoreMapper;
import com.school.service.StuClassScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
@Service
public class StuClassScoreServiceImpl extends ServiceImpl<StuClassScoreMapper, StuCourseScore> implements StuClassScoreService {

    @Autowired
    private StuClassScoreMapper stuClassScoreMapper;

    @Override
    public List<StuCourseScore> getStuClassScoreByStuId(Integer stuId) {
        LambdaQueryWrapper<StuCourseScore> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(StuCourseScore::getStudentId, stuId);
        return stuClassScoreMapper.selectList(wrapper);
    }

    @Override
    public Boolean addScore(Integer stuId, Integer courseId, Integer scoreId) {
        stuClassScoreMapper.insert(new StuCourseScore()
                .setStudentId(stuId)
                .setCourseId(courseId)
                .setScoreId(scoreId));
        return true;
    }

    @Override
    public Boolean add(Integer stuId, Integer courseId) {
        stuClassScoreMapper.insert(new StuCourseScore()
                .setStudentId(stuId)
                .setCourseId(courseId));
        return true;
    }

    @Override
    public Boolean delete(String studentId, Integer courseId) {
         //根据studentId跟courseId删除
        stuClassScoreMapper.delete(new LambdaQueryWrapper<StuCourseScore>()
                .eq(StuCourseScore::getStudentId, studentId)
                .eq(StuCourseScore::getCourseId, courseId));
        return true;
    }

    @Override
    public Boolean delete(String studentId) {
        //根据studentId删除
        stuClassScoreMapper.delete(new LambdaQueryWrapper<StuCourseScore>()
                .eq(StuCourseScore::getStudentId, studentId));
        return true;
    }
}
