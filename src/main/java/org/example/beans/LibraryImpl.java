package org.example.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Scope("singleton")
public class LibraryImpl implements Library{

    private String libName;

    List<Book> booklst = new ArrayList<>();


    @Override
    public void setLibName(String name) {
        this.libName=name;
    }

    public String getLibName(){
        return libName;
    }

    @Override
    public void addBook(Book book) {
        booklst.add(book);
    }

    @Override
    public void displayAllBooks(){
        System.out.println("Books in \""+libName+"\" : ");
        for(Book book1 : booklst){
            System.out.println(book1);
        }
    }

    @Override
    public void removeBookByTitle(String title) {

        Book book1 = findBookObjByTitle(title);

        if( book1 != null){
            booklst.remove(book1 );
            System.out.println("-------Book Removed-------");
            displayAllBooks();
        }
        else{
            System.out.println("-------Book Not Exsist!!-------");
        }
    }

    @Override
    public void isBookExists(String title) {
        if(  findBookObjByTitle(title) == null ) {
            System.out.println("No, \""+title+ "\" is't exists.");
            return;
        }
        System.out.println("Yes, \""+title+ "\" is exists in "+libName);
    }

    @Override
    public void removeAllBooks() {
        System.out.println("Clearing books...");
        booklst.clear();
        System.out.println("-------\nNow Library has ZERO books.\n-------");
    }

    @Override
    public void updateBookPriceByTitle(String title , int newPrice) {
        Book book1 = findBookObjByTitle(title);
        if( book1 == null ){
            System.out.println("-------Book Not Found!!-------");
        }
        else{
            book1.setPrice(newPrice);
            System.out.println("\n-------Price of \""+title+"\" Updated-------");
            printBookDetailsByTitle(title);
        }
    }

    @Override
    public void printBookDetailsByTitle(String title) {

        Book book1 = findBookObjByTitle(title);
        if( book1 != null ){
            System.out.println(book1);
        }
        else{
            System.out.println("-------Book Not Found!!-------");
        }
    }

    @Override
    public void getBooksByAuthorName(String authorName) {
        List<Book> booksOfAuthor = booklst.stream()
                .filter(book1 -> book1.getAuthor().getName().equals(authorName))
                .collect(Collectors.toList());

        System.out.println(booksOfAuthor);
     }



    @Override
    public Book findBookObjByTitle(String title){
        return booklst.stream()
                .filter(book1 -> book1.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    @PostConstruct
    public void init(){
        System.out.println("\nInitializing Library with name = "+libName);
    }

    @PreDestroy
    public  void clean(){
        System.out.println("Destroying ....");
        booklst.clear();
    }
}