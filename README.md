# Blackjack
In this project, we are asked to use the programming language, Java, to make a game called Blackjack. In the process of making the whole game, we are forced to learn more about the coding syntax and specialities of Java and also get familiar with the idea of data structures, which is the main topic of this course.

From task 1 to 4, we are asked to build up different classes to serve the specific function. 

Task1

Class Card is a simple class, and it creates card object that contains a value. By getValue() function, we can access the value of a specific card object from other place, which is very importantin the latter coding. 

Task2

In Hand class, we are manipulating ArrayLists of card objects, which represents the cards in one's hand (dealer/player). We created several methods for future usage, but none of them is complicated. 

Task3

In Deck class, we are trying to make an object of deck that holds cards the dealer and player play. In the build() function, we created 52 card objects with specified values. In the deal() function, we made the "deal" process that took the top card of the deck and gave it to one of the caller (dealer/player). One interesting function under this class is the function shuffle(). In the shuffle() function, I used the same method as I did in the lab. Basically, I randomly picked one card from the deck and put it to the last position of the deck Arraylist, and I repeated this process 52 times, to make sure that every position has been randomized at least once. 

Task4

Then, it comes to the major task --- to build Blackjack() class, which basically is the core of the game. Under this class, I first created two Hand objects to represent both sides of player and dealer, and also I created a Deck object that contains a well-built deck of cards. Then, I began to create functions under this class.The Blackjack(), reset(), deal(), toString() are functions that are easily constructed. The core in constructing this methods is to remember the type of each variable/object. The trick parts under this task is the playerTurn() and dealerTurn() functions and the main function. 

In playreTurn() function, I used several if statements to determine whether the function return false or true. In particular, the boolean value that this function returns can nicely help me to decide what action should player make in the main function. The dealerTurn() function has almost the same function as the playerTurn(), but it is designed to help me to decide what action should dealer make in the main function. Finally, we have to buildup the main function of the Blackjack class, which is basically the function that combines all 
the stuffs I built and ran the game. First in the main function, I created a Blackjack object called game. Then I printed "Game Begins" to signify that the game starts now. 

Then, I ran the function blackjack(). deal. playerTurn and dealerTurn to make sure that both sides have at least two cards, and I assigned the total value of player/dealer to two variables, a and b, respectively. Then, I used a while loop. As there's no way that two cards has the total value greater than 21, the code must enter the while loop. Inside the loop, I created my own way of the gaming process. and the determinant of winner. To be noticed, when game.playerTurn() or game.dealerTurn() returns true, meaning that the total value of either of
them falls into the acceptable range, I changed the turn to the opponent and let the opponent deicide whether he deals a card or not. Also, I let the player keep dealing cards until his point is greater or equal to 16 while dealer keep dealing cards until 17 points or higher. At the end, as I wrote "game.reset(true)" outside the loop, I made the deck reshuffle every game.  

Task5

I added a for loop to run the game three times, and send the result to the mygames.txt. 

Task6

This task is basically copying the code from the main function to another function, which I called returnNumber(). In this function, I ran the game and used if statement to determine whether I should return 1 for player's winning, or -1 for dealer's winning or 0 for the push.  
Task7

In this task, I created a new class called Simulation. I only made a main function in this class, and I created a Blackjack object called bj to run the returnNumber() function in Blackjack class. Basically, i used a for loop to have a 

1000 simulations, and I counted the number of times when dealer wins/ player wins/ push. And at last, I used the winning times divided by the total simulation times to get the rate of player wins the game/the rate of dealer wins the game/the push rate. 
