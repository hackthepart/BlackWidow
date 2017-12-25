import java.util.InputMismatchException;
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
    public int compareHands(int dealerHandValue,int get) {
        int playerHandValue = getHandValue();
        if (playerHandValue > dealerHandValue && playerHandValue <= 21) {
            System.out.println ("*** Player Wins");
            return get;
        } else if ( playerHandValue < dealerHandValue && dealerHandValue <= 21) {
            System.out.println ("*** Dealer Wins");
            return -get;
        } else if (playerHandValue == dealerHandValue) {
            System.out.println ("*** That's a Tie");
            return 0;
        }
        return 0;
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
        int ok = 0,bet=0;
        System.out.print("Purse = ");
        System.out.println(purse);
        System.out.print ("How much would you like to bet? ");
        boolean continueInput=true;
        do {
        	try{
        		bet = sc.nextInt();
        		continueInput = false;
        	}
        	catch (InputMismatchException ex) {
        		System.out.println("Enter a valid ammount");
        		System.out.print("Purse = ");
                System.out.println(purse);
                System.out.print ("How much would you like to bet? ");
        		sc.nextLine();
        	}
        }
        while (continueInput);
        while(bet>purse){
        		System.out.println ("You don't have enough purse ");
        		System.out.print("Purse = ");
                System.out.println(purse);
        		System.out.print ("How much would you like to bet? ");
        		continueInput=true;
                do {
                	try{
                		bet = sc.nextInt();
                		continueInput = false;
                	}
                	catch (InputMismatchException ex) {
                		System.out.println("Enter a valid ammount");
                		System.out.print("Purse = ");
                        System.out.println(purse);
                		System.out.print ("How much would you like to bet? ");
                		sc.nextLine();
                	}
                }while (continueInput);
        }
        ok = bet;
        return ok;
    }

    public boolean playHand() {
    	System.out.print ("Would you like to draw another card? ");
        while(sc.next().equals("y")) {
            int handCount = 0;
            for (int i = 0; i < playerHand.hand.length; i++) {
                if (playerHand.hand[i] != null) {
                    handCount++;
                }
            }
            playerHand.hand[handCount] = playerHand.deal();
            System.out.println ("****************");
            System.out.println ("Player's Hand");
            System.out.println ("****************");
            playerHand.printHand();
            System.out.println ("Player's Hand Value = " + getHandValue());
            if (getHandValue() > 21) {
                System.out.println ("The player has busted.");
                return true;
            }
            System.out.print ("Would you like to draw another card? ");
        }
        return false;
    }
    
    public void printPlayerHand() {
        playerHand.printHand();
    }
}
