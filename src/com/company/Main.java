package com.company;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        User user = new User();
        Task task = new Task();
        Project project = new Project();
        Scanner scan = new Scanner(System.in);
        int x = 0;
        int id;
        String s ="";
        while (!"18".equals(s)){
            System.out.println("1. Создать пользователя");
            System.out.println("2. получить список всех задач, назначенных на конкретного исполнителя");
            System.out.println("3. Удалить пользователя");
            System.out.println("4. получить список всех задач в проекте");
            System.out.println("5. Вывети всех пользователей");
            System.out.println("6. Создать задачу");
            System.out.println("7. - ");
            System.out.println("8. Удалить задачу");
            System.out.println("9. - ");
            System.out.println("10. Вывети все задачи");
            System.out.println("11. Создать проект");
            System.out.println("12. - ");
            System.out.println("13. Удалить проект");
            System.out.println("14. - ");
            System.out.println("15. Вывети все проекты");
            System.out.println("16. Сохранение bug tracking system в файл");
            System.out.println("17. Загрузка bug tracking system из файла");
            System.out.println("18. Выход");
            s = scan.next();

            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e){
                System.out.println("Неверный ввод");
            }

            switch (x){
                case 1:
                    System.out.print(x+" "+"Пункт меню\n");
                    user.saveUser();
                    break;
                case 2:
                    System.out.print(x+" "+"Пункт меню\n");
                   // User.updateUser(User user);
                    break;
                case 3:
                    System.out.print(x+" "+"Пункт меню\n");
                    System.out.print("Введите id пользователя для удаления \n");
                    if(scan.hasNextInt()) {
                         id = scan.nextInt();
                    } else {System.out.println("Введите число!"); break;}
                    user.deleteUser(id);
                    break;
                case 4:
                    System.out.print(x+" "+"Пункт меню\n");
                    break;
                case 5:
                    System.out.print(x+" "+"Пункт меню\n");;
                    user.getAllUser();
                    break;
                case 6:
                    System.out.print(x+" "+"Пункт меню\n");
//                    System.out.println("Введите задачу.");
//                    System.out.print("Введите id задачи:");
//                    if(scan.hasNextInt()) {
//                        task.setId(task.id = scan.nextInt());
//                    } else {System.out.println("Введите число!"); break;}
//
//                    System.out.print("Введите id проекта для задачи \n");
//                    if(scan.hasNextInt()) {
//                        id = scan.nextInt();
//                    } else {System.out.println("Введите число!"); break;}
//                    if(project.getProject(id) == null){
//                        break;
//                    }else{task.setProject(task.project =  project.getProject(id));}
//                    System.out.print("Введите name задачи:");
//                    task.setName(task.name = scan.next());
//                    System.out.print("Введите title задачи:");
//                    task.setTitle(task.title = scan.next());
//
//                    System.out.print("Выберите Classtask (Task press 1 or Bug press 2) задачи:\n");
//                    int q = 0;
//                    String w ="";
//                    w = scan.next();
//                    try {
//                        q = Integer.parseInt(w);
//                    } catch (NumberFormatException e){
//                        System.out.println("Неверный ввод\n");
//                    }
//                    switch (q) {
//                    case 1:
//                        task.setClasstask(task.classtask = Classtask.Task );
//                        System.out.print("Task\n");
//                        break;
//                    case 2:
//                        task.setClasstask(task.classtask = Classtask.Bug );
//                        System.out.print("Bug\n");
//                        break;
//                    }
//                    System.out.print("Введите Status (New press 1 or InProgress press 2 or OnReview press 3 or Closed press 4 задачи:\n");
//                    w = scan.next();
//                    try {
//                        q = Integer.parseInt(w);
//                    } catch (NumberFormatException e){
//                        System.out.println("Неверный ввод\n");
//                    }
//                    switch (q){
//                        case 1:
//                            task.setStatus(task.status = Status.New);
//                            System.out.print("New\n");
//                            break;
//                        case 2:
//                            task.setStatus(task.status = Status.InProgress);
//                            System.out.print("InProgress\n");
//                            break;
//                        case 3:
//                            task.setStatus(task.status = Status.OnReview);
//                            System.out.print("OnReview\n");
//                            break;
//                        case 4:
//                            task.setStatus(task.status = Status.Closed);
//                            System.out.print("Closed\n");
//                            break;
//                    }
//                    System.out.print("Введите Priority (Low press 1 or Medium press 2 or High press 3) задачи:\n");
//                    w = scan.next();
//                    try {
//                        q = Integer.parseInt(w);
//                    } catch (NumberFormatException e){
//                        System.out.println("Неверный ввод\n");
//                    }
//                    switch (q){
//                        case 1:
//                            task.setPriority(task.priority = Priority.Low);
//                            System.out.print("Low\n");
//                            break;
//                        case 2:
//                            task.setPriority(task.priority = Priority.Medium);
//                            System.out.print("Medium\n");
//                            break;
//                        case 3:
//                            task.setPriority(task.priority = Priority.High);
//                            System.out.print("High\n");
//                            break;
//                    }
//                    System.out.print("Введите id пользователя для задачи \n");
//                    if(scan.hasNextInt()) {
//                        id = scan.nextInt();
//                    } else {System.out.println("Введите число!"); break;}
//                    if(user.getUser(id) == null){
//                        break;
//                    }else{task.setUser(task.user =  user.getUser(id));}
//                    System.out.print("Введите description  задачи:");
//                    task.setDescription(task.description = scan.next());
//                    System.out.print(task + " \n");
                    task.saveTask();
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
                    task.deleteTask(id);
                    break;
                case 9:
                    System.out.print(x+" "+"Пункт меню\n");
                    break;
                case 10:
                    System.out.print(x+" "+"Пункт меню\n");
                    task.getAllTask();
                    break;
                case 11:
                    System.out.print(x+" "+"Пункт меню\n");
                    project.saveProject();
                    break;
                case 12:
                    System.out.print(x+" "+"Пункт меню\n");
                    break;
                case 13:
                    System.out.print(x+" "+"Пункт меню\n");
                    System.out.print("Введите id проекта для удаления \n");
                    if(scan.hasNextInt()) {
                        id = scan.nextInt();
                    } else {System.out.println("Введите число!"); break;}
                    project.deleteProject(id);
                    break;
                case 14:
                    System.out.print(x+" "+"Пункт меню\n");
                    break;
                case 15:
                    System.out.print(x+" "+"Пункт меню\n");
                    project.getAllProject();
                    break;
                case 16:
                    System.out.print(x+" "+"Пункт меню\n");
                    break;
                case 17:
                    System.out.print(x+" "+"Пункт меню\n");
                    break;
            }
        }
        System.out.println("До свидания!");
    }
}
