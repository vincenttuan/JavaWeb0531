package com.web.rest.bookstore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    
    // 書籍資料庫
    public static List<Book> books = new ArrayList<>();
    // 資料庫連線物件
    private static Connection conn;
    static {
        try {
            // 資料庫驅動物件
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            // 建立 conn 物件
            String url = "jdbc:derby://localhost:1527/javaweb";
            String user = "app";
            String password = "app";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
        }
    }
    
    // 多筆查詢
    public static List<Book> getBooks() {
        return books;
    }
    
    // 單筆查詢
    public static Book getBook(Integer id) {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .get();
    } 
    
    // 新增
    public static Boolean createBook(Book book) {
        boolean flag = books.stream()
                .filter(b -> b.getId() == book.getId())
                .findAny()
                .isPresent();
        if(flag == false) {
            books.add(book);
            return true;
        }
        return false;
    }
    
    // 修改
    public static Boolean updateBook(Integer id, Book book) {
        // 是否庫存中有此筆資料 ?
        Book oBook = getBook(id);
        if(oBook == null) {
            return false;
        }
        // 將 book 的資料給 oBook
        oBook.setName(book.getName());
        oBook.setPrice(book.getPrice());
        oBook.setAmount(book.getAmount());
        return true;
    }
    
    // 刪除
    public static Boolean deleteBook(Integer id) {
        // 是否庫存中有此筆資料 ?
        Book oBook = getBook(id);
        if(oBook == null) {
            return false;
        }
        books.remove(oBook);
        return true;
    }
}