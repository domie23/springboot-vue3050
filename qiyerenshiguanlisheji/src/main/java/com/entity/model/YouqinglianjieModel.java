package com.entity.model;

import com.entity.YouqinglianjieEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 友情链接
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YouqinglianjieModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 友情链接名称
     */
    private String youqinglianjieName;


    /**
     * 友情链接图片
     */
    private String youqinglianjiePhoto;


    /**
     * 链接地址
     */
    private String youqinglianjieAddress;


    /**
     * 友情链接类型
     */
    private Integer youqinglianjieTypes;


    /**
     * 友情链接详情
     */
    private String youqinglianjieContent;


    /**
     * 创建时间 show1 show2 nameShow
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
	 * 获取：友情链接名称
	 */
    public String getYouqinglianjieName() {
        return youqinglianjieName;
    }


    /**
	 * 设置：友情链接名称
	 */
    public void setYouqinglianjieName(String youqinglianjieName) {
        this.youqinglianjieName = youqinglianjieName;
    }
    /**
	 * 获取：友情链接图片
	 */
    public String getYouqinglianjiePhoto() {
        return youqinglianjiePhoto;
    }


    /**
	 * 设置：友情链接图片
	 */
    public void setYouqinglianjiePhoto(String youqinglianjiePhoto) {
        this.youqinglianjiePhoto = youqinglianjiePhoto;
    }
    /**
	 * 获取：链接地址
	 */
    public String getYouqinglianjieAddress() {
        return youqinglianjieAddress;
    }


    /**
	 * 设置：链接地址
	 */
    public void setYouqinglianjieAddress(String youqinglianjieAddress) {
        this.youqinglianjieAddress = youqinglianjieAddress;
    }
    /**
	 * 获取：友情链接类型
	 */
    public Integer getYouqinglianjieTypes() {
        return youqinglianjieTypes;
    }


    /**
	 * 设置：友情链接类型
	 */
    public void setYouqinglianjieTypes(Integer youqinglianjieTypes) {
        this.youqinglianjieTypes = youqinglianjieTypes;
    }
    /**
	 * 获取：友情链接详情
	 */
    public String getYouqinglianjieContent() {
        return youqinglianjieContent;
    }


    /**
	 * 设置：友情链接详情
	 */
    public void setYouqinglianjieContent(String youqinglianjieContent) {
        this.youqinglianjieContent = youqinglianjieContent;
    }
    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
