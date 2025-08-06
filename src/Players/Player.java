package Players;

import Game.Deck;
import Game.Hand;

public class Player {

    protected Hand hand;

    public Player() {
        hand = new Hand();
    }

    public Hand getHand() {
        return hand;
    }

    public void hit(Deck deck) {
        hand.addCard(deck.dealCard());
    }

    public boolean isBust() {
        return hand.getValue() > 21;
    }
}
