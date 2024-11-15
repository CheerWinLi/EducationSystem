package com.school.service;

import java.util.List;

import com.school.entity.bo.AddScoreBo;
import com.school.entity.vo.ScoreVo;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
public interface ScoreService {

    /**
     * @param stuId
     * @return
     */
    List<ScoreVo> getScoreListByStuId(Integer stuId);

    List<ScoreVo> getScoreList();

    List<ScoreVo> getScoreLikeList(String fieldName, String fieldValue);

    Boolean addScore(AddScoreBo addScoreBo);

    Boolean deleteScore(Integer id);
}
