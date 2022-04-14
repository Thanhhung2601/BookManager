/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Model.*;
/**
 *
 * @author MSII
 */
public class BookDAO {
    private JDBCgetConnection db;
    public BookDAO(){
        db = new JDBCgetConnection();
    }
    
    public ArrayList<Book> getAllBook() throws SQLException{
        ArrayList<Book> listBook = new ArrayList<Book>();
        Statement stm = db.getConnection().createStatement();
        ResultSet resultSet = null;
        String query = "Select * from Book";
        resultSet = stm.executeQuery(query);
        while(resultSet.next()){
            listBook.add(new Book(resultSet.getInt(1), resultSet.getString(2),resultSet.getDouble(3)));
        }
        return listBook;
    }
    public ArrayList<Book> deleteById(int id) throws SQLException{
        ArrayList<Book> listBook = new ArrayList<Book>();
        
        PreparedStatement ps = db.getConnection().prepareStatement("delete from Book where id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        
        Statement stm = db.getConnection().createStatement();
        ResultSet resultSet = null;
        String query = "Select * from Book";
        resultSet = stm.executeQuery(query);
        while(resultSet.next()){
            listBook.add(new Book(resultSet.getInt(1), resultSet.getString(2),resultSet.getDouble(3)));
        }
        return listBook;
    }
    
    public void updateBook(int id , String title , Double price) throws SQLException{
        PreparedStatement ps = db.getConnection().prepareStatement("update Book set Title = ? , Price = ? where id = ?");
        ps.setString(1, title);
        ps.setDouble(2, price);
        ps.setInt(3, id);
        ps.executeUpdate();
    }
    
    public void addNewBook(String title , Double price) throws SQLException{
        PreparedStatement ps = db.getConnection().prepareStatement("Insert into Book(Title,Price) values(?,?)");
        ps.setString(1, title);
        ps.setDouble(2, price);
        ps.executeUpdate();
    }
    
}
