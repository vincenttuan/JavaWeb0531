
import com.web.rest.bookstore.Book;
import static com.web.rest.bookstore.BookDao.books;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vincenttuan
 */
public class QueryBookTable {

    public static void main(String[] args) throws Exception {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/javaweb", "app", "app");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from book");
        while (rs.next()) {
            books.add(new Book(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("price")));

        }
        System.out.println(books);
    }
}
