package cards;

public class Hand {
    private Card[] cards;
    private int size = 0;
    public Hand(int max) { //max for the maximum size of the hand
        cards = new Card[max];
    }

    public void add(Card c) { //c is the card being added, check s if the hand is full
        if (size < cards.length) {
            cards[size++] = c;
        }
    }

    public int length() { //returns how many cards the hand contains
        return size;
    }

    public Card get(int i) {
        if (i < 0 || i >= size) { //checks if index is valid
            return null;
        }
        return cards[i]; //returns card at the current position
    }

    public Card remove(int i) {
        if (i < 0 || i >= size) { //checks if index is valid again
            return null;
        }

        Card removed = cards[i];

        for (int j = i; j < size - 1; j++) { //j since you move all cards one step to the left after removing one
            cards[j] = cards[j + 1];
        }


        size--; //size shrinks by one when you remove one
        return removed;
    }

    public String toString() { //makes a string with every card currently in hand
        String s = "";
        for (int i = 0; i < size; i++) {
            s += cards[i] + " ";
        }
        return s;
    }
}
