package com.mall.service.goods;
import com.mall.entity.PageResult;
import com.mall.pojo.goods.Album;

import java.util.*;

/**
 * album业务逻辑层
 */
public interface AlbumService {


    public List<Album> findAll();


    public PageResult<Album> findPage(int page, int size);


    public List<Album> findList(Map<String,Object> searchMap);


    public PageResult<Album> findPage(Map<String,Object> searchMap,int page, int size);


    public Album findById(Long id);

    public void add(Album album);


    public void update(Album album);


    public void delete(Long id);

}
