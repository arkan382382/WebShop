package com.company;

import java.util.ArrayList;

public class Users {
    private ArrayList<User> listOfAllUsers = new ArrayList<>();
    void createUser(String n, String s, String a, String l, String p){
        listOfAllUsers.add(new User(n, s, a, l, p));
        // condition which checks the duplicate of login - getting it from database
        SQL_Worker.CommitDataToDatabase("INSERT INTO User (UserId, UserName, UserSurname, UserAddress, Login, Password)" +
                "VLUES ("+ listOfAllUsers.get(listOfAllUsers.size()).getUser_id() + ", " + listOfAllUsers.get(listOfAllUsers.size()).getUser_name() +
                "," + listOfAllUsers.get(listOfAllUsers.size()).getUser_surname() + ", " + listOfAllUsers.get(listOfAllUsers.size()).getUser_address() +
                ", " + listOfAllUsers.get(listOfAllUsers.size()).getLogin() + ", " + listOfAllUsers.get(listOfAllUsers.size()).getUser_password() + ")");
    }

}
