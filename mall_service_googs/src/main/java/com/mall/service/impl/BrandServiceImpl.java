package com.mall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.mall.dao.BrandMapper;
import com.mall.pojo.goods.Brand;
import com.mall.service.goods.BrandService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }
}
