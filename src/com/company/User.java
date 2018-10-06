package com.company;

public class User {
    private String user_name, user_surname, user_adress, login, password;
    private short user_id;
    SQL_Worker tmp = new SQL_Worker();

    public User(String name, String surname, String adress, String login, String password){
        this.user_name = name;
        this.user_surname = surname;
        this.user_adress = adress;
        this.login = login;
        this.password = password;
        this.user_id = tmp.GetTheIdOfLastUser();
    }

}
