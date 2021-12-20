package com.mall.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.mall.pojo.goods.Brand;
import com.mall.service.goods.BrandService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;
    @GetMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }
}
