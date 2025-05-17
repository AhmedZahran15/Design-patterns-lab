package com;

public class LibrarianHandler extends BorrowingHandler {
    
    public LibrarianHandler(BorrowingHandler nextHandler) {
        super(nextHandler);
    }
    
    @Override
    public boolean handleRequest(int days) {
        if (days <= 7) {
            System.out.println("Librarian approved borrowing for " + days + " days");
            return true;
        } else if (nextHandler != null) {
            return nextHandler.handleRequest(days);
        }
        return false;
    }
}