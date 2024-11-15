package com.school.service;

/**
 * @author :Lictory
 * @date : 2024/05/15
 */
public interface MajorService {


    /**
     *   get major id by major name
     * @param majorName  major name
     * @return  major id
     */
    Integer  getMajorIdByMajorName(String majorName);
}
