package com;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookRepository implements BookRepository {
    private List<BookInterface> books = new ArrayList<>();
    
    @Override
    public void addBook(BookInterface book) {
        books.add(book);
    }
    
    @Override
    public BookInterface findBook(String title) {
        for (BookInterface book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    
    @Override
    public List<BookInterface> getAllBooks() {
        return new ArrayList<>(books);
    }
}
