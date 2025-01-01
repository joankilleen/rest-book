package org.agoncal.quarkus.starting;

import java.util.List;
import java.util.Optional;

import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class BookRepository {

     public List<Book> getAllBooks() {
        return List.of(
            new Book(1, "Understanding Quarkus", "Eejit", 2020, "IT"),
            new Book (2, "Joan's novel", "Joan", 1995, "Literature")
        );
    }

    public Optional<Book> getBook( int id){
        return getAllBooks().stream().filter(book->book.id == id).findFirst();
    }

    public int getBookCount(){
        return getAllBooks().size();
    }

}
