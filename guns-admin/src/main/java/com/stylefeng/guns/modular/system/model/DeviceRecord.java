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
 * 设备记录
 * </p>
 *
 * @author hackill123
 * @since 2018-04-24
 */
@TableName("device_record")
public class DeviceRecord extends Model<DeviceRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 设备mac
     */
    @TableField("bong_mac")
    private String bongMac;
    /**
     * 路由mac
     */
    @TableField("gateway_mac")
    private String gatewayMac;
    /**
     * 路由 version
     */
    @TableField("gateway_version")
    private String gatewayVersion;
    /**
     * 设备名称
     */
    private String name;
    /**
     * 信号强度
     */
    private String rssi;
    @TableField("create_time")
    private Date createTime;


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

    public String getGatewayMac() {
        return gatewayMac;
    }

    public void setGatewayMac(String gatewayMac) {
        this.gatewayMac = gatewayMac;
    }

    public String getGatewayVersion() {
        return gatewayVersion;
    }

    public void setGatewayVersion(String gatewayVersion) {
        this.gatewayVersion = gatewayVersion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRssi() {
        return rssi;
    }

    public void setRssi(String rssi) {
        this.rssi = rssi;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "DeviceRecord{" +
        "id=" + id +
        ", bongMac=" + bongMac +
        ", gatewayMac=" + gatewayMac +
        ", gatewayVersion=" + gatewayVersion +
        ", name=" + name +
        ", rssi=" + rssi +
        ", createTime=" + createTime +
        "}";
    }
}
