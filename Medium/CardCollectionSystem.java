import java.util.LinkedHashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Card {
    private String rank;
    private String suit;

    // Constructor
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    // Getters
    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

public class CardCollectionSystem {
    private static Map<String, Set<Card>> cardCollection = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize the card collection with all suits and ranks
        initializeCards();

        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("Enter a suit (e.g., 'Hearts', 'Spades', 'Diamonds', 'Clubs') or 'exit' to quit.");
            System.out.print("Enter suit: ");
            String suit = scanner.nextLine();

            if (suit.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            // Search for the cards by suit
            searchCardsBySuit(suit);
        }
    }

    // Initialize the card collection with all possible suits and ranks
    public static void initializeCards() {
        // Initialize sets for each suit using LinkedHashSet to preserve the order
        Set<Card> hearts = new LinkedHashSet<>();
        Set<Card> spades = new LinkedHashSet<>();
        Set<Card> diamonds = new LinkedHashSet<>();
        Set<Card> clubs = new LinkedHashSet<>();

        // Add cards for Hearts (in the desired order)
        hearts.add(new Card("Ace", "Hearts"));
        hearts.add(new Card("2", "Hearts"));
        hearts.add(new Card("3", "Hearts"));
        hearts.add(new Card("4", "Hearts"));
        hearts.add(new Card("5", "Hearts"));
        hearts.add(new Card("6", "Hearts"));
        hearts.add(new Card("7", "Hearts"));
        hearts.add(new Card("8", "Hearts"));
        hearts.add(new Card("9", "Hearts"));
        hearts.add(new Card("10", "Hearts"));
        hearts.add(new Card("Jack", "Hearts"));
        hearts.add(new Card("Queen", "Hearts"));
        hearts.add(new Card("King", "Hearts"));
        
        // Add cards for Spades (in the desired order)
        spades.add(new Card("Ace", "Spades"));
        spades.add(new Card("2", "Spades"));
        spades.add(new Card("3", "Spades"));
        spades.add(new Card("4", "Spades"));
        spades.add(new Card("5", "Spades"));
        spades.add(new Card("6", "Spades"));
        spades.add(new Card("7", "Spades"));
        spades.add(new Card("8", "Spades"));
        spades.add(new Card("9", "Spades"));
        spades.add(new Card("10", "Spades"));
        spades.add(new Card("Jack", "Spades"));
        spades.add(new Card("Queen", "Spades"));
        spades.add(new Card("King", "Spades"));
        
        // Add cards for Diamonds (in the desired order)
        diamonds.add(new Card("Ace", "Diamonds"));
        diamonds.add(new Card("2", "Diamonds"));
        diamonds.add(new Card("3", "Diamonds"));
        diamonds.add(new Card("4", "Diamonds"));
        diamonds.add(new Card("5", "Diamonds"));
        diamonds.add(new Card("6", "Diamonds"));
        diamonds.add(new Card("7", "Diamonds"));
        diamonds.add(new Card("8", "Diamonds"));
        diamonds.add(new Card("9", "Diamonds"));
        diamonds.add(new Card("10", "Diamonds"));
        diamonds.add(new Card("Jack", "Diamonds"));
        diamonds.add(new Card("Queen", "Diamonds"));
        diamonds.add(new Card("King", "Diamonds"));
        

        // Add cards for Clubs (in the desired order)
        clubs.add(new Card("Ace", "Clubs"));
        clubs.add(new Card("2", "Clubs"));
        clubs.add(new Card("3", "Clubs"));
        clubs.add(new Card("4", "Clubs"));
        clubs.add(new Card("5", "Clubs"));
        clubs.add(new Card("6", "Clubs"));
        clubs.add(new Card("7", "Clubs"));
        clubs.add(new Card("8", "Clubs"));
        clubs.add(new Card("9", "Clubs"));
        clubs.add(new Card("10", "Clubs"));
        clubs.add(new Card("Jack", "Clubs"));
        clubs.add(new Card("Queen", "Clubs"));
        clubs.add(new Card("King", "Clubs"));
        
        // Put all suits into the card collection map
        cardCollection.put("Hearts", hearts);
        cardCollection.put("Spades", spades);
        cardCollection.put("Diamonds", diamonds);
        cardCollection.put("Clubs", clubs);
    }

    // Search for and display all cards of the given suit
    public static void searchCardsBySuit(String suit) {
        if (cardCollection.containsKey(suit)) {
            Set<Card> cards = cardCollection.get(suit);
            System.out.println("Cards of suit " + suit + ":");
            for (Card card : cards) {
                System.out.println(card);
            }
        } else {
            System.out.println("No cards found for suit: " + suit);
        }
    }
}
