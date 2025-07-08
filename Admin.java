package LibraryManagementSystem;

public class Admin {
    private int adminId;

    public Admin(int adminId) {
        this.adminId = adminId;
    }

    public void addBook(Library library, Book book) {
        library.registerBook(book);
    }
 
    public void removeBook(Library library, int bookId) {
        library.removeBook(bookId);
    }
}

