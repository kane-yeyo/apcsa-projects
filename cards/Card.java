package cards;

public class Card {
    private int suit;
    private int value;

    private static String[] SUITS = {"♦", "♣", "♥", "♠"}; //copied symbols from online
    private static String[] VALUES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    public Card(int suit, int value) { 
        if (suit < 0) suit = 0;
        if (suit > 3) suit = 3;
        this.suit = suit; //0 to 3 since there are 4 elements in SUITS

        if (value < 0) value = 0;
        if (value > 12) value = 12;
        this.value = value; //0 to 12 since there are 13 elements in VALUES
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return SUITS[suit] + VALUES[value];
    }
}
