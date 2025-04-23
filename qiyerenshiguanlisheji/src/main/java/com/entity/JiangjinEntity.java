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
 * 奖金
 *
 * @author 
 * @email
 */
@TableName("jiangjin")
public class JiangjinEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiangjinEntity() {

	}

	public JiangjinEntity(T t) {
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
     * 唯一编号
     */
    @TableField(value = "jiangjin_uuid_name")

    private String jiangjinUuidName;


    /**
     * 奖金名称
     */
    @TableField(value = "jiangjin_name")

    private String jiangjinName;


    /**
     * 奖金类型
     */
    @TableField(value = "jiangjin_types")

    private Integer jiangjinTypes;


    /**
     * 奖金金额
     */
    @TableField(value = "jiangjin_jine")

    private Double jiangjinJine;


    /**
     * 发放缘由
     */
    @TableField(value = "jiangjin_content")

    private String jiangjinContent;


    /**
     * 发放时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "fafang_time")

    private Date fafangTime;


    /**
     * 记录时间
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
	 * 设置：唯一编号
	 */
    public String getJiangjinUuidName() {
        return jiangjinUuidName;
    }
    /**
	 * 获取：唯一编号
	 */

    public void setJiangjinUuidName(String jiangjinUuidName) {
        this.jiangjinUuidName = jiangjinUuidName;
    }
    /**
	 * 设置：奖金名称
	 */
    public String getJiangjinName() {
        return jiangjinName;
    }
    /**
	 * 获取：奖金名称
	 */

    public void setJiangjinName(String jiangjinName) {
        this.jiangjinName = jiangjinName;
    }
    /**
	 * 设置：奖金类型
	 */
    public Integer getJiangjinTypes() {
        return jiangjinTypes;
    }
    /**
	 * 获取：奖金类型
	 */

    public void setJiangjinTypes(Integer jiangjinTypes) {
        this.jiangjinTypes = jiangjinTypes;
    }
    /**
	 * 设置：奖金金额
	 */
    public Double getJiangjinJine() {
        return jiangjinJine;
    }
    /**
	 * 获取：奖金金额
	 */

    public void setJiangjinJine(Double jiangjinJine) {
        this.jiangjinJine = jiangjinJine;
    }
    /**
	 * 设置：发放缘由
	 */
    public String getJiangjinContent() {
        return jiangjinContent;
    }
    /**
	 * 获取：发放缘由
	 */

    public void setJiangjinContent(String jiangjinContent) {
        this.jiangjinContent = jiangjinContent;
    }
    /**
	 * 设置：发放时间
	 */
    public Date getFafangTime() {
        return fafangTime;
    }
    /**
	 * 获取：发放时间
	 */

    public void setFafangTime(Date fafangTime) {
        this.fafangTime = fafangTime;
    }
    /**
	 * 设置：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：记录时间
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
        return "Jiangjin{" +
            "id=" + id +
            ", zhigongId=" + zhigongId +
            ", jiangjinUuidName=" + jiangjinUuidName +
            ", jiangjinName=" + jiangjinName +
            ", jiangjinTypes=" + jiangjinTypes +
            ", jiangjinJine=" + jiangjinJine +
            ", jiangjinContent=" + jiangjinContent +
            ", fafangTime=" + fafangTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
