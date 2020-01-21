package com.company;

import java.io.Serializable;

public class Task implements Serializable {
    protected int id;
    protected Project project;
    protected String name;
    protected String title;
    protected Classtask classtask;
    protected Status status;
    protected Priority priority;
    protected User user;
    protected String description;

    public Task() {
        super();
    }

    public Task(Project project, String name, String title, Classtask classtask, Status status, Priority priority,
                User user, String description) {
        super();
        this.project = project;
        this.name = name;
        this.title = title;
        this.classtask = classtask;
        this.status = status;
        this.priority = priority;
        this.user = user;
        this.description = description;
    }

    public Task(int id, Project project, String name, String title, Classtask classtask, Status status,
                Priority priority, User user, String description) {
        super();
        this.id = id;
        this.project = project;
        this.name = name;
        this.title = title;
        this.classtask = classtask;
        this.status = status;
        this.priority = priority;
        this.user = user;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Classtask getClasstask() {
        return classtask;
    }

    public void setClasstask(Classtask classtask) {
        this.classtask = classtask;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                "project='" + project + '\'' +
                "name='" + name + '\'' +
                "classtask='" + classtask + '\'' +
                "status='" + status + '\'' +
                "priority='" + priority + '\'' +
                "user='" + user + '\'' +
                "description='" + description + '\'' +
                '}';
    }
}
