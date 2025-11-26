# Java-Library-System

This Java program implements a basic console-based Library Management System that allows users to add books, borrow books, return books, and list all available books with their quantities. The program uses object-oriented principles and basic data structures to manage the library inventory efficiently.

Key Components:
1. Book Class

The Book class models a book object with three attributes:

title: The title of the book.

author: The author of the book.

quantity: The number of copies available in the library.

It includes:

A constructor to initialize these attributes.

Getter methods (getTitle(), getAuthor(), getQuantity()) to safely access book details.

Methods to manipulate quantity:

addQuantity(int amount): Increases the quantity when new copies are added.

borrowBook(int amount): Decreases quantity if enough copies are available; returns success status.

returnBook(int amount): Increases quantity when books are returned.

2. Library Data Structure

The library inventory is maintained using a HashMap<String, Book>, where the key is the book title (a String), and the value is the corresponding Book object.

This allows for efficient lookup, addition, and updates of books by their titles.

3. User Interface and Input Handling

The program runs a loop that continuously displays a menu of options:

Add Books

Borrow Books

Return Books

List Available Books

Exit

It uses a Scanner to capture user input and ensures robust input validation to handle invalid inputs gracefully.

4. Functionalities

Add Books:

Prompts the user for title, author, and quantity.

If the book already exists, the quantity is updated by adding the new amount.

Otherwise, a new Book object is created and added to the library.

Borrow Books:

Prompts the user for the book title and number of copies to borrow.

Checks if the book exists and if sufficient copies are available.

If available, updates the quantity and confirms the borrowing.

If not, informs the user of insufficient stock.

Return Books:

Prompts the user for the book title and number of copies to return.

Validates if the book belongs to the library.

Updates the quantity accordingly and confirms the return.

List Available Books:

Displays a formatted list of all books in the library, showing the title, author, and available quantity.

If no books are available, it informs the user accordingly.

Exit:

Ends the program loop and exits the system.

5. Input Validation

The helper method getValidNumber() ensures that numerical inputs (for quantities and menu choices) are integers.

Invalid inputs prompt error messages, and the program re-requests valid inputs without crashing.

How Control Structures Are Used:

Loops:

A do-while loop controls the main menu, ensuring the program runs repeatedly until the user chooses to exit.

A while loop inside getValidNumber() ensures valid integer input is obtained.

A for-each loop iterates over the HashMap entries when listing all books.

Conditional Statements:

if-else and switch-case statements handle user choices and business logic decisions (like book availability and input validity).

Exception Handling:

Although explicit try-catch blocks are not used, input validation prevents invalid input types that could cause runtime exceptions.

Summary

This program demonstrates fundamental Java programming concepts such as classes, objects, collections (HashMap), user input handling, loops, and conditional logic. It efficiently manages library books and quantities while providing a user-friendly console interface with robust input validation.