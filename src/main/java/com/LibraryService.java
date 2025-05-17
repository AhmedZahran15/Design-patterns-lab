package com;
import java.util.Arrays;
import java.util.List;

public class LibraryService {

    private final BookRepository bookRepository;
    private final NotificationService notificationService;
    private final List<ApprovalStrategy> approvalStrategies;

    public LibraryService(BookRepository bookRepository, NotificationService notificationService) {
        this.bookRepository = bookRepository;
        this.notificationService = notificationService;
        
        this.approvalStrategies = Arrays.asList(
            new LibrarianApprovalStrategy(),
            new ManagerApprovalStrategy(),
            new DirectorApprovalStrategy()
        );
    }
    
    public LibraryService() {
        this.bookRepository = new InMemoryBookRepository();
        this.notificationService = new NotificationService();
        
        this.approvalStrategies = Arrays.asList(
            new LibrarianApprovalStrategy(),
            new ManagerApprovalStrategy(),
            new DirectorApprovalStrategy()
        );
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
        notificationService.notifyBookAvailable(book.getTitle());
    }

    public Book findBook(String title) {
        return (Book) bookRepository.findBook(title);
    }

    public void borrowBook(String title, User user) {
        BookInterface book = bookRepository.findBook(title);
        if(book == null) {
            System.out.println(title + " is not found in the library.");
        } else if (!book.isAvailable()) {
            System.out.println(title + " is not available.");
            notificationService.registerForNotification(title, user);
        } else {
            book.borrowBook(user);
        }
    }

    public void returnBook(String title) {
        BookInterface book = bookRepository.findBook(title);
        if (book != null) {
            book.returnBook();
        } else {
            System.out.println(title + " is not found in the library.");
        }
    }
    
    public boolean borrowBookWithDays(String title, User user, int days) {
        BookInterface book = bookRepository.findBook(title);
        if(book == null) {
            System.out.println(title + " is not found in the library.");
            return false;
        } else if (!book.isAvailable()) {
            System.out.println(title + " is not available.");
            notificationService.registerForNotification(title, user);
            return false;
        } else {
            for (ApprovalStrategy strategy : approvalStrategies) {
                if (strategy.approve(days, (Book)book, user)) {
                    book.borrowBook(user);
                    return true;
                }
            }
            System.out.println("No approval strategy found for " + days + " days");
            return false;
        }
    }

    public void importExternalBook(ExternalBook externalBook) {
        Book book = BookAdapter.adaptExternalBook(externalBook);
        addBook(book);
        System.out.println("Imported book: " + book.getTitle());
    }
}
