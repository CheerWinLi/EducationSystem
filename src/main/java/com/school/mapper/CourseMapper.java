package com.school.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.entity.po.Course;
import com.school.entity.vo.CourseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author :Lictory
 * @date : 2024/05/13
 */
@Repository
public interface CourseMapper extends BaseMapper<Course> {

    /**
     *
     * @param stuId
     * @return
     */
    List<CourseVo> getCourseListByStuId(@Param("studentId") Integer stuId);

    /**
     *
     * @param fieldName
     * @param fieldValue
     * @return
     */
    List<CourseVo> getCourseLikeList(@Param("fieldName") String fieldName, @Param("fieldValue") String fieldValue);
}
