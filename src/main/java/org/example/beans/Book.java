package org.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Book {
    private Author author;
    private String title;
    private int price;


    public Book(Author author , String title , int price){
        this.author = author;
        this.title = title;
        this.price = price;
    }

    public void setPrice(int  price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public Author getAuthor(){
        return author;
    }


    @Override
    public String toString() {
        return "Book : {" +
                "title='" + title + '\'' +
                ", author=" + author.getName() +
                ", price='" + price + '\'' +
                '}';
    }

}