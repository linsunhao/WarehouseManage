package com.example.warehousemanage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author sun
 * @since 2024-04-09
 */
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer goods;

    @TableField(exist = false)
    private String goodsName;

    private Integer userId;

    @TableField(exist = false)
    private String userName;

    private Integer adminId;

    @TableField(exist = false)
    private String adminName;

    private Integer count;

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", goods=" + goods +
                ", goodsName='" + goodsName + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", count=" + count +
                ", action=" + action +
                ", createtime=" + createtime +
                ", remark='" + remark + '\'' +
                ", storageName='" + storageName + '\'' +
                ", goodsType='" + goodsType + '\'' +
                '}';
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    @TableField(exist = false)
    private Integer action;

    private LocalDateTime createtime;

    private String remark;

    @TableField(exist = false)
    private String storageName;

    @TableField(exist = false)
    private String goodsType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoods() {
        return goods;
    }

    public void setGoods(Integer goods) {
        this.goods = goods;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

}
