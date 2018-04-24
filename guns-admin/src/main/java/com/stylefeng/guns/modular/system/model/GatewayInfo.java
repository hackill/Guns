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
 * 网关信息信息
 * </p>
 *
 * @author hackill123
 * @since 2018-04-24
 */
@TableName("gateway_info")
public class GatewayInfo extends Model<GatewayInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 网关mac
     */
    @TableField("gateway_mac")
    private String gatewayMac;
    /**
     * 0：普通模式，1：只扫描模式
     */
    private Integer type;
    /**
     * 备注
     */
    private String comment;
    /**
     * 0 表示正常 1表示异常
     */
    private Integer status;
    /**
     * 同步间隔 单位秒
     */
    @TableField("sync_interval")
    private Integer syncInterval;
    /**
     * 扫描间隔 单位秒 
     */
    @TableField("scan_interval")
    private Integer scanInterval;
    /**
     * 升级间隔 单位分钟 默认60
     */
    @TableField("update_interval")
    private Integer updateInterval;
    /**
     * 固件版本
     */
    private String version;
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

    public String getGatewayMac() {
        return gatewayMac;
    }

    public void setGatewayMac(String gatewayMac) {
        this.gatewayMac = gatewayMac;
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

    public Integer getSyncInterval() {
        return syncInterval;
    }

    public void setSyncInterval(Integer syncInterval) {
        this.syncInterval = syncInterval;
    }

    public Integer getScanInterval() {
        return scanInterval;
    }

    public void setScanInterval(Integer scanInterval) {
        this.scanInterval = scanInterval;
    }

    public Integer getUpdateInterval() {
        return updateInterval;
    }

    public void setUpdateInterval(Integer updateInterval) {
        this.updateInterval = updateInterval;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
        return "GatewayInfo{" +
        "id=" + id +
        ", gatewayMac=" + gatewayMac +
        ", type=" + type +
        ", comment=" + comment +
        ", status=" + status +
        ", syncInterval=" + syncInterval +
        ", scanInterval=" + scanInterval +
        ", updateInterval=" + updateInterval +
        ", version=" + version +
        ", groupId=" + groupId +
        ", instId=" + instId +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
