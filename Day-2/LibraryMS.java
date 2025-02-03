import java.util.*;

class Book {
    int id;
    String title, author;
    boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public void displayBook() {
        System.out.println(id + " | " + title + " | " + author + " | " + (isIssued ? "Issued" : "Available"));
    }
}

public class LibraryMS {
    static List<Book> books = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("\nID | Title | Author | Status");
            for (Book book : books) {
                book.displayBook();
            }
        }
    }

    static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = scanner.nextInt();
        for (Book book : books) {
            if (book.id == id && !book.isIssued) {
                book.isIssued = true;
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book not found or already issued.");
    }

    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = scanner.nextInt();
        for (Book book : books) {
            if (book.id == id && book.isIssued) {
                book.isIssued = false;
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }
}
