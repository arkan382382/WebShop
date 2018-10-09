package com.company;

import java.sql.*;

public class NewSQL_Worker {
    static Connection con = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    static ResultSetMetaData rsmd = null;
    static String connectionUrl = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;user=Arkan;password=ddd;";

    public static ResultSetMetaData getMetaDataFromTheDatabase() throws SQLException {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM WebShop.dbo.Users");
            rsmd = rs.getMetaData();
            rs.close();
            con.close();
            stmt.close();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return rsmd;
    }
    public static int getRowCount(String tableName){
        int count = 0;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT COUNT (*) AS 'rowcount' FROM " + tableName);
            rs.next();
            count = rs.getInt("rowcount");
            rs.close();
            con.close();
            stmt.close();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return count;
    }
    public static void updateExistingDataOfUsers(Users users, String tableName){
        //users -> clear
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * from " + tableName);

            while (rs.next()){
                users.createUser(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
            rs.close();
            con.close();
            stmt.close();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void CommitDataToDatabase(Users users, String tableName){ //nie działa
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
            stmt = con.createStatement();
      //      rs = stmt.executeQuery("INSERT INTO " + tableName + " " + rsmd.getColumnName(2) +  +"(UserName) VALUES ('" + n + "')");
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static short getIdOfLastUserInDb(){  //nie działa w klasie User, ogólnie pobiera prawidłowe wartości
        short value = 0;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select tmp.UserId FROM WebShop.dbo.Users tmp");
            while (rs.next()){
                value = rs.getShort("UserId");
            }
            rs.close();
            con.close();
            stmt.close();
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return value;
    }
}
