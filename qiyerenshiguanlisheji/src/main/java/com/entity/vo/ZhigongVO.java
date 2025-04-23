package com.entity.vo;

import com.entity.ZhigongEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 职工
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhigong")
public class ZhigongVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 职工姓名
     */

    @TableField(value = "zhigong_name")
    private String zhigongName;


    /**
     * 职工手机号
     */

    @TableField(value = "zhigong_phone")
    private String zhigongPhone;


    /**
     * 职工身份证号
     */

    @TableField(value = "zhigong_id_number")
    private String zhigongIdNumber;


    /**
     * 职工头像
     */

    @TableField(value = "zhigong_photo")
    private String zhigongPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 电子邮箱
     */

    @TableField(value = "zhigong_email")
    private String zhigongEmail;


    /**
     * 部门
     */

    @TableField(value = "bumen_types")
    private Integer bumenTypes;


    /**
     * 职位
     */

    @TableField(value = "zhiwei_types")
    private Integer zhiweiTypes;


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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：职工姓名
	 */
    public String getZhigongName() {
        return zhigongName;
    }


    /**
	 * 获取：职工姓名
	 */

    public void setZhigongName(String zhigongName) {
        this.zhigongName = zhigongName;
    }
    /**
	 * 设置：职工手机号
	 */
    public String getZhigongPhone() {
        return zhigongPhone;
    }


    /**
	 * 获取：职工手机号
	 */

    public void setZhigongPhone(String zhigongPhone) {
        this.zhigongPhone = zhigongPhone;
    }
    /**
	 * 设置：职工身份证号
	 */
    public String getZhigongIdNumber() {
        return zhigongIdNumber;
    }


    /**
	 * 获取：职工身份证号
	 */

    public void setZhigongIdNumber(String zhigongIdNumber) {
        this.zhigongIdNumber = zhigongIdNumber;
    }
    /**
	 * 设置：职工头像
	 */
    public String getZhigongPhoto() {
        return zhigongPhoto;
    }


    /**
	 * 获取：职工头像
	 */

    public void setZhigongPhoto(String zhigongPhoto) {
        this.zhigongPhoto = zhigongPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：电子邮箱
	 */
    public String getZhigongEmail() {
        return zhigongEmail;
    }


    /**
	 * 获取：电子邮箱
	 */

    public void setZhigongEmail(String zhigongEmail) {
        this.zhigongEmail = zhigongEmail;
    }
    /**
	 * 设置：部门
	 */
    public Integer getBumenTypes() {
        return bumenTypes;
    }


    /**
	 * 获取：部门
	 */

    public void setBumenTypes(Integer bumenTypes) {
        this.bumenTypes = bumenTypes;
    }
    /**
	 * 设置：职位
	 */
    public Integer getZhiweiTypes() {
        return zhiweiTypes;
    }


    /**
	 * 获取：职位
	 */

    public void setZhiweiTypes(Integer zhiweiTypes) {
        this.zhiweiTypes = zhiweiTypes;
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
