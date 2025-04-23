package com.entity.view;

import com.entity.ZhaopinjihuaEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 招聘计划
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zhaopinjihua")
public class ZhaopinjihuaView extends ZhaopinjihuaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 招聘计划类型的值
		*/
		private String zhaopinjihuaValue;
		/**
		* 招聘职位的值
		*/
		private String zhiweiValue;



	public ZhaopinjihuaView() {

	}

	public ZhaopinjihuaView(ZhaopinjihuaEntity zhaopinjihuaEntity) {
		try {
			BeanUtils.copyProperties(this, zhaopinjihuaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 招聘计划类型的值
			*/
			public String getZhaopinjihuaValue() {
				return zhaopinjihuaValue;
			}
			/**
			* 设置： 招聘计划类型的值
			*/
			public void setZhaopinjihuaValue(String zhaopinjihuaValue) {
				this.zhaopinjihuaValue = zhaopinjihuaValue;
			}
			/**
			* 获取： 招聘职位的值
			*/
			public String getZhiweiValue() {
				return zhiweiValue;
			}
			/**
			* 设置： 招聘职位的值
			*/
			public void setZhiweiValue(String zhiweiValue) {
				this.zhiweiValue = zhiweiValue;
			}
















}
