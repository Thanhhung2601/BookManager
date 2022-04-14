/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.*;
/**
 *
 * @author MSII
 */
public class ListBook {
    private ArrayList<Book> arrbook = new ArrayList<Book>(); ;
    public ListBook(ArrayList<Book> list){
        this.arrbook = list;
    }

    public ArrayList<Book> getArrbook() {
        return arrbook;
    }

    public void setArrbook(ArrayList<Book> arrbook) {
        this.arrbook = arrbook;
    }
    
}
