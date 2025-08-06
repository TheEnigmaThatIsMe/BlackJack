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

    public Deck() {
        // Assumes single deck, but could multiply by number of decks
        deck = new ArrayList<>(52);
        for(var suit : Suit.values()) {
            for(var rank : Rank.values()) {
                deck.add(new Card(suit, rank));
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
            new Deck();
        }
        return deck.removeFirst();
    }
}
