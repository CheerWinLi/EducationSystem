package com.school.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.school.entity.po.Academy;
import com.school.mapper.AcademyMapper;
import com.school.service.AcademyService;
import org.springframework.stereotype.Service;

/**
 * @author :Lictory
 * @date : 2024/05/15
 */
@Service
public class AcademyServiceImpl extends ServiceImpl<AcademyMapper, Academy> implements AcademyService {
    @Override
    public Integer getAcademyIdByAcademyName(String academyName) {
        LambdaQueryWrapper<Academy> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Academy::getName,academyName);
        return baseMapper.selectOne(wrapper).getId();
    }
}
