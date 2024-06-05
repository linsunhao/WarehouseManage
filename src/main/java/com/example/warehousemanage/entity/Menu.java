package com.example.warehousemanage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author sun
 * @since 2024-04-09
 */
@TableName("menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "mid", type = IdType.AUTO)
    private Integer mid;

    private String menuCode;

    private String menuName;

    private String menuLevel;

    private String menuParentCode;

    private String menuClick;

    private String menuRight;

    private String menuComponent;

    private String menuicon;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuParentCode() {
        return menuParentCode;
    }

    public void setMenuParentCode(String menuParentCode) {
        this.menuParentCode = menuParentCode;
    }

    public String getMenuClick() {
        return menuClick;
    }

    public void setMenuClick(String menuClick) {
        this.menuClick = menuClick;
    }

    public String getMenuRight() {
        return menuRight;
    }

    public void setMenuRight(String menuRight) {
        this.menuRight = menuRight;
    }

    public String getMenuComponent() {
        return menuComponent;
    }

    public void setMenuComponent(String menuComponent) {
        this.menuComponent = menuComponent;
    }

    public String getMenuicon() {
        return menuicon;
    }

    public void setMenuicon(String menuicon) {
        this.menuicon = menuicon;
    }

    @Override
    public String toString() {
        return "Menu{" +
        "mid = " + mid +
        ", menuCode = " + menuCode +
        ", menuName = " + menuName +
        ", menuLevel = " + menuLevel +
        ", menuParentCode = " + menuParentCode +
        ", menuClick = " + menuClick +
        ", menuRight = " + menuRight +
        ", menuComponent = " + menuComponent +
        ", menuicon = " + menuicon +
        "}";
    }
}
