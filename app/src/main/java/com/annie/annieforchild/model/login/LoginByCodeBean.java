package com.annie.annieforchild.model.login;

import com.annie.annieforchild.model.BaseModel;

public class LoginByCodeBean extends BaseModel {
    private int isHaveStudents;
    private String defaultUsername;
    private int parentid;
    private String phone;
    private String token;

    public int getIsHaveStudents() {
        return isHaveStudents;
    }

    public void setIsHaveStudents(int isHaveStudents) {
        this.isHaveStudents = isHaveStudents;
    }

    public String getDefaultUsername() {
        return defaultUsername;
    }

    public void setDefaultUsername(String defaultUsername) {
        this.defaultUsername = defaultUsername;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
