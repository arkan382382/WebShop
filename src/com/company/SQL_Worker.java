package com.company;
import java.sql.*;

public class SQL_Worker {

    String connectionUrl = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;user=Arkan;password=ddd;";

    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private ResultSetMetaData rsmd = null; //do sprawdzenia metadanych jak: liczba kolumn

    public void GetDataFromDatabase(String statement){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            stmt = con.createStatement();
            rs = stmt.executeQuery(statement);
            rsmd = rs.getMetaData();

            while (rs.next()) {
                for(short i = 0; i < rsmd.getColumnCount(); i++){
                    System.out.print(rs.getString(i) + " ");
                    System.out.println();
                }
            }
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void CommitDataToDatabase(String statement){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            stmt = con.createStatement();
            rs = stmt.executeQuery(statement);
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void GetNameOfColumns(String nameOfTable){/*rsmd.getColumnName(whichOne))*/}
    public short GetTheIdOfLastUser(){
        short value = 0;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT tmp.UserID from Arkan.dbo.users tmp");                       //check if working
            rsmd = rs.getMetaData();

            while (rs.next()) {
                value = rs.getShort(1);
            }
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return value;
    }
}
