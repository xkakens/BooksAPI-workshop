package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Book;
import pl.coderslab.model.MockBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    MockBookService mbs = new MockBookService();

    @GetMapping("")
    public List<Book> allBooks(){
        return mbs.getList();
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book){
        book.setId(mbs.getId());
        mbs.increaseId();
        mbs.addBook(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return mbs.getBookById(id);
    }

    @PutMapping("")
    public void updateBook(@RequestBody Book book){
        mbs.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        mbs.deleteBook(id);
    }
}
