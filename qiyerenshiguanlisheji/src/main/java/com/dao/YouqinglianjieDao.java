package com.dao;

import com.entity.YouqinglianjieEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YouqinglianjieView;

/**
 * 友情链接 Dao 接口
 *
 * @author 
 */
public interface YouqinglianjieDao extends BaseMapper<YouqinglianjieEntity> {

   List<YouqinglianjieView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
