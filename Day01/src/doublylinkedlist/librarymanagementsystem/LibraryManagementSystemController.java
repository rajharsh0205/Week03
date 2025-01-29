package doublylinkedlist.librarymanagementsystem;

public class LibraryManagementSystemController {
    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();

        // Add books
        library.addBookAtBeginning("1984", "Gukesh", "Comedy", 101, true);
        library.addBookAtEnd("Kill", "Harper Lee", "Fiction", 102, true);
        library.addBookAtPosition("Google", "Pradeep", "Romance", 103, true, 1);

        // Display books
        library.displayBooksForward();
        library.displayBooksReverse();

        // Search for books
        library.searchBook("1984", null);
        library.searchBook(null, "Bro Lee");

        // Update availability
        library.updateAvailability(101, false);

        // Count books
        System.out.println("Total books in the library: " + library.countBooks());

        // Remove a book
        library.removeBookById(103);
        library.displayBooksForward();

        // Count books after removal
        System.out.println("Total books in the library after removal: " + library.countBooks());
    }
}

