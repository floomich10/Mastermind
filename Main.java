import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.Objects;

class Main {

  

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    mastermindGame mastermind = new mastermindGame(0, 0);
    Guess guess = new Guess(0);
    
   
    ArrayList<Peg> answer = new ArrayList<Peg>();
    ArrayList<Peg> userGuess = new ArrayList<Peg>();
    ArrayList<Integer> alreadyGuessed = new ArrayList<Integer>();

    int correctPegs = 0;
    int correctColours = 0;
    boolean won = false;
    boolean running = true;

    while (running == true) {

      System.out.println("Welcome to Mastermind!");


      System.out.print("Enter the number of pegs (2-10): ");
      mastermind.setPegNumber(input.nextInt());

      if (mastermind.getPegNumber() > 10){
        mastermind.setPegNumber(10);
        System.out.println("Out of Bounds: Pegs set to 10");
      }
      if (mastermind.getPegNumber() < 2){
        mastermind.setPegNumber(2);
        System.out.println("Out of Bounds: Pegs set to 2");
      }
    
      System.out.print("Enter the number of colours (2-9): ");
      mastermind.setPegColours(input.nextInt());

      if (mastermind.getPegColours() > 9){
        mastermind.setPegColours(9);
        System.out.println("Out of Bounds: colours set to 9");
      }
      if (mastermind.getPegColours() < 2){
        mastermind.setPegColours(2);
        System.out.println("Out of Bounds: Colours set to 2");
      }

    // guesses = (pegNum + pegVariation)
      guess.setGuesses(mastermind.getPegNumber() + mastermind.getPegColours());

      System.out.println("Since you selected " + mastermind.getPegNumber() + " pegs, and a selection between " + mastermind.getPegColours() + " colours, you will be given " + guess.getGuesses() + " chances to guess the correct combination.");
      int totalGuesses = guess.getGuesses();


  // create ANSWER array
      for (int x = mastermind.getPegNumber(); x > 0; x--) {
          int randColour = (int)(Math.random()*mastermind.getPegColours()) + 1;

        Peg peg = new Peg(randColour);

        answer.add(peg);
      }

      for (int g = 0; g < guess.getGuesses(); g++) {

        System.out.println("---------------------");
        System.out.println("Guess " + (g + 1) +"/" + totalGuesses + ": ");

        for (int p = 0; p < mastermind.getPegNumber(); p++) {

          System.out.print("Colour for peg " + (p + 1) + ": ");
          int inputedGuess = input.nextInt();

          Peg peggy = new Peg(inputedGuess);
          userGuess.add(peggy);

        }

        for (int z = 0; z < answer.size(); z++) {

          Peg answerPosition = answer.get(z);
          Peg guessPosition = userGuess.get(z);

          if (answerPosition.getColour() == guessPosition.getColour()) {

            correctPegs++;

          }

          for (int a = 0; a < answer.size(); a++) {

            if (answer.get(a).getColour() == guessPosition.getColour()) {

              if (!(alreadyGuessed.contains(guessPosition.getColour()))) {

                correctColours++;
                alreadyGuessed.add(guessPosition.getColour());
              }
            }
          }
        }
      
        userGuess.clear();
        alreadyGuessed.clear();
        System.out.println("You have " + correctPegs + " peg(s) correct and " + correctColours + " colour(s) correct.");

        if (correctPegs == answer.size()){

        System.out.println("Congratulations! You've won!");
        guess.setGuesses(0);
        won = true;

        }//are ya winning son?
      
        correctPegs = 0;
        correctColours = 0;


      

      }


      if (won != true) {
        
        System.out.println("---------------------");
        System.out.println("Sorry, you lost. The correct combination was: ");
        for (Peg z : answer) {
      
        System.out.print(z.getColour() + " ");
        }
        System.out.println("\n");
      }

      System.out.print("Would you like to play again? (Y = 1/N = 2): ");
      int response = input.nextInt();
      

      if (response == 1) {

        System.out.println("Running program again!");
        System.out.println("---------------------");
      } else if (response == 2) {

        System.out.println("Exiting program, thank you for playing!");
        running = false;
      } else {

        System.out.println("Inproper input, exiting program.");
        running = false;
      }

      
    }
    
    
      


  }// end main

}