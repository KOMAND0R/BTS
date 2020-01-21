package com.company;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
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
    static Task task = new Task();
    static Project project = new Project();
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // Локализация компонентов окна JFileChooser
        UIManager.put("FileChooser.saveButtonText"      , "Сохранить"             );
        UIManager.put("FileChooser.openButtonText"      , "Открыть"               );
        UIManager.put("FileChooser.cancelButtonText"    , "Отмена"                );
        UIManager.put("FileChooser.fileNameLabelText"   , "Наименование файла"    );
        UIManager.put("FileChooser.filesOfTypeLabelText", "Типы файлов"           );
        UIManager.put("FileChooser.lookInLabelText"     , "Директория"            );
        UIManager.put("FileChooser.saveInLabelText"     , "Сохранить в директории");
        UIManager.put("FileChooser.folderNameLabelText" , "Путь директории"       );



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
                    System.out.print(x+" "+"Пункт меню\n");;
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
                    break;
                case 15:
                    System.out.print(x+" "+"Пункт меню\n");
                    getAllProject();
                    break;
                case 16:
                    System.out.print(x+" "+"Пункт меню\n");
                    System.out.print("Сохранение в файл\n");
                    new JFileChooserTest();
//                    try {
//                        User u = new User();
//                        FileOutputStream fos = new FileOutputStream("имя файла");
//                        ObjectOutputStream oos = new ObjectOutputStream(fos);
//                        oos.close();
//                        FileInputStream fis = new FileInputStream("имя коробки");
//                        ObjectInputStream ois = new ObjectInputStream(fis);
//                        Object obj = ois.readObject();
//                        u = (User) obj;
//                        ois.close();
//
//                    }catch(IOException ex){
//                            ex.printStackTrace();
//                        }catch(ClassNotFoundException ex){
//                            ex.printStackTrace();}
                    //saveArrayList();
                    break;
                case 17:
                    System.out.print(x+" "+"Пункт меню\n");
                    System.out.print("Загрузка из файла\n");
                    //loadArrayList();
                    break;
            }
        }
        System.out.println("До свидания!");
    }

    private static void findProject(int id) {
        System.out.print("Все задачи в проекте с id " + id +"\n");
        for(int i = 0; i< tasks.size(); i++) {
            Task t = tasks.get(i);
            if (t.project.id == id){
                System.out.println(tasks.get(i));
            }
        }
    }
    private static void findUser(int id) {
        System.out.print("Все задачи исполнителя с id " + id +"\n");
            for(int i = 0; i< tasks.size(); i++) {
                Task t = tasks.get(i);
                if (t.user.id == id){
                    System.out.println(tasks.get(i));
                }
            }
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
        try {
            projects.remove(id);
            System.out.print("Проект с id " +id +" удалён \n");
            tasks.clear();
        }catch (Exception e) {
            System.out.print("Проекта с таким id нет \n");
        }
        System.out.print("deleteProject\n");
    }
    public static void  getAllProject() {
        System.out.print(projects.toString()+"\n");
        System.out.print(projects.size()+" size projects\n");
    }
    public static Project getProject(int id){
        Project project = null;
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
        // if(scan.hasNextInt()) {
        //  id = scan.nextInt();
        //  } else {System.out.println("Введите число!"); }
        System.out.print("Введите name пользователя:");
        String name = scan.next();
        System.out.print("Введите email пользователя:");
        String email = scan.next();
        System.out.print("Введите country пользователя:");
        String country = scan.next();
        User u = new User(id,name,email,country);
        System.out.print(u + " \n");
        users.add(u);
        System.out.print(users.toString()+"\n");
    }
    public static void deleteUser(int id){
        try {
            users.remove(id);
            System.out.print("Пользователя с id " + id +" удалён \n");
            tasks.clear();
        }catch (Exception e) {
            System.out.print("Пользователя с таким id нет \n");
        }
        System.out.print("deleteUser\n");
    }
    public static void getAllUser(){
        System.out.print(users.toString()+"\n");
        System.out.print(users.size()+" size users\n");
    }
    public static User getUser(int i){
        User user = null;
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
        System.out.print(tasks + " \n");
    }
    public static void deleteTask(int id){
        try {
            tasks.remove(id);
            System.out.print("Задача с id " +id +" удалёна \n");
        }catch (Exception e) {
            System.out.print("Задачи с таким id нет \n");
        }
        System.out.print("deleteTask\n");
    }
    public static void  getAllTask(){
        System.out.print(tasks.toString()+"\n");
        System.out.print(tasks.size()+" size tasks\n");
    }
    public Task getTask(int id){
        Task task = null;
        try  {
            task = tasks.get(id);
        } catch (Exception e) {
            System.out.print("Задачи с таким id нет \n");
            // e.printStackTrace();
            return null;
        }
        return task;
    }
//    @FXML
//    private void hndlOpenFile(ActionEvent event) {
//        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
//        fileChooser.setTitle("Open Document");//Заголовок диалога
//        FileChooser.ExtensionFilter extFilter =
//                new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");//Расширение
//        fileChooser.getExtensionFilters().add(extFilter);
//        File file = fileChooser.showOpenDialog(CodeNote.mainStage);//Указываем текущую сцену CodeNote.mainStage
//        if (file != null) {
//            //Open
//            System.out.println("Процесс открытия файла");
//        }
//    }
//    @FXML
//    private void hndlOpenFile(ActionEvent event) {
//        FileChooser fileChooser = new FileChooser();//Класс работы с диалогом выборки и сохранения
//        fileChooser.setTitle("Save Document");//Заголовок диалога
//        FileChooser.ExtensionFilter extFilter =
//                new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html");//Расширение
//        fileChooser.getExtensionFilters().add(extFilter);
//        File file = fileChooser.showSaveDialog(CodeNote.mainStage);//Указываем текущую сцену CodeNote.mainStage
//        if (file != null) {
//            //Save
//            System.out.println("Процесс открытия файла");
//        }
//    }
}
