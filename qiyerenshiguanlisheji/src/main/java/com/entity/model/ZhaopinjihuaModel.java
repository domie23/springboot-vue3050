package com.entity.model;

import com.entity.ZhaopinjihuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 招聘计划
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhaopinjihuaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 招聘计划编号
     */
    private String zhaopinjihuaUuidName;


    /**
     * 招聘计划名称
     */
    private String zhaopinjihuaName;


    /**
     * 招聘计划类型
     */
    private Integer zhaopinjihuaTypes;


    /**
     * 招聘职位
     */
    private Integer zhiweiTypes;


    /**
     * 招聘人数
     */
    private Integer zhaopinRenshu;


    /**
     * 招聘计划详情
     */
    private String zhaopinjihuaContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：招聘计划编号
	 */
    public String getZhaopinjihuaUuidName() {
        return zhaopinjihuaUuidName;
    }


    /**
	 * 设置：招聘计划编号
	 */
    public void setZhaopinjihuaUuidName(String zhaopinjihuaUuidName) {
        this.zhaopinjihuaUuidName = zhaopinjihuaUuidName;
    }
    /**
	 * 获取：招聘计划名称
	 */
    public String getZhaopinjihuaName() {
        return zhaopinjihuaName;
    }


    /**
	 * 设置：招聘计划名称
	 */
    public void setZhaopinjihuaName(String zhaopinjihuaName) {
        this.zhaopinjihuaName = zhaopinjihuaName;
    }
    /**
	 * 获取：招聘计划类型
	 */
    public Integer getZhaopinjihuaTypes() {
        return zhaopinjihuaTypes;
    }


    /**
	 * 设置：招聘计划类型
	 */
    public void setZhaopinjihuaTypes(Integer zhaopinjihuaTypes) {
        this.zhaopinjihuaTypes = zhaopinjihuaTypes;
    }
    /**
	 * 获取：招聘职位
	 */
    public Integer getZhiweiTypes() {
        return zhiweiTypes;
    }


    /**
	 * 设置：招聘职位
	 */
    public void setZhiweiTypes(Integer zhiweiTypes) {
        this.zhiweiTypes = zhiweiTypes;
    }
    /**
	 * 获取：招聘人数
	 */
    public Integer getZhaopinRenshu() {
        return zhaopinRenshu;
    }


    /**
	 * 设置：招聘人数
	 */
    public void setZhaopinRenshu(Integer zhaopinRenshu) {
        this.zhaopinRenshu = zhaopinRenshu;
    }
    /**
	 * 获取：招聘计划详情
	 */
    public String getZhaopinjihuaContent() {
        return zhaopinjihuaContent;
    }


    /**
	 * 设置：招聘计划详情
	 */
    public void setZhaopinjihuaContent(String zhaopinjihuaContent) {
        this.zhaopinjihuaContent = zhaopinjihuaContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
