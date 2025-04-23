package com.entity.model;

import com.entity.ZhigongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 职工
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhigongModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 职工姓名
     */
    private String zhigongName;


    /**
     * 职工手机号
     */
    private String zhigongPhone;


    /**
     * 职工身份证号
     */
    private String zhigongIdNumber;


    /**
     * 职工头像
     */
    private String zhigongPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 电子邮箱
     */
    private String zhigongEmail;


    /**
     * 部门
     */
    private Integer bumenTypes;


    /**
     * 职位
     */
    private Integer zhiweiTypes;


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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：职工姓名
	 */
    public String getZhigongName() {
        return zhigongName;
    }


    /**
	 * 设置：职工姓名
	 */
    public void setZhigongName(String zhigongName) {
        this.zhigongName = zhigongName;
    }
    /**
	 * 获取：职工手机号
	 */
    public String getZhigongPhone() {
        return zhigongPhone;
    }


    /**
	 * 设置：职工手机号
	 */
    public void setZhigongPhone(String zhigongPhone) {
        this.zhigongPhone = zhigongPhone;
    }
    /**
	 * 获取：职工身份证号
	 */
    public String getZhigongIdNumber() {
        return zhigongIdNumber;
    }


    /**
	 * 设置：职工身份证号
	 */
    public void setZhigongIdNumber(String zhigongIdNumber) {
        this.zhigongIdNumber = zhigongIdNumber;
    }
    /**
	 * 获取：职工头像
	 */
    public String getZhigongPhoto() {
        return zhigongPhoto;
    }


    /**
	 * 设置：职工头像
	 */
    public void setZhigongPhoto(String zhigongPhoto) {
        this.zhigongPhoto = zhigongPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getZhigongEmail() {
        return zhigongEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setZhigongEmail(String zhigongEmail) {
        this.zhigongEmail = zhigongEmail;
    }
    /**
	 * 获取：部门
	 */
    public Integer getBumenTypes() {
        return bumenTypes;
    }


    /**
	 * 设置：部门
	 */
    public void setBumenTypes(Integer bumenTypes) {
        this.bumenTypes = bumenTypes;
    }
    /**
	 * 获取：职位
	 */
    public Integer getZhiweiTypes() {
        return zhiweiTypes;
    }


    /**
	 * 设置：职位
	 */
    public void setZhiweiTypes(Integer zhiweiTypes) {
        this.zhiweiTypes = zhiweiTypes;
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
