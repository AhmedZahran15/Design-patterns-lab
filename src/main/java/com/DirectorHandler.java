package com;

public class DirectorHandler extends BorrowingHandler {
    
    public DirectorHandler() {
        super(null);
    }
    
    @Override
    public boolean handleRequest(int days) {
        if (days >= 15) {
            System.out.println("Director approved borrowing for " + days + " days");
            return true;
        }
        return false;
    }
}
