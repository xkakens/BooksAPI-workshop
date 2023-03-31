package pl.coderslab.model;

import java.util.ArrayList;
import java.util.List;

public class MockBookService {
    private static Long nextId = 4L;
    private List<Book> list;
    public MockBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        list.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }

    public List<Book> getList(){
        return this.list;
    }

    public Long getId(){
        return nextId;
    }

    public void increaseId(){
        nextId++;
    }

    public void addBook(Book book){
        list.add(book);
    }

    public Book getBookById(Long id){
        for(Book book : list){
            if(book.getId().equals(id)){
                return book;
            }
        }
        return new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming");
    }

    public void updateBook(Book book){
        for(Book book2 : list){
            if(book2.getId().equals(book.getId())){
                book2.setIsbn(book.getIsbn());
                book2.setAuthor(book.getAuthor());
                book2.setPublisher(book.getPublisher());
                book2.setType(book.getType());
                book2.setTitle(book.getTitle());
            }
        }
    }
    public void deleteBook(Long id){
        list.removeIf(book2 -> book2.getId().equals(id));
    }
}
