package com;

public class PremiumBook extends Book implements PremiumBookInterface {
    private static final int EXTRA_DAYS = 10;

    public PremiumBook(String title) {
        super(title);
    }

    @Override
    public void borrowBook(User user) {
        super.borrowBook(user);
        System.out.println(" premium book (+" + EXTRA_DAYS + " days)");
    }
    
    @Override
    public int getExtraBorrowingDays() {
        return EXTRA_DAYS;
    }
}