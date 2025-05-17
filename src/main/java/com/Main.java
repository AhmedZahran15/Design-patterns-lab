package com;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new InMemoryBookRepository();
        NotificationService notificationService = new NotificationService();
        LibraryService library = new LibraryService(bookRepository, notificationService);
        Book book = BookFactory.createBook("regular", "Harry Potter");
        Book physicalBook = BookFactory.createBook("physical", "Lord of the Rings");
        Book historicalBook = BookFactory.createBook("historical", "Outlander");
        Book premiumBook = BookFactory.createBook("premium", "Game of Thrones");
        Book eBook = BookFactory.createBook("ebook", "Digital Marketing");
        
        library.addBook(book);
        library.addBook(physicalBook);
        library.addBook(premiumBook);
        library.addBook(eBook);

        User john = new User("John", false);
        User Alice = new User("Alice", true);

        library.borrowBook("Harry Potter", john );
        System.out.printf("\n"+"=============================");
        library.returnBook("Harry Potter");
        System.out.println("=============================");
        
        library.borrowBook("Lord of the Rings",  john);
        System.out.println("=============================");
        
        library.borrowBook("math", john );
        library.returnBook("math");
        System.out.println("=============================");
        
        library.borrowBook("Lord of the Rings", Alice);
        System.out.println("=============================");
        
        library.borrowBook("Outlander", Alice);
        System.out.println("=============================");
        
        library.addBook(historicalBook);
        library.borrowBook("Outlander", Alice);
        System.out.println("=============================");
        
        library.borrowBook("Digital Marketing", john);
        System.out.println("=============================");
        library.borrowBook("Digital Marketing", Alice);
        System.out.println("=============================");
        
        ExternalBook externalBook = new ExternalBook("Design Patterns", "Erich Gamma", 1994, true);
        library.importExternalBook(externalBook);
        System.out.println("=============================");
        System.out.println("borrowing system");
        library.borrowBookWithDays("Design Patterns", john, 7);
        System.out.println("-----------------------------");
        library.borrowBookWithDays("Harry Potter", john, 14); 
        System.out.println("-----------------------------");
        library.borrowBookWithDays("Game of Thrones", Alice, 20);
    }
}
