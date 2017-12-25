class Dealer {
    private Hand dealerHand = new Hand();

    /**
     * prints the dealer's output in the window
     */
    public Dealer () {
        dealerHand.createDeck();
        dealerHand.shuffleDeck();
    }

    /**
     * prints cards in dealer's hand
     */
    public void initDeal() {
        dealerHand.initialDeal();
        dealerHand.printHand();
        dealerHand.evaluateHand();
    }

    /**
     * returns the numerical value of the cards in dealer's hand
     */
    public int getHandValue () {
        return dealerHand.evaluateHand();
    }

    public boolean playHand() {
        // draw cards until dealerHand >= 16
        while (getHandValue() < 16) {
            int handCount = 0;
            for (int i = 0; i < dealerHand.hand.length; i++) {
                if (dealerHand.hand[i] != null){// && handCount > 10) {
                    handCount++;
                }
            } // end for
            dealerHand.hand[handCount] = dealerHand.deal();System.out.print(getHandValue());
        } // end while

        System.out.println ("****************");
        System.out.println ("Dealer's Hand");
        System.out.println ("****************");
        dealerHand.printHand();
        System.out.println ("Dealer's Hand Value = " + getHandValue());
        
        // determine if bust
        if (getHandValue() > 21) {
            System.out.println ("The dealer has busted.");
            return true;
        }
        return false;
    }
    public void printDealerHand() {
        dealerHand.printHand();
    }
} //end class
