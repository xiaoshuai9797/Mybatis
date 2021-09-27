package com.pctc.model;

import java.util.Date;

public class Worker {
    private Integer tId;

    private String tName;

    private Integer tAge;

    private Date tBirthday;

    private Integer tFid;



    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Worker{");
        sb.append("tId=").append(tId);
        sb.append(", tName='").append(tName).append('\'');
        sb.append(", tAge=").append(tAge);
        sb.append(", tBirthday=").append(tBirthday);
        sb.append(", tFid=").append(tFid);
        sb.append('}');
        return sb.toString();
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public Integer gettAge() {
        return tAge;
    }

    public void settAge(Integer tAge) {
        this.tAge = tAge;
    }

    public Date gettBirthday() {
        return tBirthday;
    }

    public void settBirthday(Date tBirthday) {
        this.tBirthday = tBirthday;
    }

    public Integer gettFid() {
        return tFid;
    }

    public void settFid(Integer tFid) {
        this.tFid = tFid;
    }
}