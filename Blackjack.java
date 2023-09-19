import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //declare once
        P1Random rand = new P1Random(); //declare once
//initialize variables
        int playerWins = 0;
        int dealerWins = 0;
        int tieGames = 0;
        int totalGames = 0;
        boolean continueGame = true;


//initial output when user starts game-not part of game loop
// while loop ensures game starts over when someone wins
while (continueGame) {
    int cardValue = rand.nextInt(13) + 1;
    int handValue = 0;
    boolean thisGame = true;

    System.out.println("START GAME #" + (totalGames + 1));
    System.out.println(); //skip a line
            //add initial value of card to players hand
            if (cardValue == 13) {
                System.out.println("Your card is a KING!");
                handValue = handValue + 10;
            } else if (cardValue == 12) {
                System.out.println("Your card is a QUEEN!");
                handValue = handValue + 10;
            } else if (cardValue == 11) {
                System.out.println("Your card is a JACK!");
                handValue = handValue + 10;
            } else if (cardValue == 1) {
                System.out.println("Your card is a ACE!");
                handValue = handValue + 1;
            } else {
                System.out.println("Your card is a " + cardValue + "!");
                handValue = handValue + cardValue;
            }

            System.out.println("Your hand is: " + handValue); //print hand value
            System.out.println(); //skip a line

            while (thisGame) {
                //print option menu
                System.out.println("1. Get another card");
                System.out.println("2. Hold hand");
                System.out.println("3. Print statistics");
                System.out.println("4. Exit");
                System.out.println(); //skip a line
                System.out.print("Choose an option: ");
                int menuChoice = scanner.nextInt(); // user inputs menu choice
                System.out.println(); //skip a line

        //run section of code based on menu choice

                //user chooses to get another card
                if (menuChoice == 1) {
                    cardValue = rand.nextInt(13) + 1;
                    if (cardValue == 13) {
                        System.out.println("Your card is a KING!");
                        handValue = handValue + 10;
                    } else if (cardValue == 12) {
                        System.out.println("Your card is a QUEEN!");
                        handValue = handValue + 10;
                    } else if (cardValue == 11) {
                        System.out.println("Your card is a JACK!");
                        handValue = handValue + 10;
                    } else if (cardValue == 1) {
                        System.out.println("Your card is a ACE!");
                        handValue = handValue + 1;
                    } else {
                        System.out.println("Your card is a " + cardValue + "!");
                        handValue = handValue + cardValue;
                    }
                    System.out.println("Your hand is: " + handValue); //print hand value
                    System.out.println(); //skip line

                    //determine if hand wins or loses
                    if (handValue == 21) {
                        System.out.println("BLACKJACK! You win!");
                        playerWins = playerWins + 1;
                        thisGame = false;
                    } else if (handValue > 21) {
                        System.out.println("You exceeded 21! You lose.");
                        System.out.println(); //skip a line
                        dealerWins = dealerWins + 1;
                        thisGame = false;
                    }
                }
                //user chooses to hold hand
                else if (menuChoice == 2) {
                    int dealerHand = rand.nextInt(11) + 16; //dealer hand is assigned a random number
                    System.out.println("Dealer's hand: " + dealerHand);
                    System.out.println("Your hand is: " + handValue);
                    System.out.println(); //skip a line
                    //check who wins
                    if (dealerHand > 21) {
                        System.out.println("You win!");
                        System.out.println(); //skip a line
                        playerWins = playerWins + 1;
                        thisGame = false;
                    } else if (dealerHand == handValue) {
                        System.out.println("It's a tie! No one wins!");
                        System.out.println(); //skip a line
                        tieGames = tieGames + 1;
                        thisGame = false;
                    } else if (dealerHand < handValue) {
                        System.out.println("You win!");
                        System.out.println(); //skip a line
                        playerWins = playerWins + 1;
                        thisGame = false;
                    } else {
                        System.out.println("Dealer wins!");
                        System.out.println(); //skip a line
                        dealerWins = dealerWins + 1;
                        thisGame = false;
                    }
                }
                //user chooses to print statistics
                else if (menuChoice == 3) {
                    double playerWinsDouble = playerWins;
                    double totalGamesDouble = totalGames;
                    double percentWins = Math.round((playerWinsDouble/totalGamesDouble) * 100);
                    System.out.println("Number of Player wins: " + playerWins);
                    System.out.println("Number of Dealer wins: " + dealerWins);
                    System.out.println("Number of tie games: " + tieGames);
                    System.out.println("Total # of games played is: " + totalGames);
                    System.out.println("Percentage of Player wins: " + percentWins + "%");
                    System.out.println(); //skip a line
                }
                //user chooses to exit
                else if (menuChoice == 4) {
                    thisGame = false;
                    continueGame = false;
                }
                //user inputs a number outside the range
                else {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter an integer value between 1 and 4.");
                    System.out.println(); //skip a line
                }
            }
            totalGames = totalGames + 1;
        }
    }
}
