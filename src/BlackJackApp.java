import Game.BlackjackGame;

public class BlackJackApp {

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        String playAgain;
        do {
            game.startRound();
            System.out.print("Play another round? (y/n): ");
            playAgain = game.scanner.nextLine().toLowerCase();
        } while (playAgain.equals("y"));

        game.scanner.close();
        System.out.println("Thanks for playing!");
    }
}
