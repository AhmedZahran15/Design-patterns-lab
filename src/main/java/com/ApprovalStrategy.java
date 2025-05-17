package com;

public interface ApprovalStrategy {
    boolean approve(int days, Book book, User user);
    String getApproverRole();
}
