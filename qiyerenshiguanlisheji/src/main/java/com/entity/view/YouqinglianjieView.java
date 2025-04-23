package com.entity.view;

import com.entity.YouqinglianjieEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 友情链接
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("youqinglianjie")
public class YouqinglianjieView extends YouqinglianjieEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 友情链接类型的值
		*/
		private String youqinglianjieValue;



	public YouqinglianjieView() {

	}

	public YouqinglianjieView(YouqinglianjieEntity youqinglianjieEntity) {
		try {
			BeanUtils.copyProperties(this, youqinglianjieEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 友情链接类型的值
			*/
			public String getYouqinglianjieValue() {
				return youqinglianjieValue;
			}
			/**
			* 设置： 友情链接类型的值
			*/
			public void setYouqinglianjieValue(String youqinglianjieValue) {
				this.youqinglianjieValue = youqinglianjieValue;
			}
















}
