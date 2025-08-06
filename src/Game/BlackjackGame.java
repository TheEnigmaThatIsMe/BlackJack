package Game;

import Players.Dealer;
import Players.Player;

import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private Player player;
    private Dealer dealer;
    public Scanner scanner;

    public BlackjackGame() {
        deck = new Deck();
        player = new Player();
        dealer = new Dealer();
        scanner = new Scanner(System.in);
    }

    public void startRound() {
        // Clear hands from previous rounds
        player.getHand().clear();
        dealer.getHand().clear();

        // Deal initial cards
        // TODO: clean up
        player.hit(deck);
        dealer.hit(deck);
        player.hit(deck);
        dealer.hit(deck);

        System.out.println("--- New Round ---");
        System.out.println("Dealer's visible card: " + dealer.getHand().getCards().getFirst());
        System.out.println("Your hand: " + player.getHand().getCards() + " (Value: " + player.getHand().getValue() + ")");

        // Player's turn
        playerTurn();

        if (player.isBust()) {
            System.out.println("You busted! Dealer wins.");
            return;
        }

        // Dealer's turn
        System.out.println("\nDealer's turn.");
        System.out.println("Dealer's hand: " + dealer.getHand().getCards() + " (Value: " + dealer.getHand().getValue() + ")");
        dealer.play(deck);

        if (dealer.isBust()) {
            System.out.println("Dealer's final hand: " + dealer.getHand().getCards() + " (Value: " + dealer.getHand().getValue() + ")");
            System.out.println("Dealer busted! You win!");
        } else {
            determineWinner();
        }
    }

    private void playerTurn() {
        String choice;
        while (true) {
            System.out.print("Do you want to hit or stand? (h/s): ");
            choice = scanner.nextLine().toLowerCase();

            if (choice.equals("h")) {
                player.hit(deck);
                System.out.println("Your hand: " + player.getHand().getCards() + " (Value: " + player.getHand().getValue() + ")");
                if (player.isBust()) {
                    break;
                }
            } else if (choice.equals("s")) {
                break;
            } else {
                System.out.println("Invalid input. Please enter 'h' or 's'.");
            }
        }
    }

    private void determineWinner() {
        int playerValue = player.getHand().getValue();
        int dealerValue = dealer.getHand().getValue();

        System.out.println("\n--- Results ---");
        System.out.println("Your final hand: " + player.getHand().getCards() + " (Value: " + playerValue + ")");
        System.out.println("Dealer's final hand: " + dealer.getHand().getCards() + " (Value: " + dealerValue + ")");

        if (playerValue > dealerValue) {
            System.out.println("You win!");
        } else if (dealerValue > playerValue) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a push!");
        }
    }
}
