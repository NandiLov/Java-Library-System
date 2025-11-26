import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Class to represent a Book object with title, author, and quantity
class Book {
    private String title;
    private String author;
    private int quantity;

    // Constructor to initialize book details
    public Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // Method to increase quantity when books are added
    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    // Method to borrow books if available
    public boolean borrowBook(int amount) {
        if (amount <= quantity) {
            quantity -= amount;
            return true;  // Borrow successful
        }
        return false;  // Not enough books to borrow
    }

    // Method to return books
    public void returnBook(int amount) {
        quantity += amount;
    }
}

public class LibrarySystem {

    // HashMap to store books using title as key
    private static Map<String, Book> library = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        // Main program loop (runs until user selects Exit)
        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. List Available Books"); //I added this to better show how the program works
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Validate numeric input for menu option
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number 1-5.");
                scanner.next();  // Clear invalid input
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline character

            // Switch-case to handle user choice including new option
            switch (choice) {
                case 1:
                    addBooks();
                    break;
                case 2:
                    borrowBooks();
                    break;
                case 3:
                    returnBooks();
                    break;
                case 4:
                    listAvailableBooks();  // Call method to list books
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option! Please choose 1-5.");
            }

        } while (choice != 5);  // Exit condition
    }

    // ------------------- ADD BOOKS -------------------
    private static void addBooks() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();

        System.out.print("Enter author name: ");
        String author = scanner.nextLine().trim();

        System.out.print("Enter quantity: ");
        int quantity = getValidNumber();  // Validate numeric input

        // If book already exists, only update quantity
        if (library.containsKey(title)) {
            library.get(title).addQuantity(quantity);
            System.out.println("Book already exists. Quantity updated successfully.");
        } else {
            // Add new book to library
            library.put(title, new Book(title, author, quantity));
            System.out.println("Book added successfully!");
        }
    }

    // ------------------- BORROW BOOKS -------------------
    private static void borrowBooks() {
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine().trim();

        // Check if book exists
        if (!library.containsKey(title)) {
            System.out.println("Error: Book not found in library.");
            return;
        }

        System.out.print("Enter number of copies: ");
        int amount = getValidNumber();

        Book book = library.get(title);

        // Borrow logic with quantity checking
        if (book.borrowBook(amount)) {
            System.out.println("Successfully borrowed " + amount + " copies of \"" + title + "\".");
        } else {
            System.out.println("Not enough copies available. Current stock: " + book.getQuantity());
        }
    }

    // ------------------- RETURN BOOKS -------------------
    private static void returnBooks() {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine().trim();

        // Check if the book belongs to the library
        if (!library.containsKey(title)) {
            System.out.println("Error: This book does not belong to the library system.");
            return;
        }

        System.out.print("Enter number of copies: ");
        int amount = getValidNumber();

        Book book = library.get(title);
        book.returnBook(amount);

        System.out.println("Successfully returned " + amount + " copies of \"" + title + "\".");
    }

    // ------------------- LIST AVAILABLE BOOKS -------------------
    private static void listAvailableBooks() {
        if (library.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        System.out.println("\nAvailable Books:");
        System.out.printf("%-30s %-20s %-10s\n", "Title", "Author", "Quantity");
        System.out.println("---------------------------------------------------------");

        // Loop through all books and display their details
        for (Book book : library.values()) {
            System.out.printf("%-30s %-20s %-10d\n",
                    book.getTitle(), book.getAuthor(), book.getQuantity());
        }
    }

    // ------------------- HELPER METHOD TO VALIDATE INTEGER INPUT -------------------
    private static int getValidNumber() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid number. Please enter a valid integer:");
            scanner.next();  // Clear invalid input
        }
        return scanner.nextInt();
    }
}
