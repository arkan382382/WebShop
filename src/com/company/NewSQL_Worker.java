package com.company;

import java.sql.*;

public class NewSQL_Worker {
    static Connection con = null;
    static Statement stmt = null;
    static ResultSet rs = null;
    static ResultSetMetaData rsmd = null;
    static String connectionUrl = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;user=Arkan;password=ddd;";

    public static ResultSetMetaData getMetaDataFromTheDatabase(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM WebShop.dbo.Users");
            rsmd = rs.getMetaData();
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
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return count;
    }
    public static void updateExistingDatas(Users users, String tableName){ //aktualizuje i prypisuje o jedną kolumnę w lewo czli imię to Id, nazwisko to imie itd
        String datasFromDatabase = null;
        //users -> clear
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * from " + tableName);

            while (rs.next()){
                users.createUser(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
