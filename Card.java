/**
 * File: Card.java
 * Author: Yusheng Hu
 * Date: 09/17/2016
 */
 public class Card{
 	// number is the value of the card.
 	private int number = 0;
 	
 	// Test if the input value is between 1 and 10
 	public Card(int v){
 		if (v >= 1 && v < 11){
 			this.number = v;
 		}
 		else {
 			System.out.println("Input value out of range");
 		}
 	}
 	// Get the value of the card
 	public int getValue(){
 		return this.number;
 	}
 	
 	//Test function
 	public static void main (String[] args){
 		Card card = new Card(10);
 		card.getValue();
 	}
}

