package com.company;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        SQL_Worker sql = new SQL_Worker();
        Users a = new Users("'Ariel'", "'Gierczak'", "'Warszawa, 01-231'", "'arkan'", "'newpasword'");
        System.out.println(a.user_test.getUser_id());
        System.out.println(a.user_test.getUser_name());
        System.out.println(a.user_test.getUser_surname());
        System.out.println(a.user_test.getUser_address());
        System.out.println(a.user_test.getLogin());
        System.out.println(a.user_test.getUser_password());
        System.out.println(a.xd + ", " + a.xd2 + " " + sql.GetDataFromDatabase("Select @@servername" ));

        System.out.println(a.listOfAllUsers.get(0).getUser_name());
        System.out.println(a.getUserDetails().get(0).getUser_name());
        System.out.println(NewSQL_Worker.getMetaDataFromTheDatabase().getColumnName(2));
        System.out.println(NewSQL_Worker.getRowCount("WebShop.dbo.Users"));

        System.out.println(a.listOfAllUsers.size());
        NewSQL_Worker.updateExistingDataOfUsers(a, "WebShop.dbo.Users");
        System.out.println(a.listOfAllUsers.size());
        System.out.println(a.getUserDetails().get(3).getUser_name());

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
