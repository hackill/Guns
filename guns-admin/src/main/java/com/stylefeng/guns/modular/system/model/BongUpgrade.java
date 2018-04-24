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
 * 固件升级
 * </p>
 *
 * @author hackill123
 * @since 2018-04-24
 */
@TableName("bong_upgrade")
public class BongUpgrade extends Model<BongUpgrade> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 固件类型
     */
    private String product;
    /**
     * 版本号
     */
    private String ver;
    /**
     * crc校验
     */
    private String crc;
    /**
     * 文件大小
     */
    @TableField("file_length")
    private String fileLength;
    /**
     * 文件名
     */
    @TableField("file_name")
    private String fileName;
    /**
     * 备注
     */
    private String comment;
    /**
     * 0:不回复出厂设置 1:执行恢复出厂设置
     */
    private Integer recover;
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getCrc() {
        return crc;
    }

    public void setCrc(String crc) {
        this.crc = crc;
    }

    public String getFileLength() {
        return fileLength;
    }

    public void setFileLength(String fileLength) {
        this.fileLength = fileLength;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRecover() {
        return recover;
    }

    public void setRecover(Integer recover) {
        this.recover = recover;
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
        return "BongUpgrade{" +
        "id=" + id +
        ", product=" + product +
        ", ver=" + ver +
        ", crc=" + crc +
        ", fileLength=" + fileLength +
        ", fileName=" + fileName +
        ", comment=" + comment +
        ", recover=" + recover +
        ", createTime=" + createTime +
        ", modifyTime=" + modifyTime +
        "}";
    }
}
