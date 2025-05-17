package com;

import java.util.List;

public interface BookRepository {
    void addBook(BookInterface book);
    BookInterface findBook(String title);
    List<BookInterface> getAllBooks();
}
