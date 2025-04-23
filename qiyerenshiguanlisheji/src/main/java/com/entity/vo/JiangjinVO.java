package com.entity.vo;

import com.entity.JiangjinEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 奖金
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiangjin")
public class JiangjinVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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

}
