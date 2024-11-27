package com.school.controller;

import com.school.common.CommonResult;
import com.school.entity.bo.AddScoreBo;
import com.school.entity.bo.AddStudentBo;
import com.school.entity.bo.LikeBo;
import com.school.entity.vo.ScoreVo;
import com.school.service.ScoreService;
import com.school.service.StuClassScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.util.List;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @Autowired
    private StuClassScoreService stuClassScoreService;

    @GetMapping("/score/list")
    CommonResult<List<ScoreVo>> getScoreListByStuId(Integer studentId) {
        return CommonResult.autoResult(true, scoreService.getScoreListByStuId(studentId));
    }

    @GetMapping("/score/lists")
    CommonResult<List<ScoreVo>> getScoreList() {
        return CommonResult.autoResult(true, scoreService.getScoreList());
    }


    @PostMapping("/score/likeList")
    CommonResult<List<ScoreVo>> getScoreLikeList(@RequestBody LikeBo likeBo) {
        return CommonResult.autoResult(true, scoreService.getScoreLikeList(likeBo.getFieldName(), likeBo.getFieldValue()));
    }

    @PostMapping("/score")
    CommonResult<Boolean> addScore(@RequestBody AddScoreBo addScoreBo) {
        return CommonResult.autoResult(scoreService.addScore(addScoreBo));
    }

    @DeleteMapping("/score")
    CommonResult<Boolean> deleteScore(@RequestParam("studentId") String studentId, @RequestParam("courseId") Integer courseId) {
        return CommonResult.autoResult(stuClassScoreService.delete(studentId, courseId));
    }
}
