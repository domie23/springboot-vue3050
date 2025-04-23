package com.entity.model;

import com.entity.PeixunjihuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 培训计划
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class PeixunjihuaModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 职工
     */
    private Integer zhigongId;


    /**
     * 培训计划编号
     */
    private String peixunjihuaUuidNumber;


    /**
     * 培训计划标题
     */
    private String peixunjihuaName;


    /**
     * 培训计划类型
     */
    private Integer peixunjihuaTypes;


    /**
     * 培训开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date kaishiTime;


    /**
     * 培训结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jieshuTime;


    /**
     * 培训内容
     */
    private String peixunjihuaContent;


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
	 * 获取：职工
	 */
    public Integer getZhigongId() {
        return zhigongId;
    }


    /**
	 * 设置：职工
	 */
    public void setZhigongId(Integer zhigongId) {
        this.zhigongId = zhigongId;
    }
    /**
	 * 获取：培训计划编号
	 */
    public String getPeixunjihuaUuidNumber() {
        return peixunjihuaUuidNumber;
    }


    /**
	 * 设置：培训计划编号
	 */
    public void setPeixunjihuaUuidNumber(String peixunjihuaUuidNumber) {
        this.peixunjihuaUuidNumber = peixunjihuaUuidNumber;
    }
    /**
	 * 获取：培训计划标题
	 */
    public String getPeixunjihuaName() {
        return peixunjihuaName;
    }


    /**
	 * 设置：培训计划标题
	 */
    public void setPeixunjihuaName(String peixunjihuaName) {
        this.peixunjihuaName = peixunjihuaName;
    }
    /**
	 * 获取：培训计划类型
	 */
    public Integer getPeixunjihuaTypes() {
        return peixunjihuaTypes;
    }


    /**
	 * 设置：培训计划类型
	 */
    public void setPeixunjihuaTypes(Integer peixunjihuaTypes) {
        this.peixunjihuaTypes = peixunjihuaTypes;
    }
    /**
	 * 获取：培训开始时间
	 */
    public Date getKaishiTime() {
        return kaishiTime;
    }


    /**
	 * 设置：培训开始时间
	 */
    public void setKaishiTime(Date kaishiTime) {
        this.kaishiTime = kaishiTime;
    }
    /**
	 * 获取：培训结束时间
	 */
    public Date getJieshuTime() {
        return jieshuTime;
    }


    /**
	 * 设置：培训结束时间
	 */
    public void setJieshuTime(Date jieshuTime) {
        this.jieshuTime = jieshuTime;
    }
    /**
	 * 获取：培训内容
	 */
    public String getPeixunjihuaContent() {
        return peixunjihuaContent;
    }


    /**
	 * 设置：培训内容
	 */
    public void setPeixunjihuaContent(String peixunjihuaContent) {
        this.peixunjihuaContent = peixunjihuaContent;
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
