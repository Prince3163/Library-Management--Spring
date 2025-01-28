package org.example.beans;

import java.util.ArrayList;

public interface Library {

    public void setLibName(String name);
    public void addBook(Book book);
    public void removeBookByTitle(String title);
    public void isBookExists (String title);
    public void removeAllBooks();
    public void updateBookPriceByTitle(String title, int newPrice);
    public void printBookDetailsByTitle(String title);
    public void displayAllBooks();
    public void getBooksByAuthorName(String authorName);
    public Book findBookObjByTitle(String title);
}