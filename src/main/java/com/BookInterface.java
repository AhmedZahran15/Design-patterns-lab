package com;

public interface BookInterface {
    void borrowBook(User user);
    void returnBook();
    boolean isAvailable();
    String getTitle();
    void setAvailable(boolean available);
}
