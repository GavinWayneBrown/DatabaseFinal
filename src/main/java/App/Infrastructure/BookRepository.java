package App.Infrastructure;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import App.Domain.Book;
import App.Domain.IBookRepository;

public class BookRepository implements IBookRepository{

    private JdbcTemplate databaseConnection;
    @Override
    public Book create(Book item) {
        String sql = "INSERT INTO Library.Book\n" + "VALUES ('" + item.getisbn() + "', '" + item.getdate_published() + "', '" + item.getdescription() + "', '" + item.getavailability() +  "', '" + item.gettitle() + "', '" + item.getauthor_first() + "', '" + item.getauthor_last() + "', '" + item.getauthor_age() + "');";
        this.databaseConnection.execute(sql);
        return item;
    }

    @Override
    public int update(Book item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public int update(String isbn, String date_published, Book item){
        String sql = "UPDATE LIBRARY.BOOK SET isbn = '" + item.getisbn() + "', date_published ='" + item.getdate_published() + "', description ='" + item.getdescription() + "', availability = '" + item.getavailability() +  "', title ='" + item.gettitle() + "', author_first ='" + item.getauthor_first() + "', author_last ='" + item.getauthor_last() + "', author_age ='" + item.getauthor_age() + "'" + 
        "WHERE isbn = '" + isbn + "' AND date_published = '" + date_published + "';";
        int rows = this.databaseConnection.update(sql);
        return rows;
    }
    

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Book> get(String id){
        String sql = "SELECT * FROM Library.BOOK WHERE Book = '" + id + "';";
        List<Book> info = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Book.class));
        return info;
    }

    @Override
    public List<Book> get() {
        String sql = "SELECT * FROM Library.BOOK;";
        List<Book> info = this.databaseConnection.query(sql, BeanPropertyRowMapper.newInstance(Book.class));
        return info;
    }

    public void setDatabaseConnection(JdbcTemplate databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
    

}
