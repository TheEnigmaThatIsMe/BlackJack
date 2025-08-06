package Players;

import Game.Deck;

public class Dealer extends Player {

    public void play(Deck deck) {
        while (hand.getValue() < 17) {
            hit(deck);
        }
    }
}
