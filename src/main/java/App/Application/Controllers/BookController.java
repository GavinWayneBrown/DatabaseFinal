package App.Application.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import App.Domain.Book;
import App.Infrastructure.BookRepository;

@RestController()
@RequestMapping("/BookController")

public class BookController {

    @Autowired
    private JdbcTemplate databaseConnection;

    

    private BookRepository BookRepository;
    public BookController(){
        this.BookRepository = new BookRepository();
    }

    @GetMapping("/")
    public List<Book> Get(){
        this.BookRepository.setDatabaseConnection(databaseConnection);  
        return this.BookRepository.get();
    }

    @GetMapping("/{id}")
    public List<Book> Get(@PathVariable("id") String id){
        this.BookRepository.setDatabaseConnection(databaseConnection);
        return this.BookRepository.get(id);
    }
    @PostMapping("/")
    public String post(@RequestBody() Book bookToSave){
        this.BookRepository.setDatabaseConnection(databaseConnection);
        this.BookRepository.create(bookToSave);
        return bookToSave.getisbn();
    }
    @PutMapping("/{isbn}/{date_published}")
    public void put(@RequestBody() Book bookToUpdate, @PathVariable("isbn") String isbn, @PathVariable("date_published") String date_published){
        this.BookRepository.setDatabaseConnection(databaseConnection);
        this.BookRepository.update(isbn, date_published, bookToUpdate);
    }
}
