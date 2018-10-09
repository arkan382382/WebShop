package com.company;

import java.sql.SQLException;
import java.util.ArrayList;

public class Users {
    ArrayList<User> listOfAllUsers = new ArrayList<>();
    public User user_test;
    public int xd = 0;
    public int xd2 = 0;
    public Users(String n, String s, String a, String l, String p) throws SQLException {

        SQL_Worker sql = new SQL_Worker();
        if(listOfAllUsers.size() == 0){

        }
        // W pierwszej kolejności aktualizacja ArrayList danymi z DB jeżeli arraylist jest pusta

        createUser(n, s, a, l, p);
        xd2 = listOfAllUsers.size();

        // W drugiej kolejności tworzenie nowego użytkownika w DB

        //sql.CommitDataToDatabase("INSERT INTO WebShop.dbo.User (" + sql.rsmd.getColumnName(1));
        // condition which checks the duplicate of login - getting it from database
//            SQL_Worker.CommitDataToDatabase("INSERT INTO WebShop.dbo.User (UserId, UserName, UserSurname, UserAddress, UserLogin, UserPassword)" +
      /*  sql.CommitDataToDatabase("INSERT INTO WebShop.dbo.Users (UserId, UserName, UserSurname, UserAdress, UserLogin, UserPassword)" +
                "VALUES (" + String.valueOf(listOfAllUsers.get(Integer.valueOf(listOfAllUsers.size())).getUser_id()) + ", " + listOfAllUsers.get(listOfAllUsers.size()).getUser_name() + //dodać wszędzue String.valueOf()
                "'," + listOfAllUsers.get(listOfAllUsers.size()).getUser_surname() + ", " + listOfAllUsers.get(listOfAllUsers.size()).getUser_address() +
                ", " + listOfAllUsers.get(listOfAllUsers.size()).getLogin() + ", " + listOfAllUsers.get(listOfAllUsers.size()).getUser_password() + ")"); */
        //sql.CommitDataToDatabase("INSERT INTO WebShop.dbo.Users (UserId, UserName, UserSurname, UserAdress, UserLogin, UserPassword) VALUES ("+String.valueOf(listOfAllUsers.get(listOfAllUsers.size()).getUser_id()) +", 'A', 'A', 'A', 'A', 'A')");
    }
    public Users(String n){
        createUserTest(n);
    }
        public void createUserTest(String n){       //do usunięcia
        listOfAllUsers.add(new User(n));
        SQL_Worker sql = new SQL_Worker();           //do usunięcia
        //String name = new User(n).getUser_name(); this is not necessary
            sql.CommitDataToDatabase("INSERT INTO WebShop.dbo.Users (UserName) VALUES ('" + n + "')");
        }
        public void createUser(String n, String s, String a, String l, String p){
            listOfAllUsers.add(new User(n, s, a, l, p));
            //System.out.println("dlugosc = " + listOfAllUsers.size());
            user_test = new User(n, s, a, l, p);        //do usunięcia
        }
        public ArrayList<User> getUserDetails(){
            return listOfAllUsers;
        }

}
