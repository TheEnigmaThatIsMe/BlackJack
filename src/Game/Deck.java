package Game;

import Cards.Card;
import Cards.Rank;
import Cards.Suit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Represents a deck of cards
public class Deck {

    private List<Card> deck;

    public Deck() {
        // Assumes single deck, but could multiply by number of decks
        deck = new ArrayList<>(52);
        resetAndShuffle();
    }

    public Card dealCard() {
        if (deck.isEmpty()) {
            System.out.println("Reshuffling deck");
            resetAndShuffle();
        }
        return deck.removeFirst();
    }

    private void resetAndShuffle() {
        deck.clear();
        for (var suit : Suit.values()) {
            for (var rank : Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        shuffle(deck);
    }

    /**
     * Shuffles a list of objects using the Fisher-Yates algorithm.
     *
     * @param <T> The type of objects in the list.
     * @param list The list of objects to be shuffled.
     */
    public static <T> void shuffle(List<T> list) {
        int n = list.size();
        Random random = new Random(); // Use a single Random instance for efficiency

        // Start from the last element and swap one by one.
        for (int i = n - 1; i > 0; i--) {
            // Pick a random index from 0 to i (inclusive)
            int randomIndex = random.nextInt(i + 1);

            // Swap list[i] with the element at the random index
            T temp = list.get(i);
            list.set(i, list.get(randomIndex));
            list.set(randomIndex, temp);
        }
    }
}
