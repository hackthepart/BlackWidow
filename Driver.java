class Driver {
    public static void main (String[] args) {
        System.out.println ("Welcome to the BlackJack table!");
        System.out.println ("Best of Luck! :) ");
        System.out.println ("");
        int purse = 100;
        Dealer dealer = new Dealer();
        Player player = new Player(purse);
        boolean some = player.playAgain();
        while (some) {
        	flag:{
        		int get = player.bet(purse);
        		while(get<1) {
        			System.out.println("Minimum bet is on 1 Purse.");
        			break flag;
        		}
	        	System.out.println ("****************");
	            System.out.println ("Dealer's Hand");
	            System.out.println ("****************");
	            dealer.initDeal();
	            System.out.println ("Dealer's Hand value = " + dealer.getHandValue());
	            
	            System.out.println ("****************");
	            System.out.println ("Player's Hand");
	            System.out.println ("****************");
	            player.initDeal();
	            System.out.println ("Player's Hand Value = " + player.getHandValue());
	            
	            if(player.playHand()) {
	            	purse-=get;
	            	some = player.playAgain();
	                dealer = new Dealer();
	                break flag;
	            }
	            System.out.println ("****************");
	            System.out.println ("Player's Hand");
	            System.out.println ("****************");
	            player.printPlayerHand();
	            System.out.println ("Player's Hand Value = " + player.getHandValue());
	            if(dealer.playHand()) {
	            	purse+=get;
	            	some = player.playAgain();
	                dealer = new Dealer();
	                break flag;
	            }
	//            System.out.println ("*************");
	  //          System.out.println ("Dealer's Hand");
	    //        System.out.println ("*************");
	      //      dealer.printDealerHand();
	        //    System.out.println ("Dealer's Hand Value = " + dealer.getHandValue());
	            
	            purse+=player.compareHands(dealer.getHandValue(),get);
	            System.out.print ("Purse = ");
	            System.out.println (purse);
	            System.out.println ("");
	            some = player.playAgain();
	            dealer = new Dealer();
	            System.out.print("");
	        }
        }
        if(purse>100) {
        	System.out.println("You are in profit of " + (purse-100));
        }
        else {
        	System.out.println("You are in loss of " + (100-purse));
        }
        System.out.println ("See you Bro!");
    } //end main method
} //end class
