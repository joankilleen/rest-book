package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import static org.hamcrest.CoreMatchers.is;
import java.util.Map;

import java.util.HashMap;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalToObject;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static io.restassured.RestAssured.given;


@QuarkusTest
class BookResourceTest {
    @Test
    void shouldGetAllBooks() {
        given()
        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
          .when().get("/api/books")        
          .then()
             .statusCode(200)
             .body("size()", is(2))
             .body("find { it.title == 'Understanding Quarkus' }.author", equalTo("Eejit"));            
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
            ;
    }
}