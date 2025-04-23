package com.dao;

import com.entity.JiangjinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiangjinView;

/**
 * 奖金 Dao 接口
 *
 * @author 
 */
public interface JiangjinDao extends BaseMapper<JiangjinEntity> {

   List<JiangjinView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
