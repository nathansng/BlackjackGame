package blackjackgame;

import java.util.*;
import java.util.Scanner;

//Nathan Ng
 
public class BlackjackGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int total = 0; //to display the sum of the cards
        char play = 'y'; //to continue the game or play again
        char drawAgain; //to draw another card, makes play = 'y'
        boolean firstTry = true; //draws two cards instead of one for the beginning of the game
        ArrayList <Integer> cards = new ArrayList<Integer>(); //to store all card numbers
        
        //variables for the dealer
        int dealerTotal = 0;
        
        while (play == 'y') {
            total = 0; //reset the total each round
            
            //to draw two cards in total
            if (firstTry == true) {
                cards.add(random());
                
                dealerTotal = random();
                System.out.println("The dealer drew a " + dealerTotal);
                
                firstTry = false;
            }
            
            //the one card drawn always
            cards.add(random());
            System.out.print("Your cards: " + cards.get(0)); //displays the card numbers
            
            //calculates the first card number
            total = total + cards.get(0);
            
            //display the rest of the cards
            for (int i = 1; i < cards.size(); i ++) {
                System.out.print(", " + cards.get(i));
                //calculates the rest of the card numbers
                total = total + cards.get(i);
            }
            System.out.println();
            
            //displays the total sum of cards
            System.out.println("Total: " + total);
            
            //checks if you busted
            if (total > 21) {
                System.out.println("You busted");
                System.out.println("You lost");
                System.out.print("Do you want to play again? (y/n): ");
                //player decides to play again or not
                play = input.next().charAt(0);    
                System.out.println();
                
                //resets the arraylist for the new game
                for (int i = cards.size() - 1; i >= 0; i --) {
                    cards.remove(i);
                }
                //resets the game to draw two cards at the beginning
                firstTry = true;
                
            //checks if the total is equal to 21
            } else if (total == 21) {
                System.out.println("You got 21!");
                
                play = 'n';
                System.out.println("Dealer has a " + dealerTotal);
    
                //deals until greater than or equal to 17
                while (dealerTotal < 21) {
                    int added = random();
                    char nextDraw;
                    dealerTotal = dealerTotal + added;
                    System.out.print("(Press c to continue) ");
                    nextDraw = input.next().charAt(0);
                    if (nextDraw == 'c') {
                        System.out.println("The dealer draws a " + added);
                        System.out.println("Dealer's Total: " + dealerTotal);
                    }
                }
                    
                //checks if you won or the dealer won
                if (dealerTotal > 21) {
                    System.out.println("Dealer busted");
                    System.out.println("You win!");
                } else if (total > dealerTotal) {
                    System.out.println("You win!");
                } else {
                    System.out.println("Push!");
                }
                
                System.out.print("Do you want to play again? (y/n): ");
                //decide to play again
                play = input.next().charAt(0);
                System.out.println();
                
                //resets the arraylist
                for (int i = cards.size() - 1; i >= 0; i --) {
                    cards.remove(i);
                }
                
                //draw two cards next
                firstTry = true;

            //otherwise the total is less than 21
            } else {
                System.out.print("Hit? (y/n): ");
                
                //checks if player wants to draw
                drawAgain = input.next().charAt(0);
                
                //loops back to the beginning, skips first card draw
                if (drawAgain == 'y') {
                    play = 'y';
                    
                } else { //begins the rest of the dealer's actions
                    play = 'n';
                    System.out.println("Dealer has a " + dealerTotal);
                    
                    //deals until greater than or equal to 17
                    while (dealerTotal < 17) {
                        int added = random();
                        char nextDraw;
                        dealerTotal = dealerTotal + added;
                        System.out.print("(Press c to continue) ");
                        nextDraw = input.next().charAt(0);
                        if (nextDraw == 'c') {
                            System.out.println("The dealer draws a " + added);
                            System.out.println("Dealer's Total: " + dealerTotal);
                        }
                    }
                    
                    //checks if you won or the dealer won
                    if (dealerTotal > 21) {
                        System.out.println("Dealer busted");
                        System.out.println("You win!");
                    } else if (total > dealerTotal) {
                        System.out.println("You win!");
                    } else if (total < dealerTotal) {
                        System.out.println("You lost");
                    } else {
                        System.out.println("Push!");
                    }
                    
                    //asks for a new game
                    System.out.print("Do you want to play again? (y/n): ");
                    //player decides to play again
                    play = input.next().charAt(0);
                    System.out.println();

                    //resets the arraylist
                    for (int i = cards.size() - 1; i >= 0; i --) {
                        cards.remove(i);
                    }

                    //draw two cards again at beginning of new game
                    firstTry = true;
                }
                
            }
            
        }
    }
    
    public static int random () {
        Random random = new Random();        
        return (random.nextInt(10) + 1); //returns a random number from 1 to 10
    }
    

}
