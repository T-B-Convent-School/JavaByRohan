import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MovieRecommendationSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, List<String>> genreToMovies = new HashMap<>();

    public static void main(String[] args) {
        // Predefined movies categorized by genre
        initializeMovies();

        System.out.println("Welcome to the Movie Recommendation System!");
        System.out.print("Enter your favorite genre (Action, Comedy, Drama, Horror): ");
        String genre = scanner.nextLine();

        recommendMovies(genre);
    }

    private static void initializeMovies() {
        genreToMovies.put("Action", List.of("Mad Max: Fury Road", "Die Hard", "John Wick"));
        genreToMovies.put("Comedy", List.of("Superbad", "Step Brothers", "The Hangover"));
        genreToMovies.put("Drama", List.of("The Shawshank Redemption", "Forrest Gump", "Parasite"));
        genreToMovies.put("Horror", List.of("Get Out", "A Quiet Place", "The Conjuring"));
    }

    private static void recommendMovies(String genre) {
        List<String> movies = genreToMovies.get(genre);
        if (movies != null) {
            System.out.println("We recommend the following " + genre + " movies:");
            for (String movie : movies) {
                System.out.println("- " + movie);
            }
        } else {
            System.out.println("Sorry, we don't have recommendations for that genre.");
        }
    }
}
