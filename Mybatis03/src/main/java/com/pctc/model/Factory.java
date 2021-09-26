package com.pctc.model;

import java.util.List;

public class Factory {
    private Integer id;
    private String factoryName;
    private List<Worker> workers;

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

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
        sb.append(", workers=").append(workers);
        sb.append('}');
        return sb.toString();
    }
}
