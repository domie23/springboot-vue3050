package com.entity.model;

import com.entity.JiangjinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 奖金
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiangjinModel implements Serializable {
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
     * 唯一编号
     */
    private String jiangjinUuidName;


    /**
     * 奖金名称
     */
    private String jiangjinName;


    /**
     * 奖金类型
     */
    private Integer jiangjinTypes;


    /**
     * 奖金金额
     */
    private Double jiangjinJine;


    /**
     * 发放缘由
     */
    private String jiangjinContent;


    /**
     * 发放时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fafangTime;


    /**
     * 记录时间
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
	 * 获取：唯一编号
	 */
    public String getJiangjinUuidName() {
        return jiangjinUuidName;
    }


    /**
	 * 设置：唯一编号
	 */
    public void setJiangjinUuidName(String jiangjinUuidName) {
        this.jiangjinUuidName = jiangjinUuidName;
    }
    /**
	 * 获取：奖金名称
	 */
    public String getJiangjinName() {
        return jiangjinName;
    }


    /**
	 * 设置：奖金名称
	 */
    public void setJiangjinName(String jiangjinName) {
        this.jiangjinName = jiangjinName;
    }
    /**
	 * 获取：奖金类型
	 */
    public Integer getJiangjinTypes() {
        return jiangjinTypes;
    }


    /**
	 * 设置：奖金类型
	 */
    public void setJiangjinTypes(Integer jiangjinTypes) {
        this.jiangjinTypes = jiangjinTypes;
    }
    /**
	 * 获取：奖金金额
	 */
    public Double getJiangjinJine() {
        return jiangjinJine;
    }


    /**
	 * 设置：奖金金额
	 */
    public void setJiangjinJine(Double jiangjinJine) {
        this.jiangjinJine = jiangjinJine;
    }
    /**
	 * 获取：发放缘由
	 */
    public String getJiangjinContent() {
        return jiangjinContent;
    }


    /**
	 * 设置：发放缘由
	 */
    public void setJiangjinContent(String jiangjinContent) {
        this.jiangjinContent = jiangjinContent;
    }
    /**
	 * 获取：发放时间
	 */
    public Date getFafangTime() {
        return fafangTime;
    }


    /**
	 * 设置：发放时间
	 */
    public void setFafangTime(Date fafangTime) {
        this.fafangTime = fafangTime;
    }
    /**
	 * 获取：记录时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：记录时间
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
