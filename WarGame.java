package LessionTwo2.LessionTwo2;

import java.util.ArrayList;
import java.util.List;

class WarGame {
    private Deck deck;
    private List<Card> player1Deck;
    private List<Card> player2Deck;

    public WarGame() {
        deck = new Deck();
        deck.initialize();
        deck.shuffle();

        player1Deck = new ArrayList<>();
        player2Deck = new ArrayList<>();

        
        while (!deck.isEmpty()) {
            player1Deck.add(deck.draw());
            player2Deck.add(deck.draw());
        }
    }

    public void play() {
        while (!player1Deck.isEmpty() && !player2Deck.isEmpty()) {
            Card card1 = player1Deck.remove(0);
            Card card2 = player2Deck.remove(0);

            System.out.println("Player 1: " + card1);
            System.out.println("Player 2: " + card2);

            if (compareCards(card1, card2) > 0) {
                System.out.println("Player 1 wins!");
                player1Deck.add(card1);
                player1Deck.add(card2);
            } else if (compareCards(card1, card2) < 0) {
                System.out.println("Player 2 wins!");
                player2Deck.add(card1);
                player2Deck.add(card2);
            } else {
                System.out.println("It's a tie!");
            }
        }

        if (player1Deck.isEmpty()) {
            System.out.println("Player 2 wins the game!");
        } else {
            System.out.println("Player 1 wins the game!");
        }
    }

    private int compareCards(Card card1, Card card2) {
        return card1.getRank().compareTo(card2.getRank());
    }

    public static void main(String[] args) {
        WarGame warGame = new WarGame();
        warGame.play();
    }
}

