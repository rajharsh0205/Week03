package doublylinkedlist.librarymanagementsystem;

public class LibraryManagementSystem {
    private Book head;
    private Book tail;

    public LibraryManagementSystem() {
        this.head = null;
        this.tail = null;
    }

    // Add a book at the beginning
    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);

        if (head == null) { // If list is empty
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add a book at the end
    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);

        if (head == null) { // If list is empty
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add a book at a specific position
    public void addBookAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position <= 0) {
            addBookAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }

        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book current = head;
        int index = 0;

        while (current != null && index < position - 1) {
            current = current.next;
            index++;
        }

        if (current == null) {
            addBookAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            newBook.next = current.next;
            if (current.next != null) {
                current.next.prev = newBook;
            }
            newBook.prev = current;
            current.next = newBook;

            if (newBook.next == null) {
                tail = newBook;
            }
        }
    }

    // Remove a book by Book ID
    public void removeBookById(int bookId) {
        if (head == null) {
            System.out.println("The library is empty.");
            return;
        }

        Book current = head;

        while (current != null && current.bookId != bookId) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }

        if (current == head) { // Removing head
            head = head.next;
            if (head != null) {
                head.prev = null;
            } else {
                tail = null; // List becomes empty
            }
        } else if (current == tail) { // Removing tail
            tail = tail.prev;
            tail.next = null;
        } else { // Removing in the middle
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Book with ID " + bookId + " removed successfully.");
    }

    // Search for a book by Title or Author
    public void searchBook(String title, String author) {
        Book current = head;
        boolean found = false;

        while (current != null) {
            if ((title != null && current.title.equalsIgnoreCase(title)) ||
                    (author != null && current.author.equalsIgnoreCase(author))) {
                System.out.println("Found: " + current.title + " by " + current.author + " (Genre: " + current.genre + ", ID: " + current.bookId + ", Available: " + current.isAvailable + ")");
                found = true;
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    // Update a book's availability status
    public void updateAvailability(int bookId, boolean isAvailable) {
        Book current = head;

        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                System.out.println("Availability status for book ID " + bookId + " updated to " + isAvailable);
                return;
            }
            current = current.next;
        }

        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayBooksForward() {
        System.out.println("Books in forward order:");
        Book current = head;

        while (current != null) {
            System.out.println(current.title + " by " + current.author + " (Genre: " + current.genre + ", ID: " + current.bookId + ", Available: " + current.isAvailable + ")");
            current = current.next;
        }
    }

    // Display all books in reverse order
    public void displayBooksReverse() {
        System.out.println("Books in reverse order:");
        Book current = tail;

        while (current != null) {
            System.out.println(current.title + " by " + current.author + " (Genre: " + current.genre + ", ID: " + current.bookId + ", Available: " + current.isAvailable + ")");
            current = current.prev;
        }
    }

    // Count the total number of books
    public int countBooks() {
        int count = 0;
        Book current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }
}
