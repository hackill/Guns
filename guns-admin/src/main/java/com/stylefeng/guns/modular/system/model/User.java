package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 用户组信息(班级信息)
 * </p>
 *
 * @author hackill123
 * @since 2018-04-25
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户编号
     */
    private String code;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 0:male;1:female;2:others
     */
    private Integer gender;
    /**
     * 出生年
     */
    private Integer birthday;
    /**
     * 出生年
     */
    private Integer height;
    /**
     * 电话号码
     */
    @TableField("phone_number")
    private String phoneNumber;
    /**
     * 用户类型 暂无用途
     */
    private Integer type;
    /**
     * 备注
     */
    private String comment;
    /**
     * 0：正常
     */
    private Integer status;
    /**
     * groupId
     */
    @TableField("group_id")
    private Integer groupId;
    /**
     * institutionId 机构Id
     */
    @TableField("inst_id")
    private Integer instId;
    @TableField("create_time")
    private Date createTime;
    @TableField("modify_time")
    private Date modifyTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getInstId() {
        return instId;
    }

    public void setInstId(Integer instId) {
        this.instId = instId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", code=" + code +
        ", name=" + name +
        ", gender=" + gender +
        ", birthday=" + birthday +
        ", height=" + height +
        ", phoneNumber=" + phoneNumber +
        ", type=" + type +
        ", comment=" + comment +
        ", status=" + status +
        ", groupId=" + groupId +
        ", instId=" + instId +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
