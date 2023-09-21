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

    int correctPegs = 0;
    int correctColours = 0;

    
    System.out.println("Welcome to Mastermind!");


    System.out.println("Enter the number of pegs (2-10): ");
    mastermind.setPegNumber(input.nextInt());

    if (mastermind.getPegNumber() > 10){
      mastermind.setPegNumber(10);
      System.out.println("Out of Bounds: Pegs set to 10");
    }
    if (mastermind.getPegNumber() < 2){
      mastermind.setPegNumber(2);
      System.out.println("Out of Bounds: Pegs set to 2");
    }
    
    System.out.println("Enter the number of colours (2-9): ");
    mastermind.setPegColours(input.nextInt());

    if (mastermind.getPegColours() > 9){
      mastermind.setPegColours(9);
      System.out.println("Out of Bounds: colours set to 9");
    }
    if (mastermind.getPegColours() < 2){
      mastermind.setPegColours(2);
      System.out.println("Out of Bounds: Colours set to 2");
    }

    System.out.println(mastermind.toString());

    // guesses = (pegNum + pegVariation)
    guess.setGuesses(mastermind.getPegNumber() + mastermind.getPegColours());

    System.out.println("Since you selected " + mastermind.getPegNumber() + " pegs, and a selection between " + mastermind.getPegColours() + " colours, you will be given " + guess.getGuesses() + " chances to guess the correct combination.");


  // create ANSWER array
    for (int x = mastermind.getPegNumber(); x > 0; x--) {
        int randColour = (int)(Math.random()*mastermind.getPegColours()) + 1;

      Peg peg = new Peg(randColour);

      answer.add(peg);
    }

    // print answer (remove later)
    for (Peg i : answer) {
      
      System.out.println(i.getColour());
    }

    for (int g = 0; g < guess.getGuesses(); g++) {

      System.out.println("Guess " + (g + 1));

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

        if (answer.contains(guessPosition.getColour())) {

          correctColours++;
        }
      }
      
      userGuess.clear();
      System.out.println(correctPegs);
      System.out.println(correctPegs);
      correctPegs = 0;
      correctColours = 0;


      

    }

    // print guess (remove later)
    for (Peg z : userGuess) {
      
      System.out.println(z.getColour());
    }

  if 




  }// end main

}