package com.company;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static java.sql.Types.NULL;

public class Users {
    ArrayList<User> listOfAllUsers = new ArrayList<>();

    public Users(String n, String s, String a, String l, String p) throws SQLException {
        createUser(n, s, a, l, p);
}

    public void createUserTest(String n) {       //do usunięcia
        listOfAllUsers.add(new User(n));
        SQL_Worker sql = new SQL_Worker();           //do usunięcia
        //String name = new User(n).getUser_name(); this is not necessary
        sql.CommitDataToDatabase("INSERT INTO WebShop.dbo.Users (UserName) VALUES ('" + n + "')");
    }

    public void createUser(String n, String s, String a, String l, String p) {
        listOfAllUsers.add(new User(n, s, a, l, p));
    }

    public ArrayList<User> getUserDetails() {
        return listOfAllUsers;
    }

    public void updateUserIdForDownloadedUsers(Users user, short howManyUsers) throws SQLException {
        for (int i = 0; i < (NewSQL_Worker.getRowCount("WebShop.dbo.Users")); i++) {
            user.getUserDetails().get(i).setUser_id(Short.parseShort(NewSQL_Worker.getSpecificUserDataFromDatabase("UserId", (short) (i + 1))));
        }
    }

    public void VeryficationAndExecutionIfUserShouldBeCreatedInList(String name, String surname, String address, String login, String password) {
        for (short i = 0; i < this.getUserDetails().size(); i++) {
           // System.out.println("i = " + i + ", listName: " + this.getUserDetails().get(i).getUser_name() + ", provided name: " + name + ", list surname: " + this.getUserDetails().get(i).getUser_surname() + ", " + "provided surname: " + surname);
            if ((this.compareNameOk(name, surname) == 0) && (i == (this.getUserDetails().size()-1))) {
                System.out.println("w tym prypadku tworzymy nową klasę");
                this.createUser(name, surname, address, login, password);
                break;
            } else if ((this.compareNameOk(name, surname) == 1) && (i == (this.getUserDetails().size()-1))) {
                System.out.println("The provided data exist in database");
                }
        }
    }

    public void createUserIdForNewlyCreatedUser() {
        ArrayList<Integer> a = new ArrayList<>();
        if (this.getUserDetails().size() != fullyUpdatedRows()) {
            for (int i = 0; i < this.getUserDetails().size(); i++) {
                a.add((int) this.getUserDetails().get(i).getUser_id());
            }
            int max = Collections.max(a);
            this.getUserDetails().get(this.getUserDetails().size() - 1).setUser_id(max+1); //ustawienie - ustawić max+1
        }
    }
            // if(this.getUserDetails().size() != fullyUpdatedRows()){
         //   int tmp = 1;
           // tmp += (this.getUserDetails().get((this.getUserDetails().size())-2).getUser_id());
            //this.getUserDetails().get(this.getUserDetails().size()-1).setUser_id(tmp); //ustawienie - ustawić max+1

    public int fullyUpdatedRows(){
        int value = 0;
        for(short i=0; i<this.getUserDetails().size(); i++){
            if(this.getUserDetails().get(i).getUser_id() != NULL){
                value++;
            }
        }
        return value;
    }

    public int compareNameOk(String name, String surname) {   // 1 - znajduje się na liście, 0 - nie znajduje się na liście
        String valueFromList_name;
        String valueFromList_surname;
        int result = 0;
        for(int i=0; i<this.getUserDetails().size(); i++){
            valueFromList_name = this.getUserDetails().get(i).getUser_name();
            valueFromList_surname = this.getUserDetails().get(i).getUser_surname();
            if((name.equals(valueFromList_name)) & (surname.equals(valueFromList_surname))){
                result = 1;
            }
        }
        return result;
    }
}

