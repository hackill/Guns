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
 * 配置信息
 * </p>
 *
 * @author hackill123
 * @since 2018-04-24
 */
@TableName("bong_config")
public class BongConfig extends Model<BongConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 类型
     */
    private Integer type;
    /**
     * 子类型
     */
    @TableField("sub_type")
    private Integer subType;
    /**
     * 值
     */
    private String value;
    /**
     * 备注
     */
    private String comment;
    /**
     * 状态 0 表示正常
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
        return "BongConfig{" +
        "id=" + id +
        ", type=" + type +
        ", subType=" + subType +
        ", value=" + value +
        ", comment=" + comment +
        ", status=" + status +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
