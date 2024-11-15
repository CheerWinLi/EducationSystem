package com.school.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.school.entity.bo.AddScoreBo;
import com.school.entity.po.Score;
import com.school.entity.vo.ScoreVo;
import com.school.mapper.ScoreMapper;
import com.school.service.CourseService;
import com.school.service.ScoreService;
import com.school.service.StuClassScoreService;
import com.school.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreService {

    @Autowired
    private ScoreMapper scoreMapper;

    @Autowired
    private StuClassScoreService stuClassScoreService;

    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;

    @Override
    public List<ScoreVo> getScoreListByStuId(Integer stuId) {
        return scoreMapper.getScoresListByStuId(stuId);
    }

    @Override
    public List<ScoreVo> getScoreList() {
        return scoreMapper.getScoresList();
    }

    @Override
    public List<ScoreVo> getScoreLikeList(String fieldName, String fieldValue) {
        return scoreMapper.getScoresLikeList(fieldName, fieldValue);
    }

    @Override
    public Boolean addScore(AddScoreBo addScoreBo) {
        Score score = new Score();
        score.setScore(addScoreBo.getScore())
                .setCourseId(addScoreBo.getCourseId())
                .setStudentId(addScoreBo.getStudentId());
        scoreMapper.insert(score);
        stuClassScoreService.addScore(addScoreBo.getStudentId(), addScoreBo.getCourseId(), score.getId());
        return true;
    }

    @Override
    public Boolean deleteScore(Integer id) {
        scoreMapper.deleteById(id);
        return true;
    }

}
