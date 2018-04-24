package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户组信息(班级信息)
 * </p>
 *
 * @author hackill123
 * @since 2018-04-24
 */
@TableName("bong_group")
public class BongGroup extends Model<BongGroup> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 组编号
     */
    private String code;
    /**
     * 组名称
     */
    private String name;
    /**
     * 备注
     */
    private String comment;
    /**
     * 机构code
     */
    @TableField("inst_code")
    private String instCode;
    /**
     * 0 表示正常 1表示异常
     */
    private Integer status;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getInstCode() {
        return instCode;
    }

    public void setInstCode(String instCode) {
        this.instCode = instCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "BongGroup{" +
        "id=" + id +
        ", code=" + code +
        ", name=" + name +
        ", comment=" + comment +
        ", instCode=" + instCode +
        ", status=" + status +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
