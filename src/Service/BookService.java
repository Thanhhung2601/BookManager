/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.*;
import java.util.ArrayList;
import Model.*;
import java.sql.SQLException;
/**
 *
 * @author MSII
 */
public class BookService {
    private BookDAO bookDao;
    public BookService(){
        bookDao = new BookDAO();
    }
    
    public ArrayList<Book> getAllBook() throws SQLException{
        return bookDao.getAllBook();
    }
    
    public ArrayList<Book> deleteById(int id) throws SQLException{
        return bookDao.deleteById(id);
    }
    
    public void updateBook(int id , String title , Double price) throws SQLException{
        bookDao.updateBook(id, title, price);
    }
    public void addNewBook(String title , Double price) throws SQLException{
        bookDao.addNewBook(title, price);
    }
}
