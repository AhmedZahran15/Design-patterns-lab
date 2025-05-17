package com;

public class LibrarianApprovalStrategy implements ApprovalStrategy {
    
    private static final int MAX_DAYS = 7;
    
    @Override
    public boolean approve(int days, Book book, User user) {
        if (days <= MAX_DAYS) {
            System.out.println("Librarian approved borrowing for " + days + " days");
            return true;
        }
        return false;
    }
    
    @Override
    public String getApproverRole() {
        return "Librarian";
    }
}
