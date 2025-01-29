package doublylinkedlist.moviemanagementsystem;

// Main class to test the Movie Management System
public class MovieManagementSystemController {
    public static void main(String[] args) {
        MovieManagementSystem system = new MovieManagementSystem();

        // Adding movies
        system.addMovieAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        system.addMovieAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        system.addMovieAtPosition("Interstellar", "Christopher Nolan", 2014, 8.6, 2);

        // Display movies
        system.displayForward();
        system.displayReverse();

        // Search movies
        system.searchByDirector("Christopher Nolan");
        system.searchByRating(8.8);

        // Update rating
        system.updateRatingByTitle("Inception", 9.0);

        // Remove movie
        system.removeMovieByTitle("Interstellar");

        // Display movies after removal
        system.displayForward();
    }
}