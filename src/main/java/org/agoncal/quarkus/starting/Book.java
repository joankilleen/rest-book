package org.agoncal.quarkus.starting;

import java.io.Serializable;

public class Book implements Serializable  {
    public int id;
    public String title;
    public String author;
    public int yearOfPublication;
    public String genre;

    public Book(int id, String title, String author, int yearOfPublication, String genre){
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.genre = genre;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return id == book.id && title == book.title && author == book.author && yearOfPublication == book.yearOfPublication && genre == book.genre;
    }
    @Override
        public int hashCode() {
            return title.hashCode() + id;
        }
    
}

