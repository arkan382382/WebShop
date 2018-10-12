package com.company;

import java.sql.SQLException;
import java.util.ArrayList;

import static java.sql.Types.NULL;

public class Users {
    ArrayList<User> listOfAllUsers = new ArrayList<>();

    public Users(String n, String s, String a, String l, String p) throws SQLException {
        createUser(n, s, a, l, p);

        //sql.CommitDataToDatabase("INSERT INTO WebShop.dbo.User (" + sql.rsmd.getColumnName(1));
        // condition which checks the duplicate of login - getting it from database
//            SQL_Worker.CommitDataToDatabase("INSERT INTO WebShop.dbo.User (UserId, UserName, UserSurname, UserAddress, UserLogin, UserPassword)" +
      /*  sql.CommitDataToDatabase("INSERT INTO WebShop.dbo.Users (UserId, UserName, UserSurname, UserAdress, UserLogin, UserPassword)" +
                "VALUES (" + String.valueOf(listOfAllUsers.get(Integer.valueOf(listOfAllUsers.size())).getUser_id()) + ", " + listOfAllUsers.get(listOfAllUsers.size()).getUser_name() + //dodać wszędzue String.valueOf()
                "'," + listOfAllUsers.get(listOfAllUsers.size()).getUser_surname() + ", " + listOfAllUsers.get(listOfAllUsers.size()).getUser_address() +
                ", " + listOfAllUsers.get(listOfAllUsers.size()).getLogin() + ", " + listOfAllUsers.get(listOfAllUsers.size()).getUser_password() + ")"); */
        //sql.CommitDataToDatabase("INSERT INTO WebShop.dbo.Users (UserId, UserName, UserSurname, UserAdress, UserLogin, UserPassword) VALUES ("+String.valueOf(listOfAllUsers.get(listOfAllUsers.size()).getUser_id()) +", 'A', 'A', 'A', 'A', 'A')");
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

    public void updateUserIdForDownloadedUsers(Users user, short howManyUsers) {
        for (int i = 0; i < (NewSQL_Worker.getRowCount("WebShop.dbo.Users")); i++) {
            user.getUserDetails().get(i).setUser_id(Short.parseShort(NewSQL_Worker.getSpecificUserDataFromDatabase("UserId", (short) (i + 1))));
        }
    }

    public void VeryficationAndExecutionIfUserShouldBeCreatedInList(String name, String surname, String address, String login, String password) {
        for (short i = 0; i < this.getUserDetails().size(); i++) {
            System.out.println("i = " + i + ", listName: " + this.getUserDetails().get(i).getUser_name() + ", provided name: " + name + ", list surname: " + this.getUserDetails().get(i).getUser_surname() + ", " + "provided surname: " + surname);
            if ((this.compareNameOk(name, surname) == 0) && (i == (this.getUserDetails().size()-1))) {
                System.out.println("w tym prypadku tworzymy nową klasę");
                this.createUser(name, surname, address, login, password);
                break;
            } else if ((this.compareNameOk(name, surname) == 1) && (i == (this.getUserDetails().size()-1))) {
                System.out.println("The provided data exist in database");
                }
        }
    }
/*
    public void createUserIdForNewlyCreatedUser(){
        int sizeForIndex = this.getUserDetails().size() - 1;
        int lastId = this.getUserDetails().get(sizeForIndex).getUser_id();
        int lastUser = sizeForIndex;
        this.getUserDetails().get(lastUser).setUser_id((short) (lastId+1));
    }
*/
    public void createUserIdForNewlyCreatedUser2(){
        if(this.getUserDetails().size() != fullyUpdatedRows()){
            int tmp = 1;
            tmp += (this.getUserDetails().get((this.getUserDetails().size())-2).getUser_id());
            this.getUserDetails().get(this.getUserDetails().size()-1).setUser_id(tmp);
        }
    }
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

