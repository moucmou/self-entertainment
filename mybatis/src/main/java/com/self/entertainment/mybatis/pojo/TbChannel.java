package com.self.entertainment.mybatis.pojo;

import java.util.Date;

public class TbChannel {
    private String cIndexCode;

    private Date dCreateTime;

    private Date dUpdateTime;

    private Integer iChannelNo;

    private String cChannelType;

    private String cName;

    private String cParentIndexCode;

    private String cRegionIndexCode;

    private Integer iStatus;

    public String getcIndexCode() {
        return cIndexCode;
    }

    public void setcIndexCode(String cIndexCode) {
        this.cIndexCode = cIndexCode == null ? null : cIndexCode.trim();
    }

    public Date getdCreateTime() {
        return dCreateTime;
    }

    public void setdCreateTime(Date dCreateTime) {
        this.dCreateTime = dCreateTime;
    }

    public Date getdUpdateTime() {
        return dUpdateTime;
    }

    public void setdUpdateTime(Date dUpdateTime) {
        this.dUpdateTime = dUpdateTime;
    }

    public Integer getiChannelNo() {
        return iChannelNo;
    }

    public void setiChannelNo(Integer iChannelNo) {
        this.iChannelNo = iChannelNo;
    }

    public String getcChannelType() {
        return cChannelType;
    }

    public void setcChannelType(String cChannelType) {
        this.cChannelType = cChannelType == null ? null : cChannelType.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcParentIndexCode() {
        return cParentIndexCode;
    }

    public void setcParentIndexCode(String cParentIndexCode) {
        this.cParentIndexCode = cParentIndexCode == null ? null : cParentIndexCode.trim();
    }

    public String getcRegionIndexCode() {
        return cRegionIndexCode;
    }

    public void setcRegionIndexCode(String cRegionIndexCode) {
        this.cRegionIndexCode = cRegionIndexCode == null ? null : cRegionIndexCode.trim();
    }

    public Integer getiStatus() {
        return iStatus;
    }

    public void setiStatus(Integer iStatus) {
        this.iStatus = iStatus;
    }
}