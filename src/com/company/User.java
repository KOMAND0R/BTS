package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    protected int id;
    protected String name;
    protected String email;
    protected String country;
    ArrayList<User> users = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public User() {
    }

    public User(int id, String name) {
        super();
        this.id = id;
        this.name = name;
        users.add(this);
    }

    public User(String name, String email, String country) {
        super();
        this.name = name;
        this.email = email;
        this.country = country;
        users.add(this);
    }

    public User(int id, String name, String email, String country) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        users.add(this);
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void saveUser(){
        System.out.println("Введите пользователя.");
        System.out.print("Id пользователя присваивается автоматически \n");
        id = users.size();
        System.out.println("id = " + id + "\n");
       // if(scan.hasNextInt()) {
            //  id = scan.nextInt();
      //  } else {System.out.println("Введите число!"); }
        System.out.print("Введите name пользователя:");
        name = scan.next();
        System.out.print("Введите email пользователя:");
        email = scan.next();
        System.out.print("Введите country пользователя:");
        country = scan.next();
        User u = new User(id,name,email,country);
        System.out.print(u + " \n");
        users.add(u);
        System.out.print(users.toString()+"\n");
    }
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                "email='" + email + '\'' +
                "country='" + country + '\'' +
                '}';
    }

    public void deleteUser(int id){
        try {
            users.remove(id);
            System.out.print("Пользователя с id " + id +" удалён \n");

        }catch (Exception e) {
            System.out.print("Пользователя с таким id нет \n");
        }
        System.out.print("deleteUser\n");
    }
    public void getAllUser(){
        System.out.print(users.toString()+"\n");
        System.out.print(users.size()+" size users\n");
    }

    public User getUser(int id){
        User user = null;
        try  {
            user = users.get(id);
        } catch (Exception e) {
            System.out.print("Проекта с таким id нет \n");
            //e.printStackTrace();
            return null;
        }
        return user;
    }
    public void updateUser(User user ){
        System.out.print("updateUser\n");}
}
