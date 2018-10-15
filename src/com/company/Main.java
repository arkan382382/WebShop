package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws SQLException {
        //* #1
        Users a = new Users("'Ariel'", "'Gierczak'", "'Warszawa, 01-231'", "'arkan'", "'newpasword'");

        if(NewSQL_Worker.getRowCount("WebShop.dbo.Users") == 0){
            a.getUserDetails().clear();
            //* #4
            a.VeryficationAndExecutionIfUserShouldBeCreatedInList("XD", "XD", "E", "E", "E");
            // #5
            a.createUserIdForNewlyCreatedUser();
            // #6
            NewSQL_Worker.commitNewUserToDatabase(a);
        }

        //* #2
        NewSQL_Worker.updateExistingDataOfUsers(a, "WebShop.dbo.Users"); //clear existing list and update by those from db

        //* #3
        a.updateUserIdForDownloadedUsers(a, (short) NewSQL_Worker.getRowCount("WebShop.dbo.Users")); //Update of userId in array

        //* #4
        a.VeryficationAndExecutionIfUserShouldBeCreatedInList("XD", "XD", "E", "E", "E");

        // #5
        a.createUserIdForNewlyCreatedUser();

        // #6
        NewSQL_Worker.commitNewUserToDatabase(a);

            for(int i=0; i<a.getUserDetails().size(); i++){
            System.out.println("userId: " + a.getUserDetails().get(i).getUser_id() + ", name: " + a.getUserDetails().get(i).getUser_name());
            }
    }
}
