package com.company;

import java.sql.SQLException;
import java.util.ArrayList;

public class Users {
    ArrayList<User> listOfAllUsers = new ArrayList<>();

    public Users(String n, String s, String a, String l, String p) throws SQLException {


        if (listOfAllUsers.size() == 0) {
        }
        // W pierwszej kolejności aktualizacja ArrayList danymi z DB jeżeli arraylist jest pusta

        createUser(n, s, a, l, p);
        //VeryficationAndExecutionIfUserShouldBeCreatedInList(n, s, a, l, p);

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
        int a = NewSQL_Worker.getRowCount("WebShop.dbo.Users");
        // int isTheNameInsideOfDb, linker_name, linker_surname, isTheSurnameInsideOfDb;
        for (short i = 0; i < NewSQL_Worker.getRowCount("WebShop.dbo.Users"); i++) {
            if ((name.equals(NewSQL_Worker.getSpecificUserDataFromDatabase("UserName", (short) (i + 1)))) && (surname.equals(NewSQL_Worker.getSpecificUserDataFromDatabase("UserSurname", (short) (i + 1))))) {
                // isTheNameInsideOfDb = 1;
                // linker_name = i;
                System.out.println("The provided data exist in database: ");
            } else if ((!name.equals(NewSQL_Worker.getSpecificUserDataFromDatabase("UserName", (short) (i + 1)))) && (!surname.equals(NewSQL_Worker.getSpecificUserDataFromDatabase("UserName", (short) (i + 1))))) {
                if (NewSQL_Worker.getRowCount("WebShop.dbo.Users") == i) { //cos tu nie gra
                    createUser(name, surname, address, login, password);
                }
            }
        }
    }

    public void VeryficationAndExecutionIfUserShouldBeCreatedInList2(Users user, String name, String surname, String address, String login, String password) {
        for (short i = 0; i < 8; i++) {
            if ((name.equals(user.getUserDetails().get(i).getUser_name())) && (surname.equals(user.getUserDetails().get(i).getUser_surname()))) {
                System.out.println("The provided data exist in database: ");
                break;  //nie działa popawnie dla ostatniego elementu - przerywa działanie zanim
            } else if ((!name.equals(user.getUserDetails().get(i).getUser_name())) && (!surname.equals(user.getUserDetails().get(i).getUser_surname()))) {
                if (user.getUserDetails().size() == (i+1)) { //cos tu nie gra
                    createUser(name, surname, address, login, password);
                }
            }
        }
    }
}



       //     if(surname == NewSQL_Worker.getSpecificUserDataFromDatabase("UserSurname", (short) (i+1))){
               // isTheSurnameInsideOfDb = 1;
               // linker_surname = i;



        /*if(isTheNameInsideOfDb == 1 && isTheSurnameInsideOfDb == 1 && linker_name == linker_surname){
            System.out.println("The provided data exist in database: ");
        }else
        if(isTheNameInsideOfDb == 0 && isTheSurnameInsideOfDb == 0) {
            createUser(name, surname, address, login, password);
     */


