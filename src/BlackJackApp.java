import Game.BlackjackGame;

public class BlackJackApp {

    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        initializeDeck(game);
        String playAgain;
        do {
            game.startRound();
            System.out.print("Play another round? (y/n): ");
            playAgain = game.scanner.nextLine().toLowerCase();
        } while (playAgain.equals("y"));

        game.scanner.close();
        System.out.println("Thanks for playing!");
    }

    private static void initializeDeck(BlackjackGame game) {
        var numberOfDecks = 0;
        do {
            try {
                System.out.print("How many decks do you want to play with? ");
                numberOfDecks = Integer.parseInt(game.scanner.nextLine().toLowerCase());
                if(numberOfDecks <= 0 || numberOfDecks > 8) {
                    throw new Exception("Number must be between 1 and 8");
                }
            } catch (Exception e) {
                System.out.print("Invalid input: " + e.getMessage() + System.lineSeparator());
            }
        } while (numberOfDecks <= 0 || numberOfDecks > 8);

        game.newDeck(numberOfDecks);
    }
}
