/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day11;

import java.sql.*;
/**
 *
 * @author charisma
 */
public class JavaDatabase {
    static final String CONN_STR = "jdbc:mysql://localhost/universitas";
    static final String DRIVER = "com.mysql.jdbc.Driver";
    static final String USER = "root";
    static final String PWD = "";
    
    Connection conn;
    
    public JavaDatabase(){
        CreateConnection();
    }
        
    public void CreateConnection(){
        try{
            Class.forName(DRIVER);
            System.out.println("Connecting to Database");
            conn = DriverManager.getConnection(CONN_STR, USER, PWD);
            
            
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    public void RetrieveAll(){
        try{
            String sql = "SELECT * FROM mahasiswa";
            PreparedStatement prepStmt = conn.prepareStatement(sql);
            ResultSet rs = prepStmt.executeQuery();
            
            while(rs.next()){
                int NIM = rs.getInt("NIM");
                String nama = rs.getString("Nama");
                int semester = rs.getInt("Semester");
                
                System.out.println("NIM = " + NIM + " Nama : " + nama +" Semester : "+ semester);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
            
    }
    
    public void Insert(){
        try{
            String sql = "INSERT INTO mahasiswa(NIM,Nama,Semester) VALUES(?,?,?)";
            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, "212312");
            prepStmt.setString(2, "Charisma");
            prepStmt.setInt(3,1);
            
            prepStmt.executeUpdate();
            System.out.println("New inserted Record into Mahasiswa database");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void Update(){
        try{
            String sql = "UPDATE Mahasiswa SET Nama=? WHERE NIM=?";
            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, "John Dahl Tomason");
            prepStmt.setString(2, "212312");
            prepStmt.executeUpdate();
            System.out.println("Update records successfull");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void Delete(){
        try{
            String sql = "DELETE FROM Mahasiswa WHERE NIM = ?";
            PreparedStatement prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, "212312");
            prepStmt.executeUpdate();
            System.out.println("Delete records successfull");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JavaDatabase jdb = new JavaDatabase();
        jdb.RetrieveAll();
        //jdb.Insert();
        jdb.Update();
        jdb.Delete();
    }
}
