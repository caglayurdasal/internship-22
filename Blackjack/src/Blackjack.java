import java.util.*;

public class Blackjack {
    private static ArrayList<Cards> deck = new ArrayList<>();    // List of cards in the deck
    public static ArrayList<Cards> player = new ArrayList<>();
    public static ArrayList<Cards> dealer = new ArrayList<>();
    public static Random rand = new Random();
    public static Scanner scanner = new Scanner(System.in);

    enum Cards {
        ACE("ACE", 1), TWO("TWO", 2), THREE("THREE", 3), FOUR("FOUR", 4), FIVE("FIVE", 5), SIX("SIX", 6), SEVEN("SEVEN", 7), EIGHT("EIGHT", 8), NINE("NINE", 9), TEN("TEN", 10), JOKER("JOKER", 10), QUEEN("QUEEN", 10), KING("KING", 10);

        final String card;
        final int value;

        // Default constructor
        Cards(String face, int value) {
            this.card = face;
            this.value = value;
        }
    }

    public static void displayHand(ArrayList<Cards> playerHand, ArrayList<Cards> dealerHand) {
        System.out.println(playerHand);
        System.out.println(dealerHand.subList(0, dealerHand.size() - 1));  // Dealer has 1 face down card
    }

    public static int getRandomCard() {
        return rand.nextInt(deck.size());
    }

    public static void createDeck() {
        for (int i = 0; i < 4; i++) {
            deck.addAll(Arrays.asList(Cards.values()));
        }
    }

    public static void drawCard(ArrayList<Cards> person, int numberOfCards) {
        int cardIndex;
        for (int i = 0; i < numberOfCards; i++) {
            cardIndex = getRandomCard();
            person.add(deck.get(cardIndex));
            deck.remove(cardIndex);
        }
    }

    public static int getCardTotal(ArrayList<Cards> person) {
        int total = 0;
        for (Cards card : person) {
            total += card.value;
        }
        return total;
    }

    public static void main(String[] args) {
        boolean isRoundOver = false;
        boolean isGameOver = false;
        createDeck();

        // Give 2 cards each to the player and the dealer
        drawCard(player, 2);
        drawCard(dealer, 2);

        while (!isGameOver) {
            int scorePlayer, scoreDealer;
            while (!isRoundOver) {
                displayHand(player, dealer);
                // If card total of player is 21, they win
                if (getCardTotal(player) == 21) {
                    System.out.println("Player wins!");
                    break;
                }

                System.out.println("Dealer: Do you want to (h)it or (s)tand?");
                System.out.print("Player: ");
                String playerMove = scanner.next();

                switch (playerMove) {
                    case "s":
                        scorePlayer = getCardTotal(player);
                        scoreDealer = getCardTotal(dealer);
                        System.out.println("Dealer's cards: " + dealer);
                        System.out.println("Dealer score: " + scoreDealer + "\nPlayer score: " + scorePlayer);
                        if (scorePlayer > 21) {
                            System.out.println("Dealer wins!");
                            break;
                        } else if (scoreDealer > 21) {
                            System.out.println("Player wins!");
                        } else {
                            if (scoreDealer > scorePlayer) {
                                System.out.println("Dealer wins!");
                            } else {
                                System.out.println("Player wins!");
                            }
                        }
                        isRoundOver = true;
                        break;
                    case "h":

                        break;
                }
            }
            int playerChoice;
            boolean isValid = false;
            System.out.print("(1) New game\n(2) Exit\nEnter 1 or 2: ");
            do {
                playerChoice = scanner.nextInt();
                if (playerChoice == 1) {
                    System.out.println("Again!");
                    isValid = true;
                } else if (playerChoice == 2) {
                    System.out.println("Take care!");
                    isGameOver = true;
                    isValid = true;
                } else {
                    System.out.println("You have entered an invalid character.");
                }
            } while (!isValid);
        }
    }
}
