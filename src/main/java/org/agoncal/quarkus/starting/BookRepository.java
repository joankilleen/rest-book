package org.agoncal.quarkus.starting;

import java.util.List;
import java.util.Optional;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class BookRepository {


    @ConfigProperty (name="books.genre", defaultValue ="IT")
    String genre;

    public List<Book> getAllBooks() {
        return List.of(
            new Book(1, "Understanding Quarkus", "Eejit", 2020, genre),
            new Book (2, "Joan's novel", "Joan", 1995, genre)
        );
    }

    public Optional<Book> getBook( int id){
        return getAllBooks().stream().filter(book->book.id == id).findFirst();
    }

    public int getBookCount(){
        return getAllBooks().size();
    }

}
