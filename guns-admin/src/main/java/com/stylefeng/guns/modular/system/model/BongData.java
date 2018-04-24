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
 * 网关统计手环的信息
 * </p>
 *
 * @author hackill123
 * @since 2018-04-24
 */
@TableName("bong_data")
public class BongData extends Model<BongData> {

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
     * 设备mac
     */
    @TableField("bong_mac")
    private String bongMac;
    /**
     * 电量 0~100
     */
    private Integer battery;
    /**
     * 固件版本
     */
    @TableField("firm_version")
    private String firmVersion;
    /**
     * 上传时间
     */
    @TableField("band_time")
    private Date bandTime;
    /**
     * 消耗热量,单位：卡路里
     */
    private Integer cal;
    /**
     * 步数
     */
    private Integer step;
    /**
     * 距离,单位：米
     */
    private Integer distance;
    /**
     * 跑步消耗热量,单位：卡路里
     */
    @TableField("run_cal")
    private Integer runCal;
    /**
     * 跑步步数
     */
    @TableField("run_step")
    private Integer runStep;
    /**
     * 跑步距离,单位：米
     */
    @TableField("run_distance")
    private Integer runDistance;
    /**
     * 睡眠总时长，单位：分钟
     */
    @TableField("sleep_num")
    private Integer sleepNum;
    /**
     * 深睡眠时长，单位：分钟
     */
    @TableField("ds_num")
    private Integer dsNum;
    @TableField("wake_num")
    private Integer wakeNum;
    @TableField("create_time")
    private Date createTime;


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

    public String getBongMac() {
        return bongMac;
    }

    public void setBongMac(String bongMac) {
        this.bongMac = bongMac;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    public String getFirmVersion() {
        return firmVersion;
    }

    public void setFirmVersion(String firmVersion) {
        this.firmVersion = firmVersion;
    }

    public Date getBandTime() {
        return bandTime;
    }

    public void setBandTime(Date bandTime) {
        this.bandTime = bandTime;
    }

    public Integer getCal() {
        return cal;
    }

    public void setCal(Integer cal) {
        this.cal = cal;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getRunCal() {
        return runCal;
    }

    public void setRunCal(Integer runCal) {
        this.runCal = runCal;
    }

    public Integer getRunStep() {
        return runStep;
    }

    public void setRunStep(Integer runStep) {
        this.runStep = runStep;
    }

    public Integer getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(Integer runDistance) {
        this.runDistance = runDistance;
    }

    public Integer getSleepNum() {
        return sleepNum;
    }

    public void setSleepNum(Integer sleepNum) {
        this.sleepNum = sleepNum;
    }

    public Integer getDsNum() {
        return dsNum;
    }

    public void setDsNum(Integer dsNum) {
        this.dsNum = dsNum;
    }

    public Integer getWakeNum() {
        return wakeNum;
    }

    public void setWakeNum(Integer wakeNum) {
        this.wakeNum = wakeNum;
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
        return "BongData{" +
        "id=" + id +
        ", gatewayMac=" + gatewayMac +
        ", bongMac=" + bongMac +
        ", battery=" + battery +
        ", firmVersion=" + firmVersion +
        ", bandTime=" + bandTime +
        ", cal=" + cal +
        ", step=" + step +
        ", distance=" + distance +
        ", runCal=" + runCal +
        ", runStep=" + runStep +
        ", runDistance=" + runDistance +
        ", sleepNum=" + sleepNum +
        ", dsNum=" + dsNum +
        ", wakeNum=" + wakeNum +
        ", createTime=" + createTime +
        "}";
    }
}
