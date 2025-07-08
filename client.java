package LibraryManagementSystem;
import java.util.Scanner;

public class client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        Admin admin = new Admin(1);

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Add Book (Admin)");
            System.out.println("2. Remove Book (Admin)");
            System.out.println("3. View Books");
            System.out.println("4. Register User");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("7. View Users");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    int id = library.getNextBookId();
                    admin.addBook(library, new Book(id, title, author));
                    break;

                case 2:
                    System.out.print("Enter Book ID: ");
                    int removeId = sc.nextInt();
                    admin.removeBook(library, removeId);
                    break;

                case 3:
                    library.viewBooks();
                    break;

                case 4:
                    System.out.print("Enter user ID: ");
                    int userId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Type (student/teacher): ");
                    String type = sc.nextLine();

                    if (type.equalsIgnoreCase("student")) {
                        library.registerUser(new Student(userId, name));
                    } else if (type.equalsIgnoreCase("teacher")) {
                        library.registerUser(new Teacher(userId, name));
                    } else {
                        System.out.println("❌ Invalid type.");
                    }
                    break;

                case 5:
                    System.out.print("User ID: ");
                    int borrowUserId = sc.nextInt();
                    System.out.print("Book ID: ");
                    int borrowBookId = sc.nextInt();
                    library.issueBook(borrowUserId, borrowBookId);
                    break;

                case 6:
                    System.out.print("User ID: ");
                    int returnUserId = sc.nextInt();
                    System.out.print("Book ID: ");
                    int returnBookId = sc.nextInt();
                    library.receiveBook(returnUserId, returnBookId);
                    sc.close();
                    break;

                case 7:
                    library.viewUsers();
                    break;

                case 8:
                    System.out.println("Thank you for visiting! GoodBye...");
                    return;

                default:
                    System.out.println("❗ Invalid choice.");
            }
        }
    }
}
