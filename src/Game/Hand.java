package Game;

import Cards.Card;
import Cards.Rank;

import java.util.ArrayList;
import java.util.List;

// Represents a hand of cards
public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getValue() {
        int value = 0;
        int aceCount = 0;
        for(var card : cards) {
            value += card.getValue();
            if (card.getRank() == Rank.ACE) {
                aceCount++;
            }
        }

        // Adjust for Aces if busting
        while(value > 21 && aceCount > 0) {
            value -= 10; // Change ace value from 11 to 1
            aceCount--;
        }
        return value;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void clear() {
        cards.clear();
    }
}
