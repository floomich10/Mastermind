import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

class Main {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    mastermindGame mastermind = new mastermindGame(0, 0);
    Guess guess = new Guess(0);
  
    // ArrayList<String> pegs = new ArrayList<String>();
  
   // pegs.add();
    // pegs.add();
    
   
    ArrayList<Peg> answer = new ArrayList<Peg>();

    
    System.out.println("Welcome to Mastermind!");


    System.out.println("Enter the number of pegs (1-10): ");
    mastermind.setPegNumber(input.nextInt());

    System.out.println("Enter the number of colours (2-9): ");
    mastermind.setPegColours(input.nextInt());

    input.close();

    System.out.println(mastermind.toString());

    // guesses = (pegNum + pegVariation)
    guess.setGuesses(mastermind.getPegNumber() + mastermind.getPegColours());

    System.out.println("Since you selected " + mastermind.getPegNumber() + " pegs, and a selection between " + mastermind.getPegColours() + " colours, you will be given " + guess.getGuesses() + " to guess the correct combination.");


  // create ANSWER array
    for (int x = mastermind.getPegNumber(); x > 0; x--) {
        int randColour = (int)(Math.random()*mastermind.getPegColours()) + 1;

      Peg peg = new Peg(randColour);

      answer.add(peg);
    }


    for (Peg i : answer) {
      
      System.out.println(i.getColour());
    }
    



      




  }

}