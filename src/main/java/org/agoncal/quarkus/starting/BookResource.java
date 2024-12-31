package org.agoncal.quarkus.starting;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/api/books")
public class BookResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        return List.of(
            new Book(1, "Understanding Quarkus", "Eejit", 2020, "IT"),
            new Book (2, "Joan's novel", "Joan", 1995, "Literature")
        );
    }

    @GET
    @Path("/count")
    @Produces( MediaType.TEXT_PLAIN)
    public int getCount(){
        return getAllBooks().size();
    }

    @GET
    @Path("{id}")
    public Optional<Book> getBook(@PathParam("id") int id){
        return getAllBooks().stream().filter(book->book.id == id).findFirst();
    }

}
