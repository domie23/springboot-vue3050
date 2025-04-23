package com.entity.view;

import com.entity.XinziEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 薪资
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("xinzi")
public class XinziView extends XinziEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 zhigong
			/**
			* 职工姓名
			*/
			private String zhigongName;
			/**
			* 职工手机号
			*/
			private String zhigongPhone;
			/**
			* 职工身份证号
			*/
			private String zhigongIdNumber;
			/**
			* 职工头像
			*/
			private String zhigongPhoto;
			/**
			* 电子邮箱
			*/
			private String zhigongEmail;
			/**
			* 部门
			*/
			private Integer bumenTypes;
				/**
				* 部门的值
				*/
				private String bumenValue;
			/**
			* 职位
			*/
			private Integer zhiweiTypes;
				/**
				* 职位的值
				*/
				private String zhiweiValue;

	public XinziView() {

	}

	public XinziView(XinziEntity xinziEntity) {
		try {
			BeanUtils.copyProperties(this, xinziEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}































				//级联表的get和set zhigong

					/**
					* 获取： 职工姓名
					*/
					public String getZhigongName() {
						return zhigongName;
					}
					/**
					* 设置： 职工姓名
					*/
					public void setZhigongName(String zhigongName) {
						this.zhigongName = zhigongName;
					}

					/**
					* 获取： 职工手机号
					*/
					public String getZhigongPhone() {
						return zhigongPhone;
					}
					/**
					* 设置： 职工手机号
					*/
					public void setZhigongPhone(String zhigongPhone) {
						this.zhigongPhone = zhigongPhone;
					}

					/**
					* 获取： 职工身份证号
					*/
					public String getZhigongIdNumber() {
						return zhigongIdNumber;
					}
					/**
					* 设置： 职工身份证号
					*/
					public void setZhigongIdNumber(String zhigongIdNumber) {
						this.zhigongIdNumber = zhigongIdNumber;
					}

					/**
					* 获取： 职工头像
					*/
					public String getZhigongPhoto() {
						return zhigongPhoto;
					}
					/**
					* 设置： 职工头像
					*/
					public void setZhigongPhoto(String zhigongPhoto) {
						this.zhigongPhoto = zhigongPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getZhigongEmail() {
						return zhigongEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setZhigongEmail(String zhigongEmail) {
						this.zhigongEmail = zhigongEmail;
					}

					/**
					* 获取： 部门
					*/
					public Integer getBumenTypes() {
						return bumenTypes;
					}
					/**
					* 设置： 部门
					*/
					public void setBumenTypes(Integer bumenTypes) {
						this.bumenTypes = bumenTypes;
					}


						/**
						* 获取： 部门的值
						*/
						public String getBumenValue() {
							return bumenValue;
						}
						/**
						* 设置： 部门的值
						*/
						public void setBumenValue(String bumenValue) {
							this.bumenValue = bumenValue;
						}

					/**
					* 获取： 职位
					*/
					public Integer getZhiweiTypes() {
						return zhiweiTypes;
					}
					/**
					* 设置： 职位
					*/
					public void setZhiweiTypes(Integer zhiweiTypes) {
						this.zhiweiTypes = zhiweiTypes;
					}


						/**
						* 获取： 职位的值
						*/
						public String getZhiweiValue() {
							return zhiweiValue;
						}
						/**
						* 设置： 职位的值
						*/
						public void setZhiweiValue(String zhiweiValue) {
							this.zhiweiValue = zhiweiValue;
						}


}
