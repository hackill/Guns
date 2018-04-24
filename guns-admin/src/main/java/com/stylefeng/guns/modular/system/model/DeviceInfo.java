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
 * 手环信息
 * </p>
 *
 * @author hackill123
 * @since 2018-04-24
 */
@TableName("device_info")
public class DeviceInfo extends Model<DeviceInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * mac
     */
    @TableField("bong_mac")
    private String bongMac;
    /**
     * nfc编码code
     */
    @TableField("nfc_code")
    private String nfcCode;
    /**
     * userId
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * groupId
     */
    @TableField("group_id")
    private Integer groupId;
    /**
     * gatewayId
     */
    @TableField("gateway_id")
    private Integer gatewayId;
    /**
     * institutionId 机构Id
     */
    @TableField("inst_id")
    private Integer instId;
    /**
     * 备注
     */
    private String comment;
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

    public String getBongMac() {
        return bongMac;
    }

    public void setBongMac(String bongMac) {
        this.bongMac = bongMac;
    }

    public String getNfcCode() {
        return nfcCode;
    }

    public void setNfcCode(String nfcCode) {
        this.nfcCode = nfcCode;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(Integer gatewayId) {
        this.gatewayId = gatewayId;
    }

    public Integer getInstId() {
        return instId;
    }

    public void setInstId(Integer instId) {
        this.instId = instId;
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
        return "DeviceInfo{" +
        "id=" + id +
        ", bongMac=" + bongMac +
        ", nfcCode=" + nfcCode +
        ", userId=" + userId +
        ", groupId=" + groupId +
        ", gatewayId=" + gatewayId +
        ", instId=" + instId +
        ", comment=" + comment +
        ", status=" + status +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
