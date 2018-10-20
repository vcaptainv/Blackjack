/**
 * File: Interactivelackjack.java
 * Author: Yusheng Hu
 * Date: 09/17/2016
 */
 
 import java.util.ArrayList;
 import java.util.Random;
 import java.util.Scanner;
 
 public class Interactiveblackjack{
 	// create two hand objects: player's hand and dealer's hand.
 	// create a new deck.
 	private Hand playerhand;
 	private Hand dealerhand ;
 	private Deck deck;
 	private int money = 100;
 	
 	// clear the cards in dealer's hand and player's hand, create a new deck and call reset function.
 	public Interactiveblackjack(){
 		playerhand = new Hand();
 		dealerhand = new Hand();
 		deck = new Deck();
 		reset(true);
 	}
 	
 	//shuffle the deck, clear the cards in dealer's hand and player's hand, if reshuffle is true
 	public void reset(boolean reshuffle){
 		if (reshuffle == true) {
 			
 			deck.shuffle();
 			playerhand.reset();
 			dealerhand.reset();
 			}
 	}
 	
 	//Give two cards to dealer and player.	
 	public void deal(){
 		
 		playerhand.add(deck.deal());
 		playerhand.add(deck.deal());
 		dealerhand.add(deck.deal());
 	}
 	
 	//Give a string of cards in player and dealer's hand
 	public String toString(){
 		String a = "The cards in player hand are : " + playerhand.toString();
 		String b = "The cards in dealer hand are : " + dealerhand.toString();
 		String c = "State of the game: " + a +"; " + b;
 		return c;
 	}
	
	//player can draw cards until the total value of the cards reaches 16
	// when total value is between 17 and 21, return true 
	// when total value is bigger than 21, player busts, return false
	public boolean playerTurn(){
		Card n = new Card(1);
		Scanner sc = new Scanner(System.in);
		boolean boo = true;
		for(int i =  0; i < 3; i++){
			if (playerhand.getTotalValue() <= 21){
				System.out.println("Do you want another card ? Reply 'Y' to get another card, 'N' to refuse");
			
				if( sc.next().equals("Y")){
					n = deck.deal();
					playerhand.add(n);
					System.out.println("The play gets card: " + n.getValue());
					boo = true;
					
				}
				
				else if (sc.next().equals("N")){
					break;
					//return boo;
				}
			}
			else {
				boo = false;
				
			}	
		}
		return boo;
	}
		
	//dealer can draw cards until the total value of the cards reaches 16
	// when total value is between 17 and 21, return true 
	// when total value is bigger than 21, dealer busts, return false
	public boolean dealerTurn(){
		
		while (dealerhand.getTotalValue() < 17){
			Card n = new Card(1);
			n = deck.deal();
			dealerhand.add(n);
			System.out.println("The dealer gets card: " + n.getValue());
			
		}
		if (dealerhand.getTotalValue() > 21){
			return false;
		}
		else{
			return true;
		}
		
	}
	// When player wins, return 1
	//When dealer wins, return -1
	//When push, returns 0
	public int returnnumber(){
		Interactiveblackjack game = new Interactiveblackjack();
		game.deal();	
		
		if (game.playerTurn()  == false){
			return -1;
		}
		else if (game.dealerTurn() == false){
			return 1;
		}
		else if (game.playerhand.getTotalValue() > game.dealerhand.getTotalValue() ) {
			return 1;
		}
	
		else 	if (game.playerhand.getTotalValue() < game.dealerhand.getTotalValue() ) {
			return -1;
		}
	
		else if (game.playerhand.getTotalValue() == game.dealerhand.getTotalValue()){
			return 0;
		}
	
		return 100;
	}
		
	//test function.
	static public void main( String[] args ){
		Interactiveblackjack game = new Interactiveblackjack();
		
			
			
		System.out.println("---------------------------The blackjack game starts---------------------------");
		
		System.out.println("You have " + game.money + " dollars");
		System.out.println("How much money do you want to bet? Enter number");
		int a = 0;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		game.money = game.money - a ;
	
		game.deal();
		System.out.println(game.toString());	

		if (game.playerTurn()  == false){
	
			System.out.println("****************************the player busts*********************************");
			System.out.println("---------------------------Game Over, the dealer wins---------------------------");
			System.out.println("You have " + game.money + " dollars");
		}

		else if (game.dealerTurn() == false){
			System.out.println("****************************The dealer busts*********************************");
			System.out.println("---------------------------Game Over, the player wins---------------------------");
			game.money = game.money + 2*a;
			System.out.println("Now, You have " + game.money + " dollars");
		}

		
		else if (game.playerhand.getTotalValue() > game.dealerhand.getTotalValue() ) {
			System.out.println("---------------------------Game Over, the player wins---------------------------");
			game.money = game.money + 2*a;
			System.out.println("Now, You have " + game.money + " dollars");
		}

		else if (game.playerhand.getTotalValue() < game.dealerhand.getTotalValue() ) {
			System.out.println("---------------------------Game Over, the dealer wins---------------------------");
			System.out.println("Now, You have " + game.money + " dollars");
		}

		else if (game.playerhand.getTotalValue() == game.dealerhand.getTotalValue()){
			System.out.println("-----------------------------------Push------------------------------------");
			game.money = game.money + a;
			System.out.println("Now, You have " + game.money + " dollars");
		}

		System.out.println("The sum of cards in player's hand: " + game.playerhand.getTotalValue());
		System.out.println("The sum of cards in dealer's hand: " + game.dealerhand.getTotalValue());	
	}
}
	
	
 	