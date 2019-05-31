package com.self.entertainment.mybatis.pojo;

import java.io.Serializable;

public class LfTbSendingFaceResultHistory implements Serializable {
    private static final long serialVersionUID = 8290000585777953815L;
    private String id;

    private String faceUrl;

    private String listId;

    private String listLibraryId;

    private String listLibraryName;

    private String name;

    private String protectId;

    private String reason;

    private String recogId;

    private String recogName;

    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl == null ? null : faceUrl.trim();
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId == null ? null : listId.trim();
    }

    public String getListLibraryId() {
        return listLibraryId;
    }

    public void setListLibraryId(String listLibraryId) {
        this.listLibraryId = listLibraryId == null ? null : listLibraryId.trim();
    }

    public String getListLibraryName() {
        return listLibraryName;
    }

    public void setListLibraryName(String listLibraryName) {
        this.listLibraryName = listLibraryName == null ? null : listLibraryName.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProtectId() {
        return protectId;
    }

    public void setProtectId(String protectId) {
        this.protectId = protectId == null ? null : protectId.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getRecogId() {
        return recogId;
    }

    public void setRecogId(String recogId) {
        this.recogId = recogId == null ? null : recogId.trim();
    }

    public String getRecogName() {
        return recogName;
    }

    public void setRecogName(String recogName) {
        this.recogName = recogName == null ? null : recogName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}