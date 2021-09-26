package com.pctc.model;

import java.util.Date;

public class Worker {
    private Integer id;
    private String name;
    private Integer age;
    private Date birthday;
    private Integer fid;

    private Factory factory;

    public Factory getFactory() {
        return factory;
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
    }

    public Worker(Integer id, String name, Integer age, Date birthday, Integer fid) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.fid = fid;
    }


    public Worker() {

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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Worker{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", birthday=").append(birthday);
        sb.append(", fid=").append(fid);
        sb.append(", factory=").append(factory);
        sb.append('}');
        return sb.toString();
    }
}
