package com;

public class ManagerApprovalStrategy implements ApprovalStrategy {
    
    private static final int MAX_DAYS = 14;
    private static final int MIN_DAYS = 8;
    
    @Override
    public boolean approve(int days, Book book, User user) {
        if (days >= MIN_DAYS && days <= MAX_DAYS) {
            System.out.println("Manager approved borrowing for " + days + " days");
            return true;
        }
        return false;
    }
    
    @Override
    public String getApproverRole() {
        return "Manager";
    }
}
