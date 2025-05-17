package com;

public abstract class BookFactory {
    public static Book createBook(String type, String title) {
        switch (type.toLowerCase()) {
            case "physical":
                return new PhysicalBook(title);
            case "ebook":
                return new EBook(title);
            case "historical":
                return new HistoricalBook(title);
            case "premium":
                return new PremiumBook(title);
            default:
                return new Book(title);
        }
    }
}