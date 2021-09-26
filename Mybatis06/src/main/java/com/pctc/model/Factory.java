package com.pctc.model;

import java.io.Serializable;
import java.util.List;

public class Factory implements Serializable {
    private Integer id;
    private String factoryName;


    public Factory(Integer id, String factoryName) {
        this.id = id;
        this.factoryName = factoryName;
    }

    public Factory() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Factory{");
        sb.append("id=").append(id);
        sb.append(", factoryName='").append(factoryName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
