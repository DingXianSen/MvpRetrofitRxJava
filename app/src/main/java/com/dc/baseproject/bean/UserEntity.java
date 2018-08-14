package com.dc.baseproject.bean;

import java.io.Serializable;

/**
 * Created by dingchao on 2018/4/9.
 */

public class UserEntity implements Serializable {

    /**
     * code : 200
     * pvCount : 0
     * phone : 18519149146
     * message : success
     * token : Bearer eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1MjMyMzczNTQsImlhdCI6MTUyMzIzNzI5NH0.HYJcdJMA24RlyIwMMyrXf3DF_K4UIVa_cqVzww0O6_Q
     */

    private String code;
    private int pvCount;
    private String phone;
    private String message;
    private String token;
    private String memberType;//0优铺会员1VIP会员2普通用户

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPvCount() {
        return pvCount;
    }

    public void setPvCount(int pvCount) {
        this.pvCount = pvCount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserEntity(String code, int pvCount, String phone, String message, String token, String memberType) {
        this.code = code;
        this.pvCount = pvCount;
        this.phone = phone;
        this.message = message;
        this.token = token;
        this.memberType = memberType;
    }

    public UserEntity() {
    }
}
