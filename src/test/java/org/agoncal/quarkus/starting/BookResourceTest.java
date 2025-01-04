package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import static org.hamcrest.CoreMatchers.is;
import java.util.Map;

import java.util.HashMap;

import org.hamcrest.Matchers;

import static org.hamcrest.CoreMatchers.hasItem;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;


@QuarkusTest
class BookResourceTest {
    @Test
    void shouldGetAllBooks() {
        //new Book(1, "Understanding Quarkus", "Eejit", 2020, "IT")
        Map<String, Object> expected = new HashMap<String, Object>();
        expected.put("id", 1);
        expected.put("title", "Understanding Quarkus");
        expected.put("author", "Eejit");
        expected.put("yearOfPublication", "2020");
        expected.put("genre", "IT");

        given()
        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
          .when().get("/api/books")
        
          .then()
             .statusCode(200)
             .body("size()", is(2))
             //.body("$", Matchers.containsInAnyOrder(expected))
             
          
             ;
    }

    @Test
    void shouldGetBook(){
        given()
        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
          .when().get("/api/books/2")
          .then()
            .statusCode(200)
            .body("id", Matchers.equalTo(2))
            .body("title", Matchers.equalTo("Joan's novel"))
            .body("genre", Matchers.equalTo("Literature"))
            ;
    }

}