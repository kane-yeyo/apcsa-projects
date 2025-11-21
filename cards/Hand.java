package cards;

public class Hand {
    private Card[] cards;
    private int size = 0;
    public Hand(int max) {
        cards = new Card[max];
    }

    public void add(Card c) {
        if (size < cards.length) {
            cards[size++] = c;
        }
    }

    public int length() {
        return size;
    }

    public Card get(int i) {
        if (i < 0 || i >= size) {
            return null;
        }
        return cards[i];
    }

    public Card remove(int i) {
        if (i < 0 || i >= size) {
            return null;
        }

        Card removed = cards[i];

        for (int j = i; j < size - 1; j++) {
            cards[j] = cards[j + 1];
        }


        size--;
        return removed;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += cards[i] + " ";
        }
        return s.trim();
    }
}

