package com.annie.annieforchild.model.login;

import com.annie.annieforchild.model.BaseModel;

public class VcodeBean extends BaseModel {
    private String phone;
    private int serialNumber;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }
}
