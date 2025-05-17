package com;

public class ManagerHandler extends BorrowingHandler {
    
    public ManagerHandler(BorrowingHandler nextHandler) {
        super(nextHandler);
    }
    
    @Override
    public boolean handleRequest(int days) {
        if (days <= 14) {
            System.out.println("Manager approved borrowing for " + days + " days");
            return true;
        } else if (nextHandler != null) {
            return nextHandler.handleRequest(days);
        }
        return false;
    }
}
