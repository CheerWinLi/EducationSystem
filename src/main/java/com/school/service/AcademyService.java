package com.school.service;

/**
 * @author :Lictory
 * @date : 2024/05/15
 */
public interface AcademyService {

    /**
     *  通过专业名获取专业id
     * @param academyName 专业名
     * @return 专业id
     */
    Integer getAcademyIdByAcademyName(String academyName);
}
