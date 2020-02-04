package com.company;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main  {
    static ArrayList<Project> projects = new ArrayList<>();
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Task> tasks = new ArrayList<>();
    static User user = new User();
    private static Classtask classtask;
    private static Priority priority;
    private static Status status;
    static Project project = new Project();
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        int x = 0;
        int id;
        String s ="";
        while (!"15".equals(s)){
            System.out.println("1. Создать пользователя");
            System.out.println("2. Получить список всех задач, назначенных на конкретного исполнителя");
            System.out.println("3. Удалить пользователя");
            System.out.println("4. Получить список всех задач в проекте");
            System.out.println("5. Вывети всех пользователей");
            System.out.println("6. Создать задачу");
            System.out.println("7. - ");
            System.out.println("8. Удалить задачу");
            System.out.println("9. Сохранить BTS в файл");
            System.out.println("10. Вывети все задачи");
            System.out.println("11. Создать проект");
            System.out.println("12. Загрузить BTS из файла");
            System.out.println("13. Удалить проект");
            System.out.println("14. Вывети все проекты");
            System.out.println("15. Выход");
            s = scan.next();
            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e){
                System.out.println("Неверный ввод");
            }
            switch (x){
                case 1:
                    System.out.print(x+" "+"Пункт меню\n");
                    saveUser();
                    break;
                case 2:
                    System.out.print(x+" "+"Пункт меню\n");
                    System.out.print("Введите ID исполнителя\n");
                    if(scan.hasNextInt()) {
                        id = scan.nextInt();
                    } else {System.out.println("Введите число!"); break;}
                    findUser(id);
                    break;
                case 3:
                    System.out.print(x+" "+"Пункт меню\n");
                    System.out.print("Введите id пользователя для удаления \n");
                    if(scan.hasNextInt()) {
                         id = scan.nextInt();
                    } else {System.out.println("Введите число!"); break;}
                    deleteUser(id);
                    break;
                case 4:
                    System.out.print(x+" "+"Пункт меню\n");
                    System.out.print("Введите ID проекта\n");
                    if(scan.hasNextInt()) {
                        id = scan.nextInt();
                    } else {System.out.println("Введите число!"); break;}
                    findProject(id);
                    break;
                case 5:
                    System.out.print(x+" "+"Пункт меню\n");
                    getAllUser();
                    break;
                case 6:
                    System.out.print(x+" "+"Пункт меню\n");
                    saveTask();
                    break;
                case 7:
                    System.out.print(x+" "+"Пункт меню\n");
                    break;
                case 8:
                    System.out.print(x+" "+"Пункт меню\n");
                    System.out.print("Введите id задачи для удаления \n");
                    if(scan.hasNextInt()) {
                        id = scan.nextInt();
                    } else {System.out.println("Введите число!"); break;}
                    deleteTask(id);
                    break;
                case 9:
                    System.out.print(x+" "+"Пункт меню\n");
                    try{
                        System.out.print("Сохранение BTS в файл. Введите имя файла:\n");
                        String n = scan.next();
                        FileOutputStream fos = new FileOutputStream(n);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(users);
                        oos.writeObject(projects);
                        oos.writeObject(tasks);
                        oos.close();
                    }catch(IOException ex){
                        System.out.print("Ошибка сохранения повторите попытку\n");
                        //ex.printStackTrace();
                        break;
                    }
                    break;
                case 10:
                    System.out.print(x+" "+"Пункт меню\n");
                    getAllTask();
                    break;
                case 11:
                    System.out.print(x+" "+"Пункт меню\n");
                    saveProject();
                    break;
                case 12:
                    System.out.print(x+" "+"Пункт меню\n");
                    try {
                        System.out.print("Загрузка BTS из файла. Введите имя файла:\n");
                        String n = scan.next();
                        if( n == null){
                            System.out.print("Введите имя файла\n");
                            return;
                        }
                        FileInputStream fis = new FileInputStream(n);
                        ObjectInputStream ois = new ObjectInputStream(fis);
                        users = (ArrayList<User>) ois.readObject();
                        projects = (ArrayList<Project>) ois.readObject();
                        tasks = (ArrayList<Task>) ois.readObject();
                        System.out.print("Загрузка из файла\n"+users+projects+tasks);
                        ois.close();
                    }catch(IOException ex){
                        System.out.print("Ошибка введите правильно имя файла\n");
                        //ex.printStackTrace();
                        break;
                    }
                    break;
                case 13:
                    System.out.print(x+" "+"Пункт меню\n");
                    System.out.print("Введите id проекта для удаления \n");
                    if(scan.hasNextInt()) {
                        id = scan.nextInt();
                    } else {System.out.println("Введите число!"); break;}
                    deleteProject(id);
                    break;
                case 14:
                    System.out.print(x+" "+"Пункт меню\n");
                    getAllProject();
                    break;
            }
        }
        System.out.println("До свидания!");
    }
    private static void findProject(int id) {
        boolean check = false;
        System.out.print("Все задачи в проекте с id " + id +"\n");
        for (Task t : tasks) {
            if (t.project.id == id) {
                System.out.println(t);
                check = true;
            }
        }
        if(!check){System.out.print("Вминание задач в проекте c id " + id + " нет или их нужно присвоить\n");}
    }
    private static void findUser(int id) {
        boolean check = false;
        System.out.print("Все задачи исполнителя с id " + id +"\n");
        for (Task t : tasks) {
            if (t.user.id == id) {
                System.out.println(t);
                check = true;
            }
        }
        if(!check){System.out.print("Внимание задач у пользователя c id "+id+" нет или их ему нужно присвоить\n");}
    }
    public static void saveProject(){
        System.out.println("Введите проект.");
        System.out.print("Id проекта присваивается автоматически \n");
        int id = projects.size();
        System.out.println("id = " + id + "\n");
        System.out.print("Введите name проекта:");
        String name = scan.next();
        Project u = new Project(id,name);
        System.out.print(u + " \n");
        projects.add(u);
    }
    public static void deleteProject(int id){
        for (Task t : tasks) {
            if (t.project.id == id) {
                System.out.println("Внимание для удаления проекта сначала удалите все связанные с ним задачи\n");
                return;
            }
        }
        try {
            projects.remove(id);
            System.out.print("Проект с id " + id +" удалён \n");
            for(int i = id; i< projects.size(); i++) {
                Project t = projects.get(i);
                t.id = i;
                projects.set(i,t);
            }
            System.out.print("ID проектов обновлены\n");
        }catch (Exception e) {
            System.out.print("Проектов с таким id нет \n");
        }
    }
    public static void  getAllProject() {
        System.out.print(projects.toString()+"\n");
        System.out.print(projects.size()+" size projects\n");
    }
    public static Project getProject(int id){
        Project project;
        try  {
            project = projects.get(id);
        } catch (Exception e) {
            System.out.print("Проекта с таким id нет \n");
            //e.printStackTrace();
            return null;
        }
        return project;}
    public static void saveUser(){
        System.out.println("Введите пользователя.");
        System.out.print("Id пользователя присваивается автоматически \n");
        int id = users.size();
        System.out.println("id = " + id + "\n");
        System.out.print("Введите name пользователя:");
        String name = scan.next();
        System.out.print("Введите email пользователя:");
        String email = scan.next();
        System.out.print("Введите country пользователя:");
        String country = scan.next();
        User u = new User(id,name,email,country);
        System.out.print(u + " \n");
        users.add(u);
    }
    public static void deleteUser(int id){
        for (Task t : tasks) {
            if (t.user.id == id) {
                System.out.println("Внимание для удаления пользователя сначала удалите все его задачи\n");
                return;
            }
        }
        try {
            users.remove(id);
            System.out.print("Пользователя с id " + id +" удалён \n");
            for(int i = id; i< users.size(); i++) {
                User t = users.get(i);
                t.id = i;
                users.set(i,t);
            }
            System.out.print("ID пользователей обновлены\n");
        }catch (Exception e) {
            System.out.print("Пользователя с таким id нет \n");
        }

    }
    public static void getAllUser(){
        System.out.print(users.toString()+"\n");
        System.out.print(users.size()+" size users\n");
    }
    public static User getUser(int i){
        User user;
        try  {
            user = users.get(i);
        } catch (Exception e) {
            System.out.print("Проекта с таким id нет \n");
           // e.printStackTrace();
            return null;
        }
        return user;
    }
    public static void  saveTask(){
        System.out.println("Введите задачу.");
        System.out.print("Id задачи присваивается автоматически \n");
        int id = tasks.size();
        System.out.println("id = " + id + "\n");
        System.out.print("Введите id проекта для задачи \n");
        if(scan.hasNextInt()) {
            id = scan.nextInt();
        } else {System.out.println("Введите число!"); }
        try {
            project =  getProject(id);
            if(project == null){return;}
        }catch (Exception e){
            System.out.print("Ошибка в выборе проекта\n");
            //e.printStackTrace();
            return;
        }
        System.out.print("Введите name задачи:");
        String name = scan.next();
        System.out.print("Введите title задачи:");
        String title = scan.next();
        System.out.print("Выберите Classtask (Task press 1 or Bug press 2) задачи:\n");
        int q = 0;
        String w;
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
        System.out.print("Введите Status (New press 1 or InProgress press 2 or OnReview press 3 or Closed press 4) задачи:\n");
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
        int i = 0;
        if(scan.hasNextInt()) {
           i = scan.nextInt();
        } else {System.out.println("Введите число!"); }
        try {
            user = getUser(i);
            if(user == null){return;}
        }catch (Exception e){
            System.out.print("Ошибка в выборе проекта\n");
            //e.printStackTrace();
            return;
        }

        System.out.print("Введите description  задачи:");
        String description = scan.next();
        Task u = new Task(id,project,name,title,classtask,status,priority,user,description);
        System.out.print(u + " \n");
        tasks.add(u);
    }
    public static void deleteTask(int id){
        try {
            tasks.remove(id);
            System.out.print("Задача с id " + id +" удалён \n");
            for(int i = id; i< tasks.size(); i++) {
                Task t = tasks.get(i);
                t.id = i;
                tasks.set(i,t);
            }
            System.out.print("ID задач обновлены\n");
        }catch (Exception e) {
            System.out.print("Задачи с таким id нет \n");
        }
    }
    public static void  getAllTask(){
        System.out.print(tasks.toString()+"\n");
        System.out.print(tasks.size()+" size tasks\n");
    }
}
