import java.util.*;

class Hand {
    private static Card[] deck = new Card[52];
    Card[] hand = new Card[10];
    private static int index;
    /**
     * method creates the deck
     */
    public static void createDeck () {
        int m = 0;
        for (int j = 0; j < 4; j++) {
            for (int k = 1; k < 14; k++) {
                deck[m] = new Card(j,k);
                m++;
            }
        }
        index = 0;
    } //end createDeck

    public static Card deal () {
        index++;
        return deck[index-1];
    } //end deal

    /**
     * para@1 card c1
     * para@1 card c2
     * method compares two cards at a time
     * returns value accroding to the comparison
     */
    public static int compareCard (Card c1, Card c2) {
        if (c1.getSuit() > c2.getSuit()) return 1;
        if (c1.getSuit() < c2.getSuit()) return -1;
        if (c1.getRank() > c2.getRank()) return 1;
        if (c1.getRank() < c2.getRank()) return -1;
        return 0;
    } //end compareCard

    /**
     * para@1 int size
     * method prints the cards from the deck
     * no. of cards depens on the value of int size being provided as parameter
     */
/*    public void printDeck (int size) {
        int j = 0;
        while (j < size) {
            deck[j].printCard();
            j++;
        }
    }//end printDeck
*/
    /**
     * para@1 int size
     * method shuffles the deck
     * and prints it
     */
    public static void shuffleDeck () {
        Random rd= new Random();

        //create a local Card object
        Card temp = null;
        for (int i = 0; i < deck.length; i++) {
            // choose a random number between 0 and number of cards in the deck - 1
            int random = rd.nextInt(52);
            //swap ith position card with random position card.
            temp = deck[i];
            deck[i] = deck[random];
            deck[random] = temp;
        }
    }

    public void initialDeal() {
        int m = 10;

        for (int n = 0; n < m; n++) {
            hand[n] = null;
        }

        for (int h = 0; h < 2; h++) {
            Card temp = deal();
            hand[h] = temp;
        }
    }

    public void printHand() {
        for (int g = 0; hand[g]!=null; g++) {
            if (hand[g] != null) {
                hand[g].printCard();
            } else {
                System.out.println ("Null Card");
            }
        }
    }

    public int evaluateHand() {
        int u = 0;
        for(int k= 0; hand[k] != null ; k++) {
            int a = hand[k].getRank();
            String ok = Integer.toString(a);
            if (ok.equals(("13"))) {
                u = u + 10;
            }else if (ok.equals(("12"))) {
                u = u + 10;
            } else if (ok.equals(("11"))) {
                u = u + 10;
            } else if (ok.equals(("1"))) {
                u = u + 11;
            } else {
                u = u + a;
            }
        }
        return u;
    }
} //end class
