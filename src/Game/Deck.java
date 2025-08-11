package Game;

import Cards.Card;
import Cards.Rank;
import Cards.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Represents a deck of cards
public class Deck {

    private List<Card> deck;
    private int numberOfDecks;

    public Deck(int numberOfDecks) {
        this.numberOfDecks = numberOfDecks;
        deck = new ArrayList<>(52 * numberOfDecks);
        for(int i = 0; i < numberOfDecks; i++) {
            for(var suit : Suit.values()) {
                for(var rank : Rank.values()) {
                    deck.add(new Card(suit, rank));
                }
            }
        }

        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(deck);
    }

    public Card dealCard() {
        if (deck.isEmpty()) {
            System.out.println("Reshuffling deck");
            new Deck(numberOfDecks);
        }
        return deck.removeFirst();
    }
}
