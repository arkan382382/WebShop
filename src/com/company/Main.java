package com.company;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Users a = new Users("'Ariel'", "'Gierczak'", "'Warszawa, 01-231'", "'arkan'", "'newpasword'");

      //  System.out.println(a.listOfAllUsers.get(0).getUser_name());
      //  System.out.println(a.getUserDetails().get(0).getUser_name());
      //  System.out.println(NewSQL_Worker.getMetaDataFromTheDatabase().getColumnName(2));
      //  System.out.println(NewSQL_Worker.getRowCount("WebShop.dbo.Users"));

        System.out.println("beforeUpdate:");
        for(int i=0; i<a.getUserDetails().size(); i++){
            System.out.println(a.getUserDetails().get(i).getUser_id() + " " + a.getUserDetails().get(i).getUser_name());
        }

        NewSQL_Worker.updateExistingDataOfUsers(a, "WebShop.dbo.Users");

        System.out.println("afterUpdate:");
        for(int i=0; i<a.getUserDetails().size(); i++){
            System.out.println(a.getUserDetails().get(i).getUser_id() + " " + a.getUserDetails().get(i).getUser_name());
        }

        System.out.println(NewSQL_Worker.getIdOfLastUserInDb());

       // System.out.println(a.getUserDetails().get(a.getUserDetails().size()-1).getUser_name());
       // Sprawdzic pobieranie nazwy kolumny, wprowadzic do projektu bazowanie na nazwach kolumn pobrych z sql (a nie wprowadzanych z palca do querry)

        // System.out.println(sql.GetNameOfColumns(1));
        //  SQL_Worker a = new SQL_Worker();
       // String test = "INSERT INTO WebShop.dbo.Users (UserId, UserName) VALUES (55, 'Ariel')"; //WORKING!!!
       // String select = "SELECT * from WebShop.dbo.Users";
         //       a.CommitDataToDatabase(test);       //WORKING!!!
           //     System.out.print(a.GetDataFromDatabase(select));


        /* Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM WebShop.dbo.Users");
            rsmd = rs.getMetaData();
            while (rs.next()) {
                for(short i = 1; i < rsmd.getColumnCount(); i++){
                    System.out.print(rs.getString(i) + " ");
                    System.out.println();
                }
            }
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        } */
    }
}
