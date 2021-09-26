package com.pctc.model;

import java.util.Date;

public class WorkerFactoryVo {
    private Integer id;
    private String name;
    private Integer age;
    private Date birthday;
    private Integer fid;
    private String factoryName;

    public WorkerFactoryVo(Integer id, String name, Integer age, Date birthday, Integer fid, String factoryName) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.fid = fid;
        this.factoryName = factoryName;
    }

    public WorkerFactoryVo() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("WorkerFactoryVo{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", birthday=").append(birthday);
        sb.append(", fid=").append(fid);
        sb.append(", factoryName='").append(factoryName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
