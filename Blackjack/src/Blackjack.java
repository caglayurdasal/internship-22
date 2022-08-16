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
        System.out.println("Player's hand: " + playerHand);
        System.out.println("Dealer's hand: " + dealerHand.subList(0, dealerHand.size() - 1));  // Dealer has 1 face down card
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

    public static void announceWinner(int pointsPlayer, int pointsDealer) {
        System.out.println("********************************");
        if (pointsPlayer == pointsDealer) {
            System.out.println("It's a tie!");
        } else if (pointsPlayer > 21) { // If player has over 21 points, dealer wins
            System.out.println("Dealer wins!");
        } else if (pointsPlayer == 21 || pointsDealer > 21) { // If player has 21 points OR dealer has over 21 points AND player has under 21, player wins
            System.out.println("Player wins!");
        } else if (pointsDealer < 21) {    // If both sides have under 21 points, the one with the highest points wins
            while (pointsDealer < 17) {
                drawCard(dealer, 1);
                pointsDealer = getCardTotal(dealer);
            }
            if (pointsDealer < pointsPlayer) {
                System.out.println("Player wins!");
            } else {
                System.out.println("Dealer wins!");
            }
        }
        System.out.println("Dealer's hand: " + dealer);
        System.out.println("Dealer's score: " + pointsDealer);
        System.out.println("Player's hand: " + player);
        System.out.println("Player's score: " + pointsPlayer);
    }


    public static void main(String[] args) {
        System.out.println("Welcome!");
        boolean isRoundOver = false;
        boolean isGameOver = false;
        createDeck();

        while (!isGameOver) {
            player.clear();
            dealer.clear();
            // Give 2 cards each to the player and the dealer
            drawCard(player, 2);
            drawCard(dealer, 2);
            while (!isRoundOver) {
                int pointsPlayer = getCardTotal(player);
                int pointsDealer = getCardTotal(dealer);
                displayHand(player, dealer);
                // If card total of player is 21, they win
                if (pointsPlayer >= 21) {
                    announceWinner(pointsPlayer, pointsDealer);
                    isRoundOver = true;
                } else {
                    System.out.println("Do you want to (h)it or (s)tand?");
                    System.out.print("Player: ");
                    String playerMove = scanner.nextLine();
                    switch (playerMove) {
                        case "s" -> {
                            announceWinner(pointsPlayer, pointsDealer);
                            isRoundOver = true;
                        }
                        case "h" -> {
                            drawCard(player, 1);
                            pointsPlayer = getCardTotal(player);
                            if (pointsPlayer >= 21) {
                                announceWinner(pointsPlayer, pointsDealer);
                                isRoundOver = true;
                            }
                        }
                    }
                }
            }
            int playerChoice;

            boolean isValid = false;
            System.out.print("(1) New game\n(2) Exit\nEnter 1 or 2: ");
            while (!isValid) {
                playerChoice = Integer.parseInt(scanner.nextLine());
                if (playerChoice == 1) {
                    System.out.println("Again!");
                    if (deck.size() <= 25) {
                        System.out.println("Number of cards left: " + deck.size());
                        isGameOver = true;
                    }
                    isRoundOver = false;
                    isValid = true;
                } else if (playerChoice == 2) {
                    System.out.println("Take care!");
                    isValid = true;
                    isGameOver = true;
                } else {
                    System.out.println("You have entered an invalid character.");
                }
                System.out.println();
            }
        }
    }
}
