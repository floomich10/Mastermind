
public class mastermindGame{

  private int pegNumber;
  private int pegColours;

  public mastermindGame(int pegNumber, int pegColours) {

    this.pegNumber = pegNumber;
    this.pegColours = pegColours;

  }

  public int getPegNumber() {
    return pegNumber;
  }

  public void setPegNumber(int pegNumber) {
    this.pegNumber = pegNumber;
  }

  public int getPegColours() {
    return pegColours;
  }

  public void setPegColours(int pegColours) {
    this.pegColours = pegColours;
  }

  public String toString() {

    String masterString;

    masterString = "Amount of pegs: " + this.pegNumber + " | Peg colours: " + this.pegColours;

    return masterString;
  }

}

    

