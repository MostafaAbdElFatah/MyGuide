package com.mostafaabdel_fatah.myguideonline.dbClass;

/**
 * Created by Mostafa AbdEl_Fatah on 8/7/2017.
 */

public class Doctor {
    private String id;
    private String name;
    private String spec;
    private String address;
    private String phone;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpec() {
        return spec;
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

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
