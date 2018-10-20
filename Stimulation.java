/**
 * File: Stimulation.java
 * Author: Yusheng Hu
 * Date: 09/18/2016
 */
 
 public class Stimulation{
 	// main function
 	public static void main (String[] args){
 		Blackjack bj = new Blackjack();
 		int playerwin = 0;
 		int dealerwin = 0;
 		int push = 0;
 		int r = 0;
 		// When returnnumber returns 1, the playerwin variable will add one.
 		//When returnnumber returns -1, the dealerwin variable will add one.
 		//When returnnumber returns 0, the push variable will add one.
 		int a = 1000;
 		for(int i = 0; i <a; i++){
			r = bj.returnnumber();
			if (r == 1){
				playerwin = playerwin + 1;
			}
			if (r == -1){
				dealerwin = dealerwin + 1;
			}
 			if (r == 0){
 				push = push + 1;
 			}
 		}
 		float playerwinfloat =100*(float)playerwin/a;
 		float dealerwinfloat =100*(float) dealerwin/a;
 		float pushfloat =100*(float) push/a;
 		System.out.println("The player has won " + playerwin + " times, percent: " + playerwinfloat +"%" );
 		System.out.println("The dealer has won " + dealerwin + " times, percent: " + dealerwinfloat +"%");
 		System.out.println("The game has pushed " + push +"times, percent: " + pushfloat +"%");

	}
}