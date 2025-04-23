package com.entity.vo;

import com.entity.ZhaopinjihuaEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 招聘计划
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhaopinjihua")
public class ZhaopinjihuaVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 招聘计划编号
     */

    @TableField(value = "zhaopinjihua_uuid_name")
    private String zhaopinjihuaUuidName;


    /**
     * 招聘计划名称
     */

    @TableField(value = "zhaopinjihua_name")
    private String zhaopinjihuaName;


    /**
     * 招聘计划类型
     */

    @TableField(value = "zhaopinjihua_types")
    private Integer zhaopinjihuaTypes;


    /**
     * 招聘职位
     */

    @TableField(value = "zhiwei_types")
    private Integer zhiweiTypes;


    /**
     * 招聘人数
     */

    @TableField(value = "zhaopin_renshu")
    private Integer zhaopinRenshu;


    /**
     * 招聘计划详情
     */

    @TableField(value = "zhaopinjihua_content")
    private String zhaopinjihuaContent;


    /**
     * 添加时间
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
	 * 设置：招聘计划编号
	 */
    public String getZhaopinjihuaUuidName() {
        return zhaopinjihuaUuidName;
    }


    /**
	 * 获取：招聘计划编号
	 */

    public void setZhaopinjihuaUuidName(String zhaopinjihuaUuidName) {
        this.zhaopinjihuaUuidName = zhaopinjihuaUuidName;
    }
    /**
	 * 设置：招聘计划名称
	 */
    public String getZhaopinjihuaName() {
        return zhaopinjihuaName;
    }


    /**
	 * 获取：招聘计划名称
	 */

    public void setZhaopinjihuaName(String zhaopinjihuaName) {
        this.zhaopinjihuaName = zhaopinjihuaName;
    }
    /**
	 * 设置：招聘计划类型
	 */
    public Integer getZhaopinjihuaTypes() {
        return zhaopinjihuaTypes;
    }


    /**
	 * 获取：招聘计划类型
	 */

    public void setZhaopinjihuaTypes(Integer zhaopinjihuaTypes) {
        this.zhaopinjihuaTypes = zhaopinjihuaTypes;
    }
    /**
	 * 设置：招聘职位
	 */
    public Integer getZhiweiTypes() {
        return zhiweiTypes;
    }


    /**
	 * 获取：招聘职位
	 */

    public void setZhiweiTypes(Integer zhiweiTypes) {
        this.zhiweiTypes = zhiweiTypes;
    }
    /**
	 * 设置：招聘人数
	 */
    public Integer getZhaopinRenshu() {
        return zhaopinRenshu;
    }


    /**
	 * 获取：招聘人数
	 */

    public void setZhaopinRenshu(Integer zhaopinRenshu) {
        this.zhaopinRenshu = zhaopinRenshu;
    }
    /**
	 * 设置：招聘计划详情
	 */
    public String getZhaopinjihuaContent() {
        return zhaopinjihuaContent;
    }


    /**
	 * 获取：招聘计划详情
	 */

    public void setZhaopinjihuaContent(String zhaopinjihuaContent) {
        this.zhaopinjihuaContent = zhaopinjihuaContent;
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

}
