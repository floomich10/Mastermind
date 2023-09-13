import java.util.Scanner;

class Main {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    mastermindGame mastermind = new mastermindGame(0, 0);

    
    System.out.println("Welcome to Mastermind!");


    System.out.println("Enter the number of pegs (1-10): ");
    mastermind.setPegNumber(input.nextInt());

    System.out.println("Enter the number of colours (1-9): ");
    mastermind.setPegColours(input.nextInt());

    input.close();

    System.out.println(mastermind.toString());
    





  }

}

