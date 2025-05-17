package com;

public class EBook extends Book implements ElectronicBookInterface {
    private boolean requiresPremiumAccess = true;

    public EBook(String title) {
        super(title);
    }
    
    @Override
    public void borrowBook(User user) {
        if (user.isPremium() || !requiresPremiumAccess) {
            super.borrowBook(user);
            System.out.println(" e-book");
        } else {
            System.out.println("Only premium users can borrow e-books.");
        }
    }
    
    @Override
    public boolean requiresPremiumAccess() {
        return requiresPremiumAccess;
    }
    
    public void setRequiresPremiumAccess(boolean requiresPremiumAccess) {
        this.requiresPremiumAccess = requiresPremiumAccess;
    }
}
