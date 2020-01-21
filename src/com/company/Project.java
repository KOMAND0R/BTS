package com.company;

import java.io.Serializable;

public class Project implements Serializable {
    protected int id;
    protected String name;
    public Project() {
    }

    public Project(String name) {
        super();
        this.name = name;
    }

    public Project(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
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
    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                '}';
    }

}
