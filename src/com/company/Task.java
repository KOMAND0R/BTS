package com.company;

import java.util.ArrayList;
import java.util.Scanner;
public class Task {
    protected int id;
    protected Project project;
    protected String name;
    protected String title;
    protected Classtask classtask;
    protected Status status;
    protected Priority priority;
    protected User user;
    protected String description;
    ArrayList<Task> tasks = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

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
    public void saveTask(){
        System.out.println("Введите задачу.");
        System.out.print("Id задачи присваивается автоматически \n");
        id = tasks.size();
        System.out.println("id = " + id + "\n");
        System.out.print("Введите id проекта для задачи \n");
        if(scan.hasNextInt()) {
            id = scan.nextInt();
        } else {System.out.println("Введите число!"); }
//        if(project.getProject(id) == null){
////            break;
//        }else{project =  project.getProject(id);}
        Project project = new Project();
        System.out.print(project+"\n");
        try {
            project =  project.getProject(project,id);
        }catch (Exception e){
            System.out.print("ДОЛБОЁБ\n");
            e.printStackTrace();
        }
        System.out.print("Введите name задачи:");
        name = scan.next();
        System.out.print("Введите title задачи:");
        title = scan.next();

        System.out.print("Выберите Classtask (Task press 1 or Bug press 2) задачи:\n");
        int q = 0;
        String w ="";
        w = scan.next();
        try {
            q = Integer.parseInt(w);
        } catch (NumberFormatException e){
            System.out.println("Неверный ввод\n");
        }
        switch (q) {
            case 1:
                classtask = Classtask.Task;
                System.out.print("Task\n");
                break;
            case 2:
                classtask = Classtask.Bug;
                System.out.print("Bug\n");
                break;
        }
        System.out.print("Введите Status (New press 1 or InProgress press 2 or OnReview press 3 or Closed press 4 задачи:\n");
        w = scan.next();
        try {
            q = Integer.parseInt(w);
        } catch (NumberFormatException e){
            System.out.println("Неверный ввод\n");
        }
        switch (q){
            case 1:
                status = Status.New;
                System.out.print("New\n");
                break;
            case 2:
                status = Status.InProgress;
                System.out.print("InProgress\n");
                break;
            case 3:
                status = Status.OnReview;
                System.out.print("OnReview\n");
                break;
            case 4:
                status = Status.Closed;
                System.out.print("Closed\n");
                break;
        }
        System.out.print("Введите Priority (Low press 1 or Medium press 2 or High press 3) задачи:\n");
        w = scan.next();
        try {
            q = Integer.parseInt(w);
        } catch (NumberFormatException e){
            System.out.println("Неверный ввод\n");
        }
        switch (q){
            case 1:
                priority = Priority.Low;
                System.out.print("Low\n");
                break;
            case 2:
                priority = Priority.Medium;
                System.out.print("Medium\n");
                break;
            case 3:
                priority = Priority.High;
                System.out.print("High\n");
                break;
        }
        System.out.print("Введите id пользователя для задачи \n");
        if(scan.hasNextInt()) {
            id = scan.nextInt();
        } else {System.out.println("Введите число!"); }
        if(user.getUser(id) == null){
//            break;
        }else{user =  user.getUser(id);}
        System.out.print("Введите description  задачи:");
        description = scan.next();
        Task u = new Task(id,project,name,title,classtask,status,priority,user,description);
        System.out.print(u + " \n");
        tasks.add(u);
        System.out.print(tasks + " \n");
    }
    public void deleteTask(int id){
        try {
            tasks.remove(id);
            System.out.print("Задача с id " +id +" удалёна \n");
        }catch (Exception e) {
            System.out.print("Задачи с таким id нет \n");
        }
        System.out.print("deleteTask\n");
    }
    public void  getAllTask(){
        System.out.print(tasks.toString()+"\n");
        System.out.print(tasks.size()+" size tasks\n");
    }

    public void updateTask(Task task){}
    public Task getTask(int id){return null;}

}
