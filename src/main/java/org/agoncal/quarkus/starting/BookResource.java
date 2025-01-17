package org.agoncal.quarkus.starting;

import jakarta.inject.Inject;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;


@Path("/api/books")
public class BookResource {

    @Inject
    BookRepository repository;

    @Inject
    Logger logger;

    Jsonb jsonb = JsonbBuilder.create();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        logger.info("Returns all books");
        List<Book> books = repository.getAllBooks();
        logger.info(jsonb.toJson(books));
        return books;
    }

    @GET
    @Path("/count")
    @Produces( MediaType.TEXT_PLAIN)
    public int getCount(){
        return repository.getBookCount();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Book> getBook(@PathParam("id") int id){
        logger.info("Returning book with id " + id);
        Optional<Book> book = repository.getBook(id);
    
        logger.info(jsonb.toJson(book.get()));
        return book;
    }

}
