package com;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {

    private List<Book> books = new ArrayList<>();

    LibraryService(){
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(String title,User user) {
        Book book = findBook(title);
        if(book==null){
            System.out.println(title+" is not found in the library.");
        } else if (!book.isAvailable()) {
            System.out.println(title+" is not available.");
        }else{
            book.borrowBook(user);
        }

    }

    public void returnBook(String title) {
        Book book = findBook(title);
        if (book != null) {
            book.returnBook();
        } else {
            System.out.println(title+" is not found in the library.");
        }
    }
}
