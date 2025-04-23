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
 * 友情链接
 *
 * @author 
 * @email
 */
@TableName("youqinglianjie")
public class YouqinglianjieEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YouqinglianjieEntity() {

	}

	public YouqinglianjieEntity(T t) {
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
        return "Youqinglianjie{" +
            "id=" + id +
            ", youqinglianjieName=" + youqinglianjieName +
            ", youqinglianjiePhoto=" + youqinglianjiePhoto +
            ", youqinglianjieAddress=" + youqinglianjieAddress +
            ", youqinglianjieTypes=" + youqinglianjieTypes +
            ", youqinglianjieContent=" + youqinglianjieContent +
            ", createTime=" + createTime +
        "}";
    }
}
