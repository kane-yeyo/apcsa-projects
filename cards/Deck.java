package cards;

public class Deck {
    private Card[] cards = new Card[52];
    private int index = 0;

    public Deck() {
        int k = 0;
        for (int s = 0; s < 4; s++) {
            for (int v = 0; v < 13; v++) {
                cards[k++] = new Card(s, v);
            }
        }
    }

    public void shuffle() {
        for (int i = 0; i < cards.length; i++) {
            int r = (int)(Math.random() * cards.length);
            Card temp = cards[i];
            cards[i] = cards[r];
            cards[r] = temp;
        }
        index = 0;
    }

    public void cut(int n) {
        Card[] temp = new Card[52];
        int k = 0;

        for (int i = n; i < cards.length; i++) {
            temp[k++] = cards[i];
        }
        for (int i = 0; i < n; i++) {
            temp[k++] = cards[i];
        }

        cards = temp;
        index = 0;
    }

    public Card draw() {
        if (index >= cards.length) {
            return null;
        }
        return cards[index++];
    }

    public void print(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(cards[i] + " ");
        }
        System.out.println();
    }
}
