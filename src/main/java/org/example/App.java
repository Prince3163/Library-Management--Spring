package org.example;

import org.example.beans.*;
import org.example.configuration.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        String title;
        String authorName;

        int actionNumber;
        int price;

        LibraryImpl lib;
        Author author;
        Book book;

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        lib= context.getBean(LibraryImpl.class);
        lib.setLibName("Ahmedabad_Lib");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Library Management :)");

        do{
            System.out.println("\nFollowings are action numbers with description : " +
                    "\n1 -> Add a new book." +
                    "\n2 -> Print all books in library." +
                    "\n3 -> Remove book by title. "+
                    "\n4 -> Is book Exsists by title. " +
                    "\n5 -> Remove all books from library." +
                    "\n6 -> Update book price." +
                    "\n7 -> Get book details by title." +
                    "\n8 -> All books of author by name."+
                    "\n0 -> Exit from app.");

            System.out.print("==> Enter Action number: ");

            try {
                String action = scanner.nextLine();
                actionNumber = Integer.parseInt(action);
            }
            catch (Exception e){
                actionNumber = -1;
            }

            switch (actionNumber){
                case 1: {
                    System.out.print("Enter book Title : ");
                    title = scanner.nextLine().trim();

                    System.out.print("Enter Author name : ");
                    authorName = scanner.nextLine().trim();
                    author= context.getBean(Author.class,authorName);

                    System.out.print("Enter book Price in numbers only : ");
                    price = scanner.nextInt();

                    book = context.getBean(Book.class,author,title,price);

                    lib.addBook(book);
                    break;
                }

                case 2: {
                    System.out.println("\n==> Collection of our library: ");
                    lib.displayAllBooks();
                    break;
                }

                case 3: {
                    System.out.print("Enter title of book to remove : ");
                    title = scanner.nextLine().trim();
                    lib.removeBookByTitle(title);
                    break;
                }

                case 4: {
                    System.out.print("Enter title of book to check is exsists : ");
                    title = scanner.nextLine().trim();
                    lib.isBookExists(title);
                    break;
                }

                case 5:{
                    lib.removeAllBooks();
                    break;
                }

                case 6: {
                    System.out.print("Enter book Title for Update Price : ");
                    title = scanner.nextLine().trim();

                    System.out.print("Enter new Price in numbers : ");
                    price = scanner.nextInt();

                    lib.updateBookPriceByTitle(title,price);
                    break;
                }

                case 7: {
                    System.out.print("Enter title of book to get details : ");
                    title = scanner.nextLine().trim();
                    lib.printBookDetailsByTitle(title);
                    break;
                }

                case 8: {
                    System.out.print("Enter author name and get all books title : ");
                    authorName = scanner.nextLine().trim();
                    lib.getBooksByAuthorName(authorName);
                    break;
                }

                case 0: {
                    System.out.println("Closing....");
                    break;
                }

                default:{
                    System.out.println("\nInvalid action number!!\n" +
                            "Try with only above mentioned please...");
                    break;
                }
            }
        }
        while ( actionNumber!=0 );

    }
}
