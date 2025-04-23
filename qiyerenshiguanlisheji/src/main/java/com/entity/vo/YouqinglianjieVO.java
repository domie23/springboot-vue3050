package com.entity.vo;

import com.entity.YouqinglianjieEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 友情链接
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("youqinglianjie")
public class YouqinglianjieVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 友情链接名称
     */

    @TableField(value = "youqinglianjie_name")
    private String youqinglianjieName;


    /**
     * 友情链接图片
     */

    @TableField(value = "youqinglianjie_photo")
    private String youqinglianjiePhoto;


    /**
     * 链接地址
     */

    @TableField(value = "youqinglianjie_address")
    private String youqinglianjieAddress;


    /**
     * 友情链接类型
     */

    @TableField(value = "youqinglianjie_types")
    private Integer youqinglianjieTypes;


    /**
     * 友情链接详情
     */

    @TableField(value = "youqinglianjie_content")
    private String youqinglianjieContent;


    /**
     * 创建时间 show1 show2 nameShow
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
	 * 设置：友情链接名称
	 */
    public String getYouqinglianjieName() {
        return youqinglianjieName;
    }


    /**
	 * 获取：友情链接名称
	 */

    public void setYouqinglianjieName(String youqinglianjieName) {
        this.youqinglianjieName = youqinglianjieName;
    }
    /**
	 * 设置：友情链接图片
	 */
    public String getYouqinglianjiePhoto() {
        return youqinglianjiePhoto;
    }


    /**
	 * 获取：友情链接图片
	 */

    public void setYouqinglianjiePhoto(String youqinglianjiePhoto) {
        this.youqinglianjiePhoto = youqinglianjiePhoto;
    }
    /**
	 * 设置：链接地址
	 */
    public String getYouqinglianjieAddress() {
        return youqinglianjieAddress;
    }


    /**
	 * 获取：链接地址
	 */

    public void setYouqinglianjieAddress(String youqinglianjieAddress) {
        this.youqinglianjieAddress = youqinglianjieAddress;
    }
    /**
	 * 设置：友情链接类型
	 */
    public Integer getYouqinglianjieTypes() {
        return youqinglianjieTypes;
    }


    /**
	 * 获取：友情链接类型
	 */

    public void setYouqinglianjieTypes(Integer youqinglianjieTypes) {
        this.youqinglianjieTypes = youqinglianjieTypes;
    }
    /**
	 * 设置：友情链接详情
	 */
    public String getYouqinglianjieContent() {
        return youqinglianjieContent;
    }


    /**
	 * 获取：友情链接详情
	 */

    public void setYouqinglianjieContent(String youqinglianjieContent) {
        this.youqinglianjieContent = youqinglianjieContent;
    }
    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
