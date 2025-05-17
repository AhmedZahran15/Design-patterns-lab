package com;

public abstract class BorrowingHandler {
    protected BorrowingHandler nextHandler;
    
    public BorrowingHandler(BorrowingHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    
    public abstract boolean handleRequest(int days);
}
