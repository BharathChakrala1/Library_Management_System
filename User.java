package LibraryManagementSystem;

import java.util.*;

public abstract class User {
    protected int userId;
    protected String name;
    protected List<Integer> borrowedBookIds = new ArrayList<>();

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public abstract int getLimit();

    public void borrowBook(int bookId) {
        if (borrowedBookIds.size() < getLimit()) {
            borrowedBookIds.add(bookId);
        } else {
            System.out.println("⚠️ Limit reached. Cannot borrow more books.");
        }
    }

    public void returnBook(int bookId) {
        borrowedBookIds.remove(Integer.valueOf(bookId));
    }

    public int getUserId() {
        return userId;
    }

    public List<Integer> getBorrowedBookIds() {
        return borrowedBookIds;
    }

    @Override
    public String toString() {
        return userId + " - " + name + " | Borrowed Books: " + borrowedBookIds;
    }
}
