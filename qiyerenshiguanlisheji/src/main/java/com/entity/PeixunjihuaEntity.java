package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 培训计划
 *
 * @author 
 * @email
 */
@TableName("peixunjihua")
public class PeixunjihuaEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public PeixunjihuaEntity() {

	}

	public PeixunjihuaEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 职工
     */
    @TableField(value = "zhigong_id")

    private Integer zhigongId;


    /**
     * 培训计划编号
     */
    @TableField(value = "peixunjihua_uuid_number")

    private String peixunjihuaUuidNumber;


    /**
     * 培训计划标题
     */
    @TableField(value = "peixunjihua_name")

    private String peixunjihuaName;


    /**
     * 培训计划类型
     */
    @TableField(value = "peixunjihua_types")

    private Integer peixunjihuaTypes;


    /**
     * 培训开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "kaishi_time")

    private Date kaishiTime;


    /**
     * 培训结束时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "jieshu_time")

    private Date jieshuTime;


    /**
     * 培训内容
     */
    @TableField(value = "peixunjihua_content")

    private String peixunjihuaContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：职工
	 */
    public Integer getZhigongId() {
        return zhigongId;
    }
    /**
	 * 获取：职工
	 */

    public void setZhigongId(Integer zhigongId) {
        this.zhigongId = zhigongId;
    }
    /**
	 * 设置：培训计划编号
	 */
    public String getPeixunjihuaUuidNumber() {
        return peixunjihuaUuidNumber;
    }
    /**
	 * 获取：培训计划编号
	 */

    public void setPeixunjihuaUuidNumber(String peixunjihuaUuidNumber) {
        this.peixunjihuaUuidNumber = peixunjihuaUuidNumber;
    }
    /**
	 * 设置：培训计划标题
	 */
    public String getPeixunjihuaName() {
        return peixunjihuaName;
    }
    /**
	 * 获取：培训计划标题
	 */

    public void setPeixunjihuaName(String peixunjihuaName) {
        this.peixunjihuaName = peixunjihuaName;
    }
    /**
	 * 设置：培训计划类型
	 */
    public Integer getPeixunjihuaTypes() {
        return peixunjihuaTypes;
    }
    /**
	 * 获取：培训计划类型
	 */

    public void setPeixunjihuaTypes(Integer peixunjihuaTypes) {
        this.peixunjihuaTypes = peixunjihuaTypes;
    }
    /**
	 * 设置：培训开始时间
	 */
    public Date getKaishiTime() {
        return kaishiTime;
    }
    /**
	 * 获取：培训开始时间
	 */

    public void setKaishiTime(Date kaishiTime) {
        this.kaishiTime = kaishiTime;
    }
    /**
	 * 设置：培训结束时间
	 */
    public Date getJieshuTime() {
        return jieshuTime;
    }
    /**
	 * 获取：培训结束时间
	 */

    public void setJieshuTime(Date jieshuTime) {
        this.jieshuTime = jieshuTime;
    }
    /**
	 * 设置：培训内容
	 */
    public String getPeixunjihuaContent() {
        return peixunjihuaContent;
    }
    /**
	 * 获取：培训内容
	 */

    public void setPeixunjihuaContent(String peixunjihuaContent) {
        this.peixunjihuaContent = peixunjihuaContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Peixunjihua{" +
            "id=" + id +
            ", zhigongId=" + zhigongId +
            ", peixunjihuaUuidNumber=" + peixunjihuaUuidNumber +
            ", peixunjihuaName=" + peixunjihuaName +
            ", peixunjihuaTypes=" + peixunjihuaTypes +
            ", kaishiTime=" + kaishiTime +
            ", jieshuTime=" + jieshuTime +
            ", peixunjihuaContent=" + peixunjihuaContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
