/**
 * File: Card.java
 * Author: Yusheng Hu
 * Date: 09/17/2016
 */
 
 import java.util.ArrayList;
 import java.util.Random;

public class Deck {
	// deck and shuffle deck are two ArrayList with card objects inside
	private ArrayList<Card> deck;
	private ArrayList<Card> shuffledeck;
	
	// make a new deck by calling build function.
	public Deck(){
		this.deck = new ArrayList<Card>();
		this.shuffledeck = new ArrayList<Card>();
		build();
	}
	
	// Put 4 value 1-9 cards inside the deck and 16 value 10 cards inside the deck.
	public void build(){
		for(int i = 0; i<4; i++){
			for (int j = 1; j < 10; j++){
				Card card = new Card(j);
				deck.add(card);

			}
		}
		for (int k =0; k <16 ; k++){
			Card card10 = new Card(10);
			deck.add(card10);
		}
		
	}
	
	//remove and return the frist card in the deck.
	public Card deal(){
	
 		Card a = deck.remove(0);
 		return a;
	}
	
	//remove and return the number i card in the deck.
	public Card pick (int i){
		Card b = deck.get(i);
		deck.remove(i);
		return b;
	}
	
	//randomly pick a card from an original deck and put it in a new deck (shuffle deck).
	public void shuffle(){
		Random random = new Random();
		int a = deck.size();
		int r = 0;
		for(int i = 0; i < a-1;){
			a = deck.size();
			r = random.nextInt(a-i);
        	this.shuffledeck.add(this.pick(r));   
		}
		this.deck = this.shuffledeck;
	}
	
	//make a string of all the cards in the deck
	public String toString(){
		String a = "", c;
		int b = this.shuffledeck.size();
		
		for(int i = 0; i < b; i++){
			Card d = this.shuffledeck.get(i);
			c= "The "+ i + " card is " + d.getValue() + ", ";
			a= a + c;
		}
		return a;
	}
	//test function. first shuffle and then show the string.
	
	public static void main(String[] args){
		Deck d = new Deck();
		d.shuffle();
		System.out.println(d.toString());
	}
	
	
}
