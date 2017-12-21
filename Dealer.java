class Dealer {
    private Hand dealerHand = new Hand();

    /**
     * prints the dealer's output in the window
     */
    public Dealer () {
        dealerHand.createDeck();
        // prints initial deck
        //System.out.println("Initial deck");
        //System.out.println("****************");
        //dealerHand.printDeck(5);
        //System.out.println("");
        // prints shuffled deck
        //System.out.println ("Shuffled Deck");
        //System.out.println("****************");
        dealerHand.shuffleDeck(5);
        //System.out.println ("");
        //System.out.println ("Sorted Deck");
        //System.out.println("****************");
        //dealerHand.sortDeck(5);
        //System.out.println ("");
        //System.out.println ("Dealer's Hand");
        //System.out.println ("****************");
        //initDeal();
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

    public void playHand() {
        // draw cards until dealerHand > 16
        while (getHandValue() < 16) {
            int handCount = 0;
            for (int i = 0; i < dealerHand.hand.length; i++) {
                if (dealerHand.hand[i] != null && handCount > 10) {
                    handCount++;
                }
            } // end for
            dealerHand.hand[handCount] = dealerHand.deal();
        } // end while

        System.out.println ("*************");
        System.out.println ("Dealer's Hand");
        System.out.println ("*************");
        dealerHand.printHand();
        // determine if bust
        if (getHandValue() > 21) {
            System.out.println ("The dealer has busted.");
        }
    }
} //end class
