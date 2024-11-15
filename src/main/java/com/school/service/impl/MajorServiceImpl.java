package com.school.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.school.entity.po.Major;
import com.school.mapper.MajorMapper;
import com.school.service.MajorService;

import org.springframework.stereotype.Service;

/**
 * @author :Lictory
 * @date : 2024/05/15
 */

@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major>implements MajorService {
    @Override
    public Integer getMajorIdByMajorName(String majorName) {
        LambdaQueryWrapper<Major> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Major::getMajorName,majorName);
        return baseMapper.selectOne(wrapper).getId();
    }
}
