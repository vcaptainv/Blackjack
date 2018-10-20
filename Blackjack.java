/**
 * File: Blackjack.java
 * Author: Yusheng Hu
 * Date: 09/17/2016
 */
 
 import java.util.ArrayList;
 import java.util.Random;

 
 public class Blackjack{
 	// create two hand objects: player's hand and dealer's hand.
 	// create a new deck.
 	private Hand playerhand;
 	private Hand dealerhand ;
 	private Deck deck;

 	
 	// clear the cards in dealer's hand and player's hand, create a new deck and call reset function.
 	public Blackjack(){
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
 		for(int i = 0; i < 2; i ++){
			playerhand.add(deck.deal());
			dealerhand.add(deck.deal());
		}
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
		
		while(playerhand.getTotalValue() < 18){
			Card n = new Card(1);
			n = deck.deal();
			playerhand.add(n);
			System.out.println("The play gets card: " + n.getValue());
			
			
		}
		if (playerhand.getTotalValue() > 21){
			
			return false;
		}
		else {
			return true;		
		}
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
		Blackjack game = new Blackjack();
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
		//for(int i=0; i<3; i++){	
		System.out.println("---------------------------The blackjack game starts---------------------------");
		Blackjack game = new Blackjack();

		game.deal();
		System.out.println(game.toString());	
	
		if (game.playerTurn()  == false){
			System.out.println("****************************the player busts*********************************");
			System.out.println("---------------------------Game Over, the dealer wins---------------------------");
		}
	
		else if (game.dealerTurn() == false){
			System.out.println("****************************The dealer busts*********************************");
			System.out.println("---------------------------Game Over, the player wins---------------------------");
		}
	
	
		else if (game.playerhand.getTotalValue() > game.dealerhand.getTotalValue() ) {
			System.out.println("---------------------------Game Over, the player wins---------------------------");
		
		}
	
		else 	if (game.playerhand.getTotalValue() < game.dealerhand.getTotalValue() ) {
			System.out.println("---------------------------Game Over, the dealer wins---------------------------");
		
		}
	
		else if (game.playerhand.getTotalValue() == game.dealerhand.getTotalValue()){
			System.out.println("-----------------------------------Push------------------------------------");
		}
		
		System.out.println("The sum of cards in player's hand: " + game.playerhand.getTotalValue());
		System.out.println("The sum of cards in dealer's hand: " + game.dealerhand.getTotalValue());
		//}	
		
	}
	
	
 }