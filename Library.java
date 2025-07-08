package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;
public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void registerBook(Book book) {
        books.add(book);
        System.out.println("Book registered: " + book.getTitle());
    }

    public void removeBook(int bookId) {
        books.removeIf(book -> book.getBookId() == bookId);
        System.out.println("Book removed: ID " + bookId);
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println("User registered: " + user.name);
    }

    public void issueBook(int userId, int bookId) {
        User user = getUser(userId);
        Book book = getBook(bookId);

        if (user != null && book != null && book.isAvailable()) {
            user.borrowBook(bookId);
            book.setAvailable(false);
            System.out.println("Book issued to " + user.name);
        } else {
            System.out.println("Cannot issue. User or book not found, or book is already borrowed.");
        }
    }

    public void receiveBook(int userId, int bookId) {
        User user = getUser(userId);
        Book book = getBook(bookId);

        if (user != null && book != null) {
            user.returnBook(bookId);
            book.setAvailable(true);
            System.out.println("Book returned: " + book.getTitle());
        }
    }

    public void viewBooks() {
        System.out.println("Book List:");
        for (Book book : books) {
            System.out.println("  - " + book);
        }
    }

    public void viewUsers() {
        System.out.println("User List:");
        for (User user : users) {
            System.out.println("  - " + user);
        }
    }

    private User getUser(int id) {
        for (User user : users)
            if (user.getUserId() == id) return user;
        return null;
    }

    private Book getBook(int id) {
        for (Book book : books)
            if (book.getBookId() == id) return book;
        return null;
    }

	public void addBook(String title, String author){
		
	}

	public int getNextBookId() {
		// TODO Auto-generated method stub
		return 0;
	}
}


