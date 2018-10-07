package com.company;

import java.sql.*;



public class Main {

    public static void main(String[] args) throws SQLException {
       // Users a = new Users("Ariel", "Gierczak", "Warszawa, 01-231", "arkan", "newpasword");
        Users a = new Users("Ariel");
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
