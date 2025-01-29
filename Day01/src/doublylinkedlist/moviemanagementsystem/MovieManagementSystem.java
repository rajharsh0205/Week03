package doublylinkedlist.moviemanagementsystem;

// Doubly Linked List class for managing movies
public class MovieManagementSystem {
    private MovieNode head;
    private MovieNode tail;

    // Constructor
    public MovieManagementSystem() {
        this.head = null;
        this.tail = null;
    }

    // Add a movie at the beginning
    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Movie added at the beginning: " + title);
    }

    // Add a movie at the end
    public void addMovieAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Movie added at the end: " + title);
    }

    // Add a movie at a specific position
    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Position should be >= 1.");
            return;
        }
        if (position == 1) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }
        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode current = head;
        int count = 1;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Position exceeds the list size. Movie not added.");
            return;
        }
        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }
        current.next = newNode;
        newNode.prev = current;
        System.out.println("Movie added at position " + position + ": " + title);
    }

    // Remove a movie by title
    public void removeMovieByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty. No movie to remove.");
            return;
        }
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                System.out.println("Movie removed: " + title);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found: " + title);
    }

    // Search for movies by director
    public void searchByDirector(String director) {
        MovieNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.director.equals(director)) {
                System.out.println("Movie found: " + current.title + " (" + current.year + "), Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found for director: " + director);
        }
    }

    // Search for movies by rating
    public void searchByRating(double rating) {
        MovieNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.rating == rating) {
                System.out.println("Movie found: " + current.title + " (" + current.year + "), Director: " + current.director);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found with rating: " + rating);
        }
    }

    // Display all movies in forward order
    public void displayForward() {
        MovieNode current = head;
        if (current == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("Movies in forward order:");
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movies in reverse order
    public void displayReverse() {
        MovieNode current = tail;
        if (current == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("Movies in reverse order:");
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    // Update a movie's rating by title
    public void updateRatingByTitle(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for movie: " + title + ". New rating: " + newRating);
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found: " + title);
    }
}
