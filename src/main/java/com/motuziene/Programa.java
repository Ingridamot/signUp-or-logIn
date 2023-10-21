package com.motuziene;

import org.apache.commons.codec.digest.DigestUtils;

public class Programa {

    private String userPass;
    private String userName;

    public Programa(String userPass, String userName) {
        this.userPass = userPass;
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public String getUserName() {
        return userName;
    }

    public String uzkoduotiSlaptazodi (String userPass){
        return DigestUtils.sha256Hex(userPass);
    }

}
