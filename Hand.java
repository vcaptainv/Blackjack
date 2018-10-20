/**
 * File: Hand.java
 * Author: Yusheng Hu
 * Date: 09/17/2016
 */


import java.util.ArrayList;
 

public class Hand { 

	private ArrayList<Card> hand;
	
	// initialize the ArrayList.
	
	public Hand() {
		this.hand = new ArrayList<Card>();
		
	}

	//reset the hand to empty.		
	public void reset(){
		this.hand.clear();
	}
	
	//add the card object to the hand.
	public void add(Card card){
		
		this.hand.add(card);
		
	}
	//returns the number of cards in the hand.
	public int size(){		
		return this.hand.size();
	}
	
	
	//Returns the card with index i. 
	public Card getCard(int i){
		return this.hand.get(i);	
	}
	
	//Returns the sum of the values of the cards in the hand.
	public int getTotalValue(){
		int c = this.hand.size();
		int sum = 0;
		for (int i=0; i<c; i++){
			Card d = this.hand.get(i);
			
			sum += d.getValue();
		}
		return sum;
	}
	
	//Returns a String that has the contents of the hand "written" in a nice format.
	public String toString(){
		String a = "", b;
		
		int i = this.hand.size();
		for (int j=0; j<i; j++){
			Card d = this.hand.get(j);
			b= "The "+ j + " card is " + d.getValue() + ", ";
			a= a + b;	
		}
		return a;
	}
	// Test function
	//Make two card 8 and 9 and add them to hand card. Test the function if works.
	public static void main(String[] args){
		Hand h = new Hand();
		Card card1 = new Card(8);
		Card card2 = new Card(9);
		h.add(card1);
		h.add(card2);
		System.out.println(h.toString());
		System.out.println(h.getTotalValue());
	}
}	
		