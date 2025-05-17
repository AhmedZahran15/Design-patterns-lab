package com;

public class BookAdapter {
    
    public static Book adaptExternalBook(ExternalBook externalBook) {
        Book book = new Book(externalBook.getBookTitle());
        book.setAvailable(externalBook.isBorrowable());
        return book;
    }
}
