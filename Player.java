import java.util.Scanner;
class Player {
    private Hand playerHand = new Hand();
    private static int index;
    private int value;
    Scanner sc = new Scanner(System.in);
    /**
     * @para 1 int fine
     * Prints card in player's hand
     */
    public Player (int fine) {
        this.value = fine;
        //System.out.println ("Player's Hand");
        //System.out.println ("****************");
        //initDeal();
    }

    /**
     * method to recognize cards in player's hand
     * evaluate the value of the cards in player's hand
     */
    public void initDeal() {
        playerHand.initialDeal();
        playerHand.printHand();
        playerHand.evaluateHand();
    }

    /**
     * returns the integer value of the cards in player's hand
     */
    public int getHandValue () {
        return playerHand.evaluateHand();
    }

    /**
     * para@1 dealer's hand value
     * compare the values of cards in player's and dealer's hand
     */
    public void compareHands(int dealerHandValue) {
        int playerHandValue = getHandValue();
        if (playerHandValue > dealerHandValue && playerHandValue <= 21) {
            System.out.println ("*** Player Wins");
        } else if ( playerHandValue < dealerHandValue && dealerHandValue <= 21) {
            System.out.println ("*** Dealer Wins");
        } else if (playerHandValue == dealerHandValue) {
            System.out.println ("*** That's a Tie");
        }
    }

    public boolean playAgain () {
        System.out.print ("Would you like to play? [y/n]: ");
        String option = sc.next();
        boolean out = (option.equals("y"));
        if (option.equals("n")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasPurse(int purse) {
        if (purse > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int bet(int purse) {
        int ok = 0;
        System.out.print("Purse = ");
        System.out.println(purse);
        System.out.print ("How much would you like to bet? ");
        int bet = sc.nextInt();
        if (bet <= purse) {
            ok = bet;
        } else {
            ok = bet;
            System.out.println ("Don't have enough purse value");
        }
        return ok;
    }

    public void playHand() {
        System.out.print ("Would you like to draw another card? ");
        String cOption = sc.next();
        if (cOption.equals("n")) {
            //compareHands(dealer.getHandValue());
        } else {
            int handCount = 0;
            for (int i = 0; i < playerHand.hand.length; i++) {
                if (playerHand.hand[i] != null) {
                    handCount++;
                }
            }
            playerHand.hand[handCount] = playerHand.deal();
        }
    }
}
