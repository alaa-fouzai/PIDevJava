/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Technique;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER-PC
 */
public class DataSource {
    private static DataSource data;
    private Connection conn;
    public String url="jdbc:mysql://localhost:3306/souk";
    public String user="root";
    public String password="";
    private DataSource()
    {
        try{
        conn=DriverManager.getConnection(url,user,password);
        System.out.println("cnx établie");    
        }catch(SQLException e){
            e.printStackTrace();
            }
    }
    public static DataSource getInstance()
    {
        if (data==null)
            data=new DataSource();
        return data;
    }

    public Connection getConn() {
        return conn;
    }
    //connection cnx=DataSource.getInstance.getConn
}
