package com.mostafaabdel_fatah.myguideonline.dbClass;

/**
 * Created by Mostafa AbdEl_Fatah on 8/7/2017.
 */

public class Hosiptal {
    private String id;
    private String name;
    private String type;
    private String address;
    private String phone;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
