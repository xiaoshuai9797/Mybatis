package com.pctc.model;

public class Factory {
    private Integer tId;

    private String tFactoryname;

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettFactoryname() {
        return tFactoryname;
    }

    public void settFactoryname(String tFactoryname) {
        this.tFactoryname = tFactoryname == null ? null : tFactoryname.trim();
    }
}