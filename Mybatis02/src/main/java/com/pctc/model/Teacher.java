package com.pctc.model;

public class Teacher {

    private Integer id;
    private String name;
    private int age;
    private String protitle;



    public Teacher() {

    }


    public Teacher(Integer id, String name, int age, String protitle) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.protitle = protitle;
    }

    public Teacher(String name, int age, String protitle) {
        this.name = name;
        this.age = age;
        this.protitle = protitle;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Teacher{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", protitle='").append(protitle).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProtitle() {
        return protitle;
    }

    public void setProtitle(String protitle) {
        this.protitle = protitle;
    }
}
