package com.company;
import java.sql.*;

public class SQL_Worker {

    String connectionUrl = "jdbc:sqlserver://localhost:1433;integratedSecurity=true;user=Arkan;password=ddd;";
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    ResultSetMetaData rsmd = null; //do sprawdzenia metadanych jak: liczba kolumn

    public String GetDataFromDatabase(String statement){
        String result = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            stmt = con.createStatement();
            rs = stmt.executeQuery(statement);
            rsmd = rs.getMetaData();

            while (rs.next()) {
                for(short i = 1; i < rsmd.getColumnCount(); i++){
                    //System.out.print(rs.getString(i) + " ");   //back to void if necessary
                    result += (rs.getString(i) + " ");
                    //System.out.println();
                }
                result += "\n";
            }
        }
        catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return result;
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
            rs = stmt.executeQuery("SELECT tmp.UserId from WebShop.dbo.users tmp");                       //check if working
            //rsmd = rs.getMetaData();
            while (rs == null){
                value = 1;
            }
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
