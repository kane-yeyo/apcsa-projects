package cards;

public class Deck {
    private Card[] cards = new Card[52]; //since a standard deck has 52 cards
    private int index = 0; //keeps track of cards drawn

    public Deck() {
        int pos = 0; //pos for position
        for (int s = 0; s < 4; s++) { //s for suit
            for (int v = 0; v < 13; v++) { //v for value
                cards[pos++] = new Card(s, v);
            }
        }
    }

    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int r = (int)(Math.random() * cards.length); //chooses a random card from 0 to 51 (since there are 52 total)
            Card hold = cards[i]; //"hold" since you're temporarily holding onto a card
            cards[i] = cards[r]; //i, the index, becomes r (random)
            cards[r] = hold;
        }
        index = 0; //reset to draw from the top again
    }

    public void cut(int n) { //int n for the number of the card where the cut is at
        Card[] hold = new Card[52];
        int pos = 0;

        for (int i = n; i < cards.length; i++) { //moves bottom to top
            hold[pos++] = cards[i];
        }
        for (int i = 0; i < n; i++) { //moves top to bottom
            hold[pos++] = cards[i];
        }

        cards = hold;
        index = 0;
    }

    public Card draw() {
        if (index >= cards.length) { //if more than 52 cards are drawn, there's nothing left
            return null;
        }
        return cards[index++];
    }

    public void print(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(cards[i] + " ");
        }
        System.out.println(); //displays the first n cards
    }
}
