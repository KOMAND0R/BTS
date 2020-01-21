package com.company;

import java.util.ArrayList;
import java.util.Scanner;
public class Project {
    protected int id;
    protected String name;
    ArrayList<Project> projects = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

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
    public void saveProject(){
        System.out.println("Введите проект.");
        System.out.print("Id проекта присваивается автоматически \n");
        id = projects.size();
        System.out.println("id = " + id + "\n");
        System.out.print("Введите name проекта:");
        name = scan.next();
        Project u = new Project(id,name);
        System.out.print(u + " \n");
        projects.add(u);
    }
    public void deleteProject(int id){
        try {
            projects.remove(id);
            System.out.print("Проект с id " +id +" удалён \n");
        }catch (Exception e) {
            System.out.print("Проекта с таким id нет \n");
        }
        System.out.print("deleteProject\n");
    }
    public void  getAllProject() {
        System.out.print(projects.toString()+"\n");
        System.out.print(projects.size()+" size projects\n");
    }

    public void updateProject(Project project){}
    public Project getProject(Project project, int id){
        //Project project = null;
        System.out.print(projects.toString());
        System.out.print(project + "\n");
        try  {
            project = projects.get(id);
        } catch (Exception e) {
            System.out.print("Проекта с таким id нет \n");
            //e.printStackTrace();
            return null;
        }
        return project;}
}
