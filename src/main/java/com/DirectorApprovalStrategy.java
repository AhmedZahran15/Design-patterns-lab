package com;

public class DirectorApprovalStrategy implements ApprovalStrategy {
    
    private static final int MIN_DAYS = 15;
    
    @Override
    public boolean approve(int days, Book book, User user) {
        if (days >= MIN_DAYS) {
            System.out.println("Director approved borrowing for " + days + " days");
            return true;
        }
        return false;
    }
    
    @Override
    public String getApproverRole() {
        return "Director";
    }
}
