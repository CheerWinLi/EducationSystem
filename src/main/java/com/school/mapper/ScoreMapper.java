package com.school.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.entity.po.Score;
import com.school.entity.vo.ScoreVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
@Repository
public interface ScoreMapper extends BaseMapper<Score> {
    /**
     * @param stuId
     * @return
     */
    List<ScoreVo> getScoresListByStuId(Integer stuId);

    List<ScoreVo> getScoresList();

    List<ScoreVo> getScoresLikeList(@Param("fieldName") String filedName, @Param("fieldValue") String filedValue);
}
